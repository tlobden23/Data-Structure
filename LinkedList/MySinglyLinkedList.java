import java.util.Iterator;

public class MySinglyLinkedList<T> implements MyList<T>, Iterable<T> {

    Node<T> head, tail;
    int size;


    public MySinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;

    }

    @Override
    public void addFirst(T e) {
        Node<T> newNode = new Node<>(e); // Creates a new Node and putting "e" inside
        if (isEmpty())
            head = tail = newNode;
        else {
            newNode.setNext(head); //  By using this method we bypass the risk of losing the data since we make this node to equal the head
            head = newNode;
        }

    }

    @Override
    public void addLast(T e) {
        Node<T> newNode = new Node<>(e);
        if (isEmpty())
            head = tail = newNode;

        else {
            tail.setNext(newNode);
            tail = newNode;

        }
        size++;

    }

    @Override
    public T removeFirst() {
        if (isEmpty())
            return null;
        else {
            Node<T> temp = head;
            head = head.getNext(); // Even if the list is empty now that's the first element
            size--;
            return temp.getData();
        }
    }

    @Override
    public T removeLast() {
        if (isEmpty())
            return null;

        Node<T> current = head;
        Node<T> prev = null;

        while (current.getNext() != null) {
            prev = current;
            current = current.getNext();
        }
        if (prev == null)
            head = tail = null;
        else {
            tail = prev;
            prev.setNext(null);
        }


        size--;
        return current.getData();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        String str = "";
        if (isEmpty()) {
            return "List is empty\n";
        } else {
            Node<T> cursor = head;
            while (cursor != null) {
                str += cursor.getData() + "\n";
                cursor = cursor.getNext();
            }
            return str;
        }
    }

    class Itr implements Iterator<T> {
    Node<T> cursor = head;

        @Override
        boolean hasNext() {

        }
        if(cursor ==null)return false;
        return cursor.getNext()
    }
}

    @Override
    public Iterator<T> iterator() {


}

