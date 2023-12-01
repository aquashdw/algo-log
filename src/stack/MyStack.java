package stack;

import java.util.Stack;

public class MyStack {
    private final int[] arr = new int[10];
    private int top = -1;

    public MyStack() {
    }

    public void push(int x) {
        if (top == arr.length - 1) {
            throw new RuntimeException("stack is full");
        }
        top++;
        arr[top] = x;
        // arr[++top] = x;
    }

    public int pop() {
        if (this.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        int value = arr[top];
        top--;
        return value;
        // return arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return arr[top];
    }

    public static void main(String[] args) {
        MyStack integerStack = new MyStack();
        integerStack.push(10);
        integerStack.push(20);
        System.out.println(integerStack.pop());
        integerStack.push(30);
        System.out.println(integerStack.peek());
        System.out.println(integerStack.pop());

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(5);

        System.out.println(stack.peek());
        stack.pop();

        System.out.println(stack.pop());
    }
}
