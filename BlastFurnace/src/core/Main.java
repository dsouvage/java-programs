package core;
import java.awt.Graphics2D;

import org.osbot.rs07.api.model.Item;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.api.ui.Tab;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import org.osbot.rs07.utility.ConditionalSleep;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;


/*
 * THINGS TO DO:
 * create world hopper if someone is chopping there
 * create walk method??
 * add walker to get more hatchets
 * add powerdrop option
 */


@ScriptManifest(author = "Wittyname123", info = "BlastFurnace", version = 0.2, logo = "https://i.imgur.com/kPgPrSc.png", name = "BlastFurnace")
public class Main extends Script {
	private int coalBought;
    private long startTime;
    private int logsPerHour;
    private int storedCoalAmount;
	public static final int STORAGE_COUNT = 26;
	
    
    
    public void Antiban() throws InterruptedException {
    	sleep(random(1000,2000));
    	switch (random(1, 15)) {
    	case 1:
    		getCamera().moveYaw(100 + (random(1, 68)));
    		break;
    	case 2:
    		getCamera().movePitch(50 + (random(1, 69)));
    		break;
    	case 3:
    		getMouse().moveOutsideScreen();
    		sleep(random(756, 2854));
    		break;
    	case 4:
    		getMouse().moveOutsideScreen();
    		sleep(random(1153,8439));
    	case 5: 
    		getMouse().moveOutsideScreen();
    		sleep(random(2023,11233));
    	}	
    	sleep(random(1753,2563));
    }
    
	@Override
	public void onStart() throws InterruptedException {
		log("Let's get started!");
        startTime = System.currentTimeMillis();
        getTabs().open(Tab.INVENTORY);
	}
    
	
	@Override
	public int onLoop() throws InterruptedException {
		
		
		if (getInventory().contains(995)) {
			shop();
		}
		if (inventory.isFull()) {
			bank();
			sleep(random(500,1000));
		}
		if (getPlayers().getAll().size() >= 2) {

			 worlds.hopToP2PWorld();

		} 
	
		return random(200, 300);
	}
	
	private void shop() throws InterruptedException{
		NPC ordan = npcs.closest(1560);
		ordan.interact("Trade");
		sleep(random(1400,2300));
		
		while(store.getAmount(453) >= 95 && !inventory.isFull()) {

			store.buy(453, 50);
			coalBought = coalBought + 26;
			sleep(random(1300,1900));
			store.close();
			sleep(random(300,500));
			fill();
			storedCoalAmount = 26;
			ordan.interact("Trade");
			sleep(random(1400,2300));
			if (store.getAmount(453) < 70) {
				worlds.hopToP2PWorld();
			}
			store.buy(453, 50);
			coalBought = coalBought + 26;
			sleep(random(800,1100));
			
		}
		if (store.getAmount(453) < 100) {
			worlds.hopToP2PWorld();
		}
	}
	
	private void bank() throws InterruptedException{
		Item coalBag = getCoalBag();
		if (!getBank().isOpen()){ //If the bank is not open
			getBank().open(); //Opens bank chests, booths, etc.
			sleep(random(1000,1200));
			storedCoalAmount = 0;
			bank.depositAll(453);
			sleep(random(500,1000));
			coalBag.interact("Empty");
		}
		sleep(random(500,700));
	}
	
	private int getCoalAmount() {
		return (int) inventory.getAmount(453);
	}
	
	private Item getCoalBag() {
		return inventory.getItem("Coal bag");
	}
	
	
	public boolean fill() throws InterruptedException {
		boolean successful = false;
		Item coalBag = getCoalBag();
		int invCoalCount = getCoalAmount();
		int remainingSpace = 26;
		int amountToBeStored = 0;
		ConditionalSleep sleepUntilCoalAddedToBag = null;
		
		if (coalBag == null) {
			
			/* Don't bother returning true/false */
			throw new InterruptedException("No coal bag found!");
			
		} else if (invCoalCount > 0 && remainingSpace > 0) {
			
			/* Calculate the difference for when you store the coal */
			amountToBeStored = (invCoalCount - remainingSpace);
			
			/* Try to fill the coal bag */
			if (coalBag.interact("Fill")) {
				
				/* Sleep for 3.5 seconds (3500) */
				sleepUntilCoalAddedToBag = new ConditionalSleep(3500) {
					@Override
					public boolean condition() throws InterruptedException {
						/* Wake up when the coal has been added */
						return getCoalAmount() != invCoalCount;
					}
				};
				
				/* It shouldn't take us 3.5 seconds to check whether the bag's been filled */
				if (sleepUntilCoalAddedToBag.sleep()) {
					
					storedCoalAmount += amountToBeStored;
					successful = true;
				}
			}
		}
		
		return successful;
	}
	
	

	@Override
	public void onExit() {
		log("Script End");
	}

    // BG Image
    private final Image bg = getImage("https://i.imgur.com/G93HS3q.png");
    private Image getImage(String url)
    {
      try
      {
        return ImageIO.read(new URL(url));
      }
      catch (IOException e) {}
      return null;
    }
	
	
	
    // Paint Method
    @Override
    public void onPaint(Graphics2D g) {
        g.setFont(new Font("Comic Sans", 0, 12));
        g.setColor(new Color(255, 255, 255));
        
        long runTime = System.currentTimeMillis() - startTime;
        logsPerHour = (int)(coalBought / ((System.currentTimeMillis() - this.startTime) / 3600000.0D));
        
        g.drawImage(bg, 5, 345, null);   
        g.drawString(ft(runTime), 210, 375);
        g.drawString("amount of total coal     =  " + coalBought, 187, 463);
        g.drawString("amount of coal per hour  =  " + logsPerHour, 202, 449);
        
        Point mP = getMouse().getPosition();
        // Draw a line from top of screen (0), to bottom (500), with mouse x coordinate
        g.drawLine(mP.x, 0, mP.x, 500);
        // Draw a line from left of screen (0), to right (800), with mouse y coordinate
        g.drawLine(0, mP.y, 800, mP.y);
    }
    
    private String ft(long duration)
    {
            String res = "";
            long days = TimeUnit.MILLISECONDS.toDays(duration);
            long hours = TimeUnit.MILLISECONDS.toHours(duration)
            - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
            long minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
            .toHours(duration));
            long seconds = TimeUnit.MILLISECONDS.toSeconds(duration)
            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
            .toMinutes(duration));
            if (days == 0) {
            res = (hours + ":" + minutes + ":" + seconds);
            } else {
            res = (days + ":" + hours + ":" + minutes + ":" + seconds);
            }
            return res;
    }
}
    
    
    
 

  