/******************************************
 *  @Author      : Tenzing Lobden
 *  @Created On  : October 7, 2025
 *  @File        : Finger.java
 *  @Description : This class defines a Finger object for use in the Doubly Linked List.
 *                 A Finger maintains a reference to a node and its index in the list.
 ******************************************/
public class Finger<T> {
    // instance variable
    DoubleNode<T> node;
    int idx;

    /**
    * constructor to initialize the finger with a node and index
     **/
    public Finger(int idx, DoubleNode<T> node){
        this.node = node;
        this.idx = idx;
    }

    /**
     * get the index of the node
     **/
    public int getIndex(){
        return this.idx;
    }

    /**
     * set the index for the node
     **/
    public void setIndex(int idx){
        this.idx = idx;
    }

    /**
     * get the node
     **/
    public DoubleNode<T> getNode(){
        return this.node;
    }

    /**
     * set a new node
     **/
    public void setNode(DoubleNode<T> node) {
        this.node = node;
    }
}
