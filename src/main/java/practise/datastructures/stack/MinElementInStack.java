package practise.datastructures.stack;

import java.util.Stack;

public class MinElementInStack {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(5);
		s.push(3);
		s.push(1);
		s.push(2);
		s.push(4);
		printMinElement(s);
	}

	static void printMinElement(Stack<Integer> s) {
		int min = Integer.MAX_VALUE;
		Stack<Integer> temp = new Stack<Integer>();
		while (!s.isEmpty()) {
			int curr = (int) s.pop();
			if (curr < min) {
				min = curr;
			}
			temp.push(curr);
		}
		System.out.println("Minimum element : " + min);
	}

}
