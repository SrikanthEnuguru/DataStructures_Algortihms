package practise.datastructures.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {

	public static void main(String[] args) {

		StackWithTwoQueues s = new StackWithTwoQueues();
		s.push(1);
		s.push(2);
		s.push(3);
		s.top();
		s.pop();
		s.pop();
		s.push(4);
		s.push(5);
		s.push(6);
		s.top();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
	}

}

class StackWithTwoQueues {
	Queue<Integer> q1, q2;

	StackWithTwoQueues() {
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}

	void push(int val) {
		System.out.println("Push : " + val);
		q1.add(val);
	}

	int pop() {
		int val;
		while (q1.size() != 1) {
			q2.add(q1.poll());
		}
		val = (int) q1.poll();
		System.out.println("Pop : " + val);
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		return val;
	}
	
	int top() {
		int top;
		while (q1.size() != 1) {
			q2.add(q1.poll());
		}
		top = (int) q1.poll();
		System.out.println("Top : " + top);
		q2.add(top);
		
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		
		return top;
	}
}
