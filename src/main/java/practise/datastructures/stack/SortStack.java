package practise.datastructures.stack;

import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(4);
        s.push(1);
        s.push(5);
        s.push(2);
        s.push(3);

        sort(s);
    }

    static void sort(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<>();

        while (!s.isEmpty()) {
            int n = (int) s.pop();

            while (!temp.isEmpty() && n > temp.peek()) {
                s.push(temp.pop());
            }
            temp.push(n);
        }

        while (!temp.isEmpty()) {
            System.out.print(temp.pop() + " ");
        }
    }
}
