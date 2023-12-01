package queue;


public class MyQueue {
    private final int[] arr = new int[16];
    private int front = -1;
    private int rear = -1;

    public MyQueue() {}

    public void enQueue(int x) {
        if (rear == arr.length - 1) {
            throw new RuntimeException("queue is full");
        }
        rear++;
        arr[rear] = x;
    }

    public int deQueue() {
        if (front == rear) {
            throw new RuntimeException("queue is empty");
        }
        front++;
        return arr[front];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return arr[front + 1];
    }

    public boolean isFull() {
        // front 쪽이 비어있다면?
        return rear == arr.length - 1;
    }

    public static void main(String[] args) {
        MyQueue intQueue = new MyQueue();
        intQueue.enQueue(4);
        intQueue.enQueue(2);
        intQueue.enQueue(3);
        System.out.println(intQueue.deQueue());
        System.out.println(intQueue.deQueue());
        System.out.println(intQueue.deQueue());
        System.out.println(intQueue.deQueue());

//        Queue<Integer> queue = new LinkedList<>();
//        Deque<Integer> deque = new ArrayDeque<>();
//        Stack<Integer> stack = new Stack<>();
//        ArrayList<Integer> arrayList = new ArrayList<>();
    }
}
