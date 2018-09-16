import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.model.Entity;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.api.ui.Message;
import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.api.ui.Tab;
import org.osbot.rs07.script.MethodProvider;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
 
	@ScriptManifest(author = "Wittyname123", info = "Cuts willow trees near Crafting Guild.", name = "Willows - CGuild", version = 0, logo = "")
public class main extends Script {
 
    // BG Image
    private final Image bg = getImage("https://i.imgur.com/jphDGCa.png");
    private Image getImage(String url)
    {
      try
      {
        return ImageIO.read(new URL(url));
      }
      catch (IOException e) {}
      return null;
    }
    
    // Paint Variable
    private long startTime;
    private int costOfItem;
    private int logsCut;
    private int logsPerHour;
    private double gpGained;
    private double totalGpGained;
    private int gpPerHour;
    private int totalGpPerHour;
    private int xpGained;
    private int xpPerHour;
    private int currentXp;
    private int currentLevel;
    private int beginningXp;
    private double nextLevelXp;
    private long timeTNL;
    private double xpTillNextLevel;
    private int beginningLevel;
    private int levelsGained;
    
    final int[] XP_TABLE =
        {
              0, 0, 83, 174, 276, 388, 512, 650, 801, 969, 1154,
              1358, 1584, 1833, 2107, 2411, 2746, 3115, 3523, 3973, 4470, 5018,
              5624, 6291, 7028, 7842, 8740, 9730, 10824, 12031, 13363, 14833,
              16456, 18247, 20224, 22406, 24815, 27473, 30408, 33648, 37224,
              41171, 45529, 50339, 55649, 61512, 67983, 75127, 83014, 91721,
              101333, 111945, 123660, 136594, 150872, 166636, 184040, 203254,
              224466, 247886, 273742, 302288, 333804, 368599, 407015, 449428,
              496254, 547953, 605032, 668051, 737627, 814445, 899257, 992895,
              1096278, 1210421, 1336443, 1475581, 1629200, 1798808, 1986068,
              2192818, 2421087, 2673114, 2951373, 3258594, 3597792, 3972294,
              4385776, 4842295, 5346332, 5902831, 6517253, 7195629, 7944614,
              8771558, 9684577, 10692629, 11805606, 13034431, 200000000
        };
    
    // Area Variables
    private static final Area TREE_AREA = new Area(3049, 3276, 3060, 3265);
    private static final Area BANK_AREA = new Area(3043, 3234, 3047, 3237);
    
    // State Enumerator
    private enum State {
        CHOP, WALK_TO_BANK, BANK, WALK_TO_TREE
    }
    
    // getState Method
    private State getState() {
        if (inventory.isFull() && TREE_AREA.contains(myPlayer())) {
            return State.WALK_TO_BANK;
        }     
        else if (!inventory.isFull() && BANK_AREA.contains(myPlayer())) {
            return State.WALK_TO_TREE;
        }
        else if (inventory.isFull() && BANK_AREA.contains(myPlayer())){
            return State.BANK;
        }
        else {
            return State.CHOP;
        }
    }
    
    public void Antiban() throws InterruptedException {
        switch (random(1, 20)) {
        case 1:
            getCamera().moveYaw(100 + (random(1, 70)));
            break;
        case 2:
            getCamera().movePitch(50 + random(1, 70));
            break;
        case 3:
            sleep(random(800, 2500));
            mouse.moveSlightly();
            break;
        case 4:
            getTabs().open(Tab.SKILLS);
            sleep(MethodProvider.gRandom(400, 900));
            getSkills().hoverSkill(Skill.WOODCUTTING);
            sleep(random(1500,4000));
            getTabs().open(Tab.INVENTORY);
            mouse.moveRandomly();
            break;
        case 5:
        case 6:
        case 7:
            getMouse().moveOutsideScreen();
            sleep(random(1000, 10000));
            break;
        }
        sleep(random(1800,2500));
    }
    
    // Count Logs
    public void onMessage(Message message) throws java.lang.InterruptedException {
        String txt = message.getMessage();
        if (txt.contains("You get some yew logs.")) {
            logsCut++;
        }
    }
    
    // onStart Method
    @Override
    public void onStart() {
        log("Initializing script.");
        
        startTime = System.currentTimeMillis();
        beginningXp = skills.getExperience(Skill.WOODCUTTING);
        beginningLevel = skills.getStatic(Skill.WOODCUTTING);
        timeTNL = 0;
        costOfItem = 363;
    }
 
    // onLoop Method
    @Override
    public int onLoop() throws InterruptedException {
        switch (getState()) {
        case CHOP:
            //log("Debug: CHOP");
            if (!myPlayer().isAnimating()) {
                //log("Debug: CHOP - Player is not animating.");
                RS2Object tree = objects.closest(TREE_AREA, "Yew");
                if (tree != null) {
                    //log("Debug: CHOP - Tree exists.");
                    getTabs().open(Tab.INVENTORY);
                    if(TREE_AREA.contains(myPlayer())) {
                        if (tree.interact("Chop down")) {
                            //log("Debug: CHOP - Cutting tree.");
                            sleep(random(1000, 1500));
                            while (myPlayer().isMoving()) {
                                sleep(random(250, 850));
                            }
                        }    
                    }
                    else {
                        //log("Debug: CHOP - Moving to TREE_AREA");
                        getWalking().webWalk(TREE_AREA);
                    }
                }
                else {
                    //log("Debug: CHOP - Tree does NOT exist, hopping.");
                    worlds.hopToF2PWorld();
                    sleep(random(1500, 2500));
                }
            }
            else if (myPlayer().isAnimating()) {
                Antiban();
            }
            break;
        case WALK_TO_BANK:
            //log("Debug: WALK_TO_BANK");
            getWalking().webWalk(BANK_AREA);
            break;
        case WALK_TO_TREE:
            //log("Debug: WALK_TO_TREE");
            getWalking().webWalk(TREE_AREA);
            break;
        case BANK:
            //log("Debug: BANK");
            Entity depoBox = objects.closest("Bank deposit box");
            if (depoBox != null) {
                //log("Debug: BANK - Deposit Box exists.");
                if (depoBox.interact("Deposit")) {
                    //log("Debug: BANK - Interacting.");
                    while (!depositBox.isOpen()) {
                        //log("Debug: BANK - Deposit Box NOT opened, idling.");
                        sleep(random(250, 1850));
                    }
                     //log("Debug: BANK - Deposit Box opened, depositing logs.");
                     depositBox.depositAllExcept("Mithril axe", "Adamant axe", "Rune axe", "Dragon axe");
                }
            }
            break;
        }
        return 100;
    }
 
    // Paint Method
    @Override
    public void onPaint(Graphics2D g) {
        g.setFont(new Font("Arial", 0, 12));
        g.setColor(new Color(255, 255, 255));
        
        long runTime = System.currentTimeMillis() - startTime;
        gpGained = logsCut * costOfItem;
        totalGpGained = gpGained / 1000;
        gpPerHour = (int)(gpGained / ((System.currentTimeMillis() - this.startTime) / 3600000.0D));
        totalGpPerHour = gpPerHour / 1000;
        logsPerHour = (int)(logsCut / ((System.currentTimeMillis() - this.startTime) / 3600000.0D));
        
        currentXp = skills.getExperience(Skill.WOODCUTTING);
        currentLevel = skills.getStatic(Skill.WOODCUTTING);
        
        xpGained = currentXp - beginningXp;
        xpPerHour = (int)( xpGained / ((System.currentTimeMillis() - this.startTime) / 3600000.0D));
        nextLevelXp = XP_TABLE[currentLevel + 1];
        xpTillNextLevel = nextLevelXp - currentXp;
        if (xpGained >= 1)
        {
            timeTNL = (long) ((xpTillNextLevel / xpPerHour) * 3600000);
        }
        
        currentLevel = skills.getStatic(Skill.WOODCUTTING);
        levelsGained = currentLevel - beginningLevel;
         
        DecimalFormat df = new DecimalFormat("#");
        g.drawImage(bg, 5, 345, null);
        g.drawString("" + ft(timeTNL), 425, 435);     
        g.drawString(df.format(totalGpGained) + "k ", 62, 463);
        g.drawString(df.format(totalGpPerHour) + "k ", 77, 449);
        g.drawString("" + currentLevel, 477, 449);
        g.drawString("" + levelsGained, 480, 463);
        g.drawString(ft(runTime), 210, 375);
        g.drawString("" + logsCut, 187, 463);
        g.drawString("" + logsPerHour, 202, 449);
        g.drawString("" + xpPerHour, 319, 449);
        g.drawString("" + xpGained, 304, 463);
        
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
	