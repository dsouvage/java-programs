package algo.binarysearch;

public class App {

	public static void main(String[] args) {
		int[] A;
		int x, result;
		
		//array of size 26
		A = new int[26];
		x = 5;
		
		//fills the array
		for(int i = 0; i < A.length; i++) {
		A[i] = i;
		}
		
		result = binarySearch(A, x);
		
		System.out.println(result);
		
	}
	
	
	public static int binarySearch(int[] a, int x) {
	int p,r,q;
	p = 0;
	r = a.length - 1;
		
	//binary search algorithm loop
	while (p <= r) {
		//takes the array and cuts it into sections
		q = (p + r)/2;
		
		if (a[q] == x){
			return q;
		} else if (a[q] > x) {
			r = q - 1;
		} else {
			p = q + 1;
		}
	}
		//if we can't find a value we just return -1
		return -1;
	}

}
