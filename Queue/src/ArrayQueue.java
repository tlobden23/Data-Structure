import java.lang.reflect.Array;

public class ArrayQueue implements QueueInterface {

    // instance variables
    private int front;
    private int rear;
    private int size;
    private int capacity;
    private Object[] data;

    public ArrayQueue(){
        this(10);
    }

    public ArrayQueue(int capacity) {
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.capacity = capacity;
    }

    @Override
    public void enqueue(Object element) throws QueueException {
        if (isFull()) {
            throw new QueueException("Queue is full");
        }

        rear++;
        data[rear] = elment;
        size++;
    }

    @Override
    public boolean offer(Object element) {
        if (isFull()) {
            return false;
        }

        rear++;
        data[rear] = elment;
        size++;
        return true;
    }

    @Override
    public Object dequque() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Queue is Empty");
        }

        E element = (E) data[front];
        shiftQueue();
        rear--;
        size--;
        return element;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
