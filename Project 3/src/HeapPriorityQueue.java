
/*******************************************************
 *  @Author : Ali Azhari   
 *  Created On : Sun Oct 19 2025
 *  @File : HeapPriorityQueue.java
 *
 *  Description: implementation of a heap-based priority queue. 
 *  Although we think of our heap as a binary tree, we do not 
 *  formally nuse the binary tree ADT. We prefer to use the more 
 *  efficient array-based representation of a tree
 *******************************************************/

import java.util.ArrayList;
import java.util.Comparator;

/**
 * An implementation of a priority queue using an array-based heap.
 */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    /**
     * primary collection of priority queue entries
     */
    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    /**
     * Creates an empty priority queue based on the natural ordering of its keys.
     */
    public HeapPriorityQueue() {
        super();
    }

    /**
     * Creates an empty priority queue using the given comparator to order keys.
     */
    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    // protected utilities
    protected int parent(int j) {
        return (j - 1) / 2;
    }

    protected int left(int j) {
        return j * 2 + 1;
    }

    protected int right(int j) {
        return j * 2 + 2;
    }

    protected boolean hasLeft(int j) {
        // retrieve index of left
        int indexOfLeft = left(j);

        // return false if index of left is bigger than size, meaning the index of left is bigger than size of heap
        // return true if index of left is smaller than size, meaning that index is valid
        return indexOfLeft < size();
    }

    protected boolean hasRight(int j) {
        // retrieve index of right
        int indexOfRight = right(j);

        // return false if index of right is bigger than size, meaning the index of right is bigger than size of heap
        // return true if index of right is smaller than size, meaning that index is valid
        return indexOfRight < size();
    }

    /**
     * Exchanges the entries at indices i and j of the array list.
     */
    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Moves the entry at index j higher, if necessary, to restore the heap
     * property.
     */
    protected void upheap(int j) {
        // while loop to loop through entire tree until Entry at index j is at the correct position and can't upheap no more
        while (j > 0) {
            // retrieve parent index
            int parentIndex = parent(j);

            // retrieve the Entry at each index
            Entry<K, V> parentEntry = heap.get(parentIndex);
            Entry<K, V> newAddedEntry = heap.get(j);

            // retrieve the num from compare()
            int num = compare(parentEntry, newAddedEntry);

            // if compare method returns int bigger than 0
            // it means the parent key is bigger than newly added key
            if (num > 0) {
                // swap the Entries
                swap(j, parentIndex);
                // switch index to parentIndex since the Entries have been swapped
                j = parentIndex;
            }
            // break because the Entry at index j is at the correct place in the binary heap
            else {
                break;
            }
        }
    }

    /**
     * Moves the entry at index j lower, if necessary, to restore the heap property.
     */
    protected void downheap(int j) {
        // loop until Entry at index j is at the correct position or has no children
        while (hasLeft(j)) {
            // retrieve child indices
            int leftIndex = left(j);
            int rightIndex = right(j);

            // retrieve left index and Entry
            int smallChildIndex = leftIndex;
            Entry<K, V> leftEntry = heap.get(leftIndex);

            // if right child exists, choose the smaller of left or right
            if (hasRight(j)) {
                // retrieve Entry of right
                Entry<K, V> rightEntry = heap.get(rightIndex);

                // retrieve num from compare()
                int num = compare(rightEntry, leftEntry);

                // if rightEntry is smaller than leftEntry then change smallChildIndex
                if (num < 0) {
                    smallChildIndex = rightIndex;
                }
            }

            // retrieve parent and chosen smaller child entries
            Entry<K, V> parentEntry = heap.get(j);
            Entry<K, V> smallChildEntry = heap.get(smallChildIndex);

            // compare parent vs smaller child
            int num = compare(parentEntry, smallChildEntry);

            // if parent key is larger than smaller child key, swap and continue down
            if (num > 0) {
                swap(j, smallChildIndex);
                // move j to the child position since the Entries have been swapped
                j = smallChildIndex;
            }
            // break because the Entry at index j is at the correct place in the binary heap
            else {
                break;
            }
        }
    }

    // public methods

    /**
     * Returns the number of items in the priority queue.
     */
    public int size() {
        return heap.size();
    }

    /**
     * Returns (but does not remove) an entry with minimal key (if any).
     */
    public Entry<K, V> min() {
        if (heap.isEmpty())
            return null;
        return heap.get(0);
    }

    /**
     * Inserts a key-value pair and returns the entry created.
     */
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key); // auxiliary key-checking method (could throw exception)
        Entry<K, V> newest = new PQEntry<>(key, value);
        heap.add(newest); // add to the end of the list
        upheap(heap.size() - 1); // upheap newly added entry
        return newest;
    }

    /**
     * Removes and returns an entry with minimal key (if any).
     */
    public Entry<K, V> removeMin() {
        if (heap.isEmpty())
            return null;
        Entry<K, V> answer = heap.get(0);
        swap(0, heap.size() - 1); // put minimum item at the end
        heap.remove(heap.size() - 1); // and remove it from the list;
        downheap(0); // then fix new root
        return answer;
    }
}
