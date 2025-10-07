class Stack {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    // Push element onto the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow!");
        } else {
            stackArray[++top] = value;
        }
    }

    // Pop element from stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    // Peek top element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    // Check if empty/full
    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}

public class Stackimp {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
    }
}
