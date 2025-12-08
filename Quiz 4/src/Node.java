public class Node<E> {
    private E data;
    private Node<E> prev;
    private Node<E> next;

    public Node(E data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    // getters
    public E getData() {
        return data;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public Node<E> getNext() {
        return next;
    }

    // setters

    public void setData(E data) {
        this.data = data;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
