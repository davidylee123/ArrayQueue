public class ArrayQueue<T> {
    private T[] items;
    private int front, rear, numItems, maxSize;

    public ArrayQueue(int max) {
        items = (T[]) new Object[max];
        maxSize = max;
        front = 0;
        rear = -1;
        numItems = 0;
    }

    public boolean insert(T item) {
        if (isFull())
            return false;
        rear = (rear + 1) % items.length;
        items[rear] = item;
        numItems++;
        return true;
    }

    public T remove() {
        if (isEmpty())
            throw new RuntimeException("Removing from empty queue");
        T removed = items[front];
        front = (front +  1) % items.length;
        numItems--;
        return removed;
    }

    public boolean isFull() {
        return numItems == maxSize;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        System.out.println(queue.remove());  // Should print 1
        System.out.println(queue.remove());  // Should print 2
        System.out.println(queue.isFull());  // Should print false
        System.out.println(queue.isEmpty()); // Should print false

        queue.insert(6);
        queue.insert(7);  // This should fail silently because the queue is full

        System.out.println(queue.remove());  // Should print 3
    }
}
