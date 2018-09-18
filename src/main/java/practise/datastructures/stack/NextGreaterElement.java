package practise.datastructures.stack;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int arr[]= {11, 9, 13, 21, 3};
        int n = arr.length;
        printNGEUsingLoops(arr, n);
        printNGEUsingStack(arr, n);
	}
	
	public static void printNGEUsingLoops(int[] arr, int len) {
		System.out.println("printNGEUsingLoops");
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
	
	public static void printNGEUsingStack(int[] arr, int len) {
		System.out.println("printNGEUsingStack");
		Stack<Integer> s= new Stack<Integer>();
		s.push(arr[0]);
		for(int i=1;i<len;i++) {
			int next = arr[i];
			if(!s.isEmpty()) {
				int element = (Integer) s.pop();
				while(element<next) {
					System.out.println(element+" --> "+next);
					if(s.isEmpty()) {
						break;
					}
					element=(Integer) s.pop();
				}
				
				if(element>next) {
					s.push(element);					
				}
			}
			s.push(next);
		}
		
		while(!s.isEmpty()) {
			int next=-1;
			int element = (Integer) s.pop();
			System.out.println(element+" --> "+next);
		}
	}

}
