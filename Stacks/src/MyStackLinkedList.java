public class MyStackLinkedList<E> implements StackInterface<E>{

    // instance variable
    // last element in the linkedlist
    private Node<E> top;
    private int size;

    // constructor
    public MyStackLinkedList() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(E e) throws StackException {
        // if it's full throw exception because push throws StackException
        // but isFull() will never be true and always false so most likely it will never get thrown
        if (isFull()) {
            throw new StackException("Stack is full!");
        }
        // create newNode
        Node<E> newNode = new Node<>(e);

        // if not empty then set top to next
        if (!isEmpty()) {
            newNode.setNext(this.top);
        }

        this.top = newNode;
        size++;
    }

    @Override
    public E pop() throws StackException {
        // check if linkedlist is empty
        if (isEmpty()) {
            throw new StackException("Stack is empty!");
        }

        // return this
        E data = top.getData();

        Node<E> temp = this.top;

        this.top = this.top.getNext();

        temp = null;
        size--;

        return data;
    }

    @Override
    public E peek() {
        if (isEmpty())
            return null;
        else {
            return top.getData();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.top == null || this.size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
