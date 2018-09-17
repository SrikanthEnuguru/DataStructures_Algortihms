package practise.datastructures.array;

import java.util.HashMap;

public class CheckSumInSubArray {

	public static void main(String[] args) {
		int[] a = {10,2,-2,-20,10};
		checkSumInSubArray(a, 500);
	}
	
	//wrong solution
	public static void checkSumInSubArray(int[] a,int sum) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int curr_sum=0;
		for(int i=0;i<a.length;i++) {
			curr_sum = curr_sum+a[i];
			if(map.get(curr_sum-sum)!=null) {
				System.out.println("Exists!!!");
				break;
			}else {
				map.put(curr_sum-sum, i);
			}			
		}
		
	}

}
