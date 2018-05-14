package algo.selectionsort;
import java.util.Scanner;

public class App {


	public static void main(String[] args) {
		int a[];
		int size;
		Scanner kbd;
		kbd = new Scanner(System.in);
		
		System.out.println("Enter how many numbers to be sorted: ");
		size = kbd.nextInt();
		a = new int[size];
				
		a = getArray(size);
		
		System.out.println("------");
		System.out.println("Unsorted: ");
		System.out.println("------");
		printArray(a);
		System.out.println("");
		
		a = selectionSort(a);
		
		System.out.println("------");
		System.out.println("Sorted: ");
		System.out.println("------");
		printArray(a);
		
		
		kbd.close();
		
	}
	
	public static int[] getArray(int size) {
		int a[];
		Scanner kbd;
		kbd = new Scanner(System.in);
		
		System.out.println("Enter the numbers: ");
		a = new int[size];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = kbd.nextInt();
		}
		
		kbd.close();
		
		return a;
	}
	
	public static int[] selectionSort(int a[]) {
		
		for (int i = 0; i < a.length; i++) {
			int minimum = i;
			for (int j = i+1; j < a.length; j++) {
				if(a[j]<a[minimum]) {
					minimum = j;
				}
			}
			int temp = a[i];
			a[i] = a[minimum];
			a[minimum] = temp;
		}

		return a;
	}
	
	
	public static void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	
}
