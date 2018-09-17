package practise.datastructures.array;

public class LargestSumContiguousSubarray {

	public static void main(String[] args) {
		int[] arr1 = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("LargestSumContiguousSubarray: "+ findLargestSumContiguousSubarray(arr1));
		
		int[] arr2 = {-1,-2,-3};
		System.out.println("LargestSumContiguousSubarray: "+ findLargestSumContiguousSubarray(arr2));
	}
	
	public static int findLargestSumContiguousSubarray(int[] a) {
		
		int curr_max=a[0];
		int max_so_far=a[0];
		for(int i=1;i<a.length;i++){
			curr_max=Math.max(a[i], curr_max+a[i]);
			max_so_far=Math.max(max_so_far, curr_max);
		}
		
		return max_so_far;
		
		
	}

}
