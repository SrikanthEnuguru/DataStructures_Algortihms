package practise.algorithms.dp;

/**
*
* When we drop an egg from a floor x, there can be two cases
* (1) The egg breaks
* (2) The egg doesn’t break.
* If the egg breaks after dropping from xth floor, then we only need to check for floors lower than x with remaining eggs;
* so the problem reduces to x-1 floors and e-1 eggs
* If the egg doesn’t break after dropping from the xth floor,then we only need to check for floors higher than x;
* so the problem reduces to N-x floors and e eggs.
*
* Since we need to minimize the number of trials in worst case, we take the maximum of two cases (worst case).
* We consider the max of above two cases for every floor and choose the floor which yields minimum number of trials.
*
*  N = Number of floors
*  E = Number of Eggs
*  trials(E, N) ==> Minimum number of trials needed to find the critical floor in worst case.
*  trials(E, N) = 1 + min{max(trials(E - 1, X - 1), trials(E,  N - X)): for all x in {1, 2, ..., k}}
*
*  1<=N<=50
*  1<=E<=10
*  
*/

public class EggDropping {

	public static void main(String[] args) {
		int eggs = 2;
		int floors = 10;
		System.out.println("Minimum number of trials in worst case with " + eggs + " eggs and " + floors + " floors is "
				+ EggDropping_DP(eggs, floors));
	}

	static int EggDropping_DP(int eggs, int floors) {
		int res = Integer.MAX_VALUE;
		if (floors == 0) {
			return 0;
		}

		if (eggs == 1) {
			return floors;
		}

		for (int i = 1; i <= floors; i++) {
			int temp = 1 + Math.max(EggDropping_DP(eggs - 1, i - 1), EggDropping_DP(eggs, floors - i));
			if (temp < res) {
				res = temp;
			}
		}
		return res;
	}

}
