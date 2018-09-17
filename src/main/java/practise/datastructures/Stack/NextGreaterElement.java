package practise.datastructures.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int arr[]= {11, 9, 13, 21, 3};
        int n = arr.length;
        printNGEUsingLoops(arr, n);
	}
	
	public static void printNGEUsingLoops(int[] arr, int len) {
		int next;
		for(int i=0;i<len;i++) {	
			next=-1;
			for(int j=i+1;j<len;j++) {
				if(arr[j]>arr[i]) {
					next=arr[j];
					break;
				}
			}
			System.out.println(arr[i] + "-->"+next);			
		}
	}

}
