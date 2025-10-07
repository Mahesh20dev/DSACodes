class Queue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queueArray;
    private int currentSize;

    public Queue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    // Enqueue element
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow!");
        } else {
            rear = (rear + 1) % maxSize;
            queueArray[rear] = value;
            currentSize++;
        }
    }

    // Dequeue element
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            return -1;
        } else {
            int temp = queueArray[front];
            front = (front + 1) % maxSize;
            currentSize--;
            return temp;
        }
    }

    // Check if empty/full
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    public boolean isFull() {
        return (currentSize == maxSize);
    }
}

public class Queueimp {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
    }
}
