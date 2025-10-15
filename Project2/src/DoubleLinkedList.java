/******************************************
 * @Author      :   Tenzing Lobden
 * @Date        :   Created On :  September 30, 2025
 * @File        : DoubleLinkedList.java
 * @Description : Doubly linked list with inserting,
 *                removing, and sorting items. Also includes finger based traversal to make
 *                accessing nodes more faster O(log(n)) in big lists.
 *******************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DoubleLinkedList<T> implements ListInterface<T> {

    // instance variables
    private DoubleNode<T> head;
    private int itemCount;
    private Finger<T>[] fingers;


    // constructor

    /**
     * initializes the double linked list
     * sets head to null and itemCount to 0, fingers array has 2 elements by default
     */
    @SuppressWarnings("unchecked")
    public DoubleLinkedList() {
        this.head = null;
        this.itemCount = 0;
        // type cast to generic array
        this.fingers = (Finger<T> []) new Finger[2];
    }

    /**
     * checks if the list is empty
     */
    @Override
    public boolean isEmpty() {
        // check both itemCount and head to double check the linked list is empty
        return (itemCount == 0 && head == null);
    }

    /**
     * gets the length of the list
     */
    @Override
    public int getLength() {
        // return the total number of items in the list
        return this.itemCount;
    }

    /**
     * inserts a new item at a specific position
     */
    @Override
    public boolean insert(int position, T item) {
        // check if the position is greater than itemCount or less than 1
        if (position < 1 || position > itemCount + 1) {
            return false;
        }

        // create the new DoubleNode
        DoubleNode<T> newNode = new DoubleNode<>(item);

        // check if position is 1 (1 = head)
        if (position == 1) {
            // set up the newNode's prev and next
            newNode.setPrev(null);
            newNode.setNext(head);

            // if there is existing node then attach the head's prev to newNode
            if (head != null) {
                head.setPrev(newNode);
            }

            // assign head to newNode
            head = newNode;
        }
        // inserting after head
        else {
            // retrieve DoubleNode before position to connect newNode
            DoubleNode<T> prev = getDoubleNodeAt(position - 1);

            // just to check if the prev DoubleNode we retrieved isn't null
            if (prev == null) {
                return false;
            }

            // get the DoubleNode at the position currently
            DoubleNode<T> next = prev.getNext();

            // connect newNode's prev and next
            newNode.setPrev(prev);
            newNode.setNext(next);

            // connect prev's next to newNode
            prev.setNext(newNode);

            // check if the next isn't null
            // if next is null then that means it's the end of the linked list
            if (next != null) {
                // connect next's prev to newNode
                next.setPrev(newNode);
            }
        }

        // increment itemCount
        itemCount++;

        // update the fingers in the array
        updateFinger();
        return true;
    }

    /**
     * removes the item at the specified position
     */
    @Override
    public void remove(int position) {
        // no-op on invalid or empty
        if (position < 1 || position > itemCount || isEmpty()) {
            return;
        }

        // locate the node to remove (1-based)
        DoubleNode<T> current = getDoubleNodeAt(position);
        if (current == null) {
            return; // defensive: inconsistent state
        }

        // get previous DoubleNode of current
        DoubleNode<T> prev = current.getPrev();

        // get next DoubleNode of current
        DoubleNode<T> next = current.getNext();

        // if prev == null that means it's the head
        if (prev == null) {
            // set head to next
            head = next;

            // if head isn't null then set prev of newly set head to null
            if (head != null) {
                head.setPrev(null);
            }
        }

        // nodes after head to remove
        else {
            // connect next of prev DoubleNode to next DoubleNode
            // unlinks the DoubleNode
            prev.setNext(next);
        }

        // if next isn't null then connect prev of next DoubleNode to prev DoubleNode
        if (next != null) {
            // link next to prev
            next.setPrev(prev);
        }
        // takes care of the tail node too
        // fully unlink removed node
        current.setPrev(null);
        current.setNext(null);

        // decrease the itemCount
        itemCount--;

        // update the fingers
        updateFinger();
    }

    /**
     * clears the entire list
     */
    public void clear() {
        head = null;
        itemCount = 0;
    }

    /**
     * retrieves the item at a specific position
     */
    @Override
    public T getEntry(int position) throws IndexOutOfBoundsException {

        if (isEmpty() || position > itemCount || position < 1)
            throw new IndexOutOfBoundsException();

        // retrieve the DoubleNode at position
        DoubleNode<T> doubleNode = getDoubleNodeAt(position);

        // check if the doubleNode is valid
        if (doubleNode == null) {
            throw new IndexOutOfBoundsException("Node is null");
        }

        // return the data for the node
        return doubleNode.getItem();
    }

    /**
     * replaces the item at a specified position with a new one
     */
    @Override
    public T replace(int position, T entry) throws IndexOutOfBoundsException {

        // throw exception if linked list is empty and position isn't valid
        if (isEmpty() || position > itemCount || position < 1)
            throw new IndexOutOfBoundsException();

        // retrieve the DoubleNode at position
        DoubleNode<T> doubleNode = getDoubleNodeAt(position);

        // check if the doubleNode is valid
        if (doubleNode == null) {
            throw new IndexOutOfBoundsException(" Node is null");
        }

        // retrieve the data
        T item = doubleNode.getItem();

        // replace the data with entry
        doubleNode.setItem(entry);

        // return the original data
        return item;
    }

    /**
     * finds the index of the specified item
     */
    public int getIndexOf(T entry) {

        // check if list is empty
        if (isEmpty())
            // return -1
            return -1;

        // DoubleNode to walk through the linked list
        DoubleNode<T> walker = head;

        // position starts at 1
        int position = 1;

        // walk through the list until the DoubleNode == null
        while (walker != null) {

            // check if the item == entry
            if (walker.getItem().equals(entry)) {
                // return position
                return position;
            }
            // increase position
            position++;
            // get next walker
            walker = walker.getNext();
        }
        // if nothing found then return -1
        return -1;
    }

    /**
     * converts the list to an array
     */
    @Override
    public Object[] toArray() {

        if (itemCount == 0)
            return null;

        Object[] array = new Object[itemCount];
        DoubleNode<T> walker = head;

        for (int i = 0; i < itemCount; i++) {
            array[i] = walker.getItem();
            walker = walker.getNext();
        }

        return array;
    }

    /**
     * retrieves the node at a specific position
     */

    private DoubleNode<T> getDoubleNodeAt(int position) {

        if (isEmpty() || position < 1 || position > itemCount)
            return null;

        // retrieve the Finger object which has the position and the DoubleNode
        Finger<T> starter = getClosest(position);

        // retrieve the position index
        int startIndex = starter.getIndex();

        // retrieve the Node
        DoubleNode<T> walker = starter.getNode();

        // go forward if startIndex is less than position
        while (startIndex < position) {
            walker = walker.getNext();
            startIndex++;
        }

        // go backwards if startIndex is bigger than position
        while (startIndex > position) {
            walker = walker.getPrev();
            startIndex--;
        }

        // return the DoubleNode
        return walker;
    }

    /**
     * updates the finger references for better traversal of the list.
     * This method calculates the required number of fingers based on the list length,
     * and updates the finger positions.
     */

    @SuppressWarnings("unchecked")
    private void updateFinger() {
        // check if linked list empty
        if (isEmpty()) {
            // set all the fingers to null
            for (int i = 0; i < fingers.length; i++)
                fingers[i] = null;
            return;
        }

        // for length less than 3, don't use fingers at all
        if (getLength() <= 3) {
            // create empty array because array is small no need for fingers
            fingers = (Finger<T> []) new Finger[0]; // empty array
            return;
        }

        // for length is more than 3
        // calculate how many fingers using the log of length of linked list and then round up and type cast to int
        int fingerAmount = (int) Math.ceil(Math.log10(getLength()));

        // resize the finger array
        if (fingerAmount > 2) {
            this.fingers = (Finger<T> []) new Finger[fingerAmount];
        }
        // if fingerAmount is less than two then set the fingerAmount to 2 because that's the default in constructor
        else {
            fingerAmount = 2;
            this.fingers = (Finger<T> []) new Finger[fingerAmount];
        }

        // spacing between the fingers
        int space = getLength() / (fingerAmount + 1);

        // iterate through the fingers loop
        // assigning finger to node and position
        for (int i = 0; i < fingers.length; i++) {
            // calculate the pos of the finger even spacing
            int pos = space * (i + 1);

            // retrieve DoubleNode at position
            DoubleNode<T> nodeAt = getDoubleNodeAt(pos);

            // create new Finger object and pass in position and node
            fingers[i] = new Finger<>(pos, nodeAt);
        }
    }

    /**
     * finds the closest finger to the given index
     */
    private Finger<T> getClosest(int idx) {
        // check if linked list is empty if is then return null
        if (isEmpty()) {
            return null;
        }

        // used for index (1 = head)
        int index = 1;

        // in sync with index (start with head) as the closest Node
        DoubleNode<T> helper = head;

        // calculate the distance using head
        int distance = Math.abs(idx - index);

        // if there isn't any fingers then return the head or if idx is 1 then return head
        if (fingers == null || fingers.length == 0 || idx == 1) {
            return new Finger<>(1, head);
        }
        // go through fingers array
        for (Finger<T> nodeFinger : fingers) {
            // if one of the nodes is null
            if (nodeFinger == null) {
                // move to next node in the fingers array
                continue;
            }
            // calculate the distance using the fingers (f) index
            int distanceIn = Math.abs(idx - nodeFinger.getIndex());

            // check if the distanceIn is smaller than distance
            // meaning distanceIn is closer to idx
            if (distanceIn < distance) {
                // set the distance to distanceIn
                distance = distanceIn;

                // get the finger index and set it to index
                index = nodeFinger.getIndex();

                // get the finger DoubleNode and then set it to helper
                helper = nodeFinger.getNode();
            }
        }

        // return a new Object because we don't want to pass the Finger's node and position
        // because it might get changed later
        return new Finger<>(index, helper);
    }

    /**
     * sorts the list using the provided comparator
     */
    public void sort(Comparator<DoubleNode<T>> comparator) {
        // check if linked list is empty if is then there is nothing to sort
        if (isEmpty()) {
            return;
        }

        // array list to hold all the nodes in order
        ArrayList<DoubleNode<T>> ordered = new ArrayList<>();
        DoubleNode<T> helper = head;

        // iterate through all the nodes
        while (helper != null) {
            // add to array list unordered for now
            ordered.add(helper);
            // move to next node
            helper = helper.getNext();
        }

        // sort the list using comparator
        Collections.sort(ordered, comparator);

        // iterate through the array list and connect the nodes to form linked list
        // stop at the last node because the first line in the for loop would create an error since there is nothing
        // after the last node
        for (int i = 0; i < ordered.size() - 1; i++) {
            // set the next of the nodes
            ordered.get(i).setNext(ordered.get(i + 1));

            // set the prev of the next nodes
            ordered.get(i + 1).setPrev(ordered.get(i));
        }

        // set the prev of the head to null because the for loop doesn't do that after the arraylist is ordered
        ordered.get(0).setPrev(null);

        // get the last node and set the next of the node to null because the for loop doesn't do that
        ordered.get(ordered.size() - 1).setNext(null);

        // get the first node in the ordered array list and set it to head
        head = ordered.get(0);
    }

    /**
     * converts the list into a string format
     */
    @Override
    public String toString() {
        // StringBuilder object
        StringBuilder sb = new StringBuilder();

        // temp DoubleNode to go through LinkedList
        DoubleNode<T> temp = head;
//    System.out.println("printing toString()");

        if (this.itemCount == 0) {
            return "Empty List!";
        }
        // iterate through the LinkedList
        for (int i = 1; i <= this.itemCount; i++) {
            // add to sb the position and data inside the DoubleNode
            sb.append(String.format("[%d] %s%n", i, temp.getItem()));
//      System.out.println(temp.getItem());

            // move to next DoubleNode
            temp = temp.getNext();
        }
        // return the sb and convert to String
        return sb.toString();
    }
}