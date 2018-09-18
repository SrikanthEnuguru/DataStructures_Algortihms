package practise.datastructures.queue;

import java.util.Stack;

public class QueueUsingStacks {

	public static void main(String[] args) {
		
		Queue q= new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		q.dequeue();
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();

	}

}

class Queue{
	Stack s1,s2;
	Queue(){
		 s1=new Stack<>();
		 s2=new Stack<>();
	}
	
	
	void enqueue(int val) {
		System.out.println("enqueue : "+val );
		s1.push(val);
	}
	
	int dequeue() {
		int x;
		if(s1.isEmpty() && s2.isEmpty()) {
			System.out.println("Empty data");
		}
		if(s2.isEmpty()) {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		x= (int)s2.pop();
		System.out.println("dequeue : "+x);
		return x;		
	}
}
