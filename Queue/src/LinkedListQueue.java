public class LinkedListQueue<E> implements QueueInterface<E> {


    @Override
    public void enqueue(E element) throws QueueException {
        Node newNode = new Node(element);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    @Override
    public boolean offer(E element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        return true;
    }

    @Override
    public E dequque() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Queue is empty");
        }

        E element = front.data;
        front = front.next;

        // if removing the one node in the list then you have to make sure the rear is moved too
        if (front == null) {
            rear = null;
        }

        size--;
        return element;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    private class Node<E> {
        E data;
        Node<E> next;

        Node (E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;
    private int capacity;


}
