public class DoublyLinkedList<E> implements List<E>, Stack<E>, Queue<E>{
    // list
    private Node<E> head;
    private Node<E> tail;
    private int size;

    // stack
    private int top = -1;


    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // HELPERS
    @Override
    public boolean isEmpty(){
        return this.size == 0;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int size(){
        return this.size;
    }



    // LIST
    @Override
    public void add(E item) {
        Node<E> newNode = new Node<>(item);
        if (isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
        }
        this.tail = newNode;
        this.size++;
    }

    public void addFirst(E item) {
        Node<E> newNode = new Node<>(item);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.setPrev(newNode);
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }

    @Override
    public void printForward(){
        Node<E> walker = this.head;

        while (walker != null) {
            System.out.println(walker.getData());
            walker = walker.getNext();
        }
    }

    @Override
    public void printBackward(){
        Node<E> walker = this.tail;

        while (walker != null) {
            System.out.println(walker.getData());
            walker = walker.getPrev();
        }
    }

    @Override
    public E remove(E item){
        E data;
        if (isEmpty()) {
            System.out.printf("List is empty, cannot remove %s", item);
            return null;
        } else if (this.head.getData() == item) {
            data = this.head.getData();
            this.head = this.head.getNext();
            this.head.setPrev(null);
            this.size--;
            return data;
        } else if (this.tail.getData() == item) {
            data = this.tail.getData();
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
            this.size--;
            return data;
        } else {
            Node<E> walker = this.head;

            while (walker.getNext() != null) {
                if (walker.getData() == item) {

                    data = walker.getData();
                    Node<E> prevNode = walker.getPrev();
                    Node<E> nextNode = walker.getNext();

                    prevNode.setNext(nextNode);
                    nextNode.setPrev(prevNode);

                    this.size--;
                    return data;
                } else {
                    walker = walker.getNext();
                }
            }
        }

        System.out.printf("%s isn't in the list", item);
        return null;
    }

    @Override
    public E get(int index) {
        Node<E> walker = this.head;
        E data = null;
        int counter = 0;

        if (isEmpty()) {
            System.out.printf("List is empty, cannot retrieve item at index %s", index);
            return null;
        }

        while (walker != null) {
            if (counter == index) {
                data = walker.getData();
                break;
            }
            walker = walker.getNext();
            counter++;
        }

        return data;
    }

    // STACK
    public void push(E item){
        Node<E> newNode = new Node<>(item);

        if (isEmpty()) {
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            this.tail = newNode;
        }
        this.size++;
        this.top++;
    }

    public E pop() {
        E data = null;

        if (isEmpty()) {
            System.out.printf("Stack is empty, cannot remove anything");
        } else {
            data = this.tail.getData();
            // move tail forward
            this.tail = this.tail.getPrev();
            // cut off with old tail
            this.tail.setNext(null);
            this.top--;
            this.size--;
        }
        return data;
    }

    public E peek(){
        E data = null;
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            data = this.tail.getData();
        }
        return data;
    }


    // QUEUE
    public void enqueue(E item) {
        Node<E> newNode = new Node<>(item);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            this.tail = newNode;
        }
        this.size++;
    }

    public E dequeue(){
        E data = null;
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            data = this.head.getData();

            this.head = this.head.getNext();
            this.head.setPrev(null);
            this.size--;
        }
        return data;
    }

    public E front(){
        E data = null;
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            data = this.head.getData();
        }
        return data;
    }
}