public class BinarySearch<E extends Comparable<E>> {
    private Node<E> root;

    public BinarySearch() {
        this.root = null;
    }

    public void insert(E data) {
        Node<E> newNode = new Node<>(data);

        if (isEmpty()) {
            this.root = newNode;
        } else {

            insertHelper(getRoot(), newNode);

//            while (true) {
//                System.out.println("Comparing " + current.getData() + " and " + newNode.getData());
//                if (current.getData().compareTo(newNode.getData()) > 0) {
//
//                    if (current.getLeftNode() == null) {
//                        System.out.println("Setting left node of " + current.getData() + " to " + newNode.getData());
//                        current.setLeftNode(newNode);
//                        break;
//                    }
//                    current = current.getLeftNode();
//                } else {
//                    if (current.getRightNode() == null) {
//                        System.out.println("Setting right node of " + current.getData() + " to " + newNode.getData());
//                        current.setRightNode(newNode);
//                        break;
//                    }
//                    current = current.getRightNode();
//                }
//                System.out.println("Current is " + current.getData());
//
//                System.out.println("Current is " + current.getData() + " after switching");
//            }
        }
    }

    public void insertHelper(Node<E> node, Node<E> newNode){
        if (node.getData().compareTo(newNode.getData()) > 0) {
            if (node.getLeftNode() == null) {
                node.setLeftNode(newNode);
            }
            else {
                insertHelper(node.getLeftNode(), newNode);
            }
        } else {
            if (node.getRightNode() == null) {
                 node.setRightNode(newNode);
            }
            else {
                insertHelper(node.getRightNode(), newNode);
            }
        }
    }

    public void delete (E data) throws NullPointerException{
        if (!isEmpty()) {
            Node<E> parent = null;
            Node<E> current = root;

            while (current != null) {
                if (current.getData().compareTo(data) > 0) {
                    parent = current;
                    current = current.getLeftNode();
                }
                else if (current.getData().compareTo(data) < 0) {
                    parent = current;
                    current = current.getRightNode();
                }
                else {
                    break;
                }
            }

            if (current == null) {
                throw new NullPointerException("Data not found in Binary Search Tree");
            }


//            System.out.printf("Parent Node's data = %s\nCurrent Node's data = %s\n", parent.getData(), current.getData());

            if ()

            if (parent.getRightNode() == current) {
                if (current.getRightNode() != null) {
                    parent.setRightNode(current.getRightNode());
                }
                else if (current.getLeftNode() != null) {
                    parent.setRightNode(current.getLeftNode());
                }
                else {
                    parent.setRightNode(null);
                }

            }
            else {
                if (current.getRightNode() != null) {
                    parent.setLeftNode(current.getRightNode());
                }
                else if (current.getLeftNode() != null) {
                    parent.setLeftNode(current.getLeftNode());
                    current.setLeftNode(null);
                }
                else {
                    parent.setLeftNode(null);
                }
            }
        }
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public Node<E> getRoot(){
        return this.root;
    }

    public void inOrder(Node<E> node){
        if (node != null) {
            inOrder(node.getLeftNode());
            System.out.println(node.getData());
            inOrder(node.getRightNode());
        }
    }
}