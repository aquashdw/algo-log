package queue;


public class MyCyQueue {
    private final int size = 4;
    private final int offset = size + 1;
    private final int[] arr = new int[offset];
    private int front = 0;
    private int rear = 0;

    public MyCyQueue() {}

    public void enQueue(int x) {
        if (this.isFull()) {
            throw new RuntimeException("queue is full");
        }
        arr[rear] = x;
        rear = (rear + 1) % offset;
    }

    public int deQueue() {
        if (front == rear) {
            throw new RuntimeException("queue is empty");
        }
        int value = arr[front];
        front = (front + 1) % offset;
        return value;
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
        return (rear + 1) % offset == front;
    }

    public static void main(String[] args) {
        MyCyQueue intQueue = new MyCyQueue();
        System.out.println(intQueue.isEmpty());
        System.out.println(intQueue.isFull());
        intQueue.enQueue(4);
        intQueue.enQueue(2);
        intQueue.enQueue(3);
        intQueue.enQueue(5);
        intQueue.enQueue(5);
        System.out.println(intQueue.isFull());
        System.out.println(intQueue.deQueue());
        System.out.println(intQueue.deQueue());
        System.out.println(intQueue.deQueue());
        System.out.println(intQueue.deQueue());
        System.out.println(intQueue.isEmpty());

//        Queue<Integer> queue = new LinkedList<>();
//        Deque<Integer> deque = new ArrayDeque<>();
//        Stack<Integer> stack = new Stack<>();
//        ArrayList<Integer> arrayList = new ArrayList<>();
    }
}
