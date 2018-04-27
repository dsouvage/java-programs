package algo.recursivelinearsearch;

public class App {

	public static void main(String[] args) {
	
		int[] A;
		int key, result, start;
		
		//array of size 26
		A = new int[26];
		key = 5;
		
		//fills the array
		for(int i = 0; i < A.length; i++) {
			A[i] = i;
		}
		
		start = A.length - A.length;
		
		result = recursiveLinearSearch(A, start, key);
		
		System.out.println("the result is: " + result);

	}
	
	public static int recursiveLinearSearch(int[] a, int i, int x) {
		//if we exceed the length of the array, return -1 (not found)
		if (i > a.length) {
			return -1;
			//if we find the key, return the index position
		} else if (a[i] == x){
			return i;
		}
		else {
			System.out.println("index at: " + i);
			//continues to search the array for the key 'x'
			return recursiveLinearSearch(a,i+1,x);
		}
		
		

		
	}

	

}
