public interface QueueInterface<E>{

    // bot enqueue and offer add element to rear
    void enqueue(E element) throws QueueException;
    boolean offer(E element);

    // both dequeue and poll remove element from front
    E dequque() throws QueueException;
    E poll();

    E peek();

    boolean isEmpty();

    boolean isFull();

    int size();
}
