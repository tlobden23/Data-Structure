/******************************************
 * @Author      :   Tenzing Lobden
 * @Date        :   Created On :  September 30, 2025
 * @File        :   DoubleNode.java
 * @Description :   This class represents a node in a doubly linked list.
 *  *               It holds the item and references to both the next and previous nodes
 *******************************************/
public class DoubleNode<T> {

    // instance variables
    private T item;
    private DoubleNode<T> next;
    private DoubleNode<T> prev;

    /**
     * Default Constructor
     */
    public DoubleNode() {
        // call constructor passing in three arguments
        this(null, null, null);
    }

    /**
     * Overload Constructor with one parameter (item)
     */
    public DoubleNode(T anItem) {
        // call constructor passing in anItem and two nulls
        this(anItem, null, null);
    }

    /**
     * Overload Constructor with three parameters (item, next node and prev node)
     */
    public DoubleNode(T anItem, DoubleNode<T> nxt, DoubleNode<T> prv) {
        this.item = anItem;
        this.next = nxt;
        this.prev = prv;
    }

    // setters
    /**
     * sets the item in the node
     */
    public void setItem(T anItem) {
        this.item = anItem;
    }

    /**
     * sets the next node in the list
     */
    public void setNext(DoubleNode<T> nextNode) {
        this.next = nextNode;
    }

    /**
     * sets the previous node in the list
     */
    public void setPrev(DoubleNode<T> prevNode) {
        this.prev = prevNode;
    }

    // getters
    /**
     * gets the item from the node
     */
    public T getItem() {
        return this.item;
    }

    /**
     * gets the next node in the list
     */
    public DoubleNode<T> getNext() {
        return this.next;
    }

    /**
     * gets the previous node in the list
     */
    public DoubleNode<T> getPrev() {
        return this.prev;
    }
}