package practise.datastructures.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingOneQueue {

	public static void main(String[] args) {
		StackWithOneQueue s = new StackWithOneQueue();
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

class StackWithOneQueue {
	Queue<Integer> q;
	int length;

	StackWithOneQueue() {
		q = new LinkedList<>();
		length = 0;
	}

	void push(int val) {
		System.out.println("Push :" + val);
		q.add(val);
		length = length + 1;
	}

	int pop() {
		int val;

		for (int i = 1; i < length; i++) {
			q.add(q.poll());
		}

		val = q.poll();
		length = length - 1;
		System.out.println("Pop : " + val);

		return val;
	}

	int top() {
		int val;
		for (int i = 1; i < length; i++) {
			q.add(q.poll());
		}

		val = q.poll();
		System.out.println("Top : " + val);

		q.add(val);

		return val;
	}
}
