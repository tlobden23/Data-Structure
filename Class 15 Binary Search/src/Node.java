public class Node<E>{
    private E data;
    private Node<E> leftNode;
    private Node<E> rightNode;

    public Node (E data) {
        this.data = data;
    }


    public E getData() {
        return data;
    }

    public Node<E> getLeftNode() {
        return leftNode;
    }

    public Node<E> getRightNode() {
        return rightNode;
    }


    public void setLeftNode(Node<E> leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node<E> rightNode) {
        this.rightNode = rightNode;
    }
}
