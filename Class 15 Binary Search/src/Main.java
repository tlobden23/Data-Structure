public class Main {
    public static void main(String[] args) {
        BinarySearch<Integer> binarySearch = new BinarySearch<>();

        binarySearch.insert(50);
        binarySearch.insert(30);
        binarySearch.insert(70);
        binarySearch.insert(20);
        binarySearch.insert(40);
        binarySearch.insert(60);
        binarySearch.insert(80);
        binarySearch.insert(35);
        binarySearch.insert(45);
        binarySearch.insert(65);
        binarySearch.insert(75);
        System.out.println("finished adding all");

        binarySearch.inOrder(binarySearch.getRoot());

        binarySearch.delete(45);
        System.out.println("Deleted value 45 from Binary Search Tree\n");

        binarySearch.inOrder(binarySearch.getRoot());

        binarySearch.delete(60);
        System.out.println("Deleted value 60 from Binary Search Tree\n");

        binarySearch.inOrder(binarySearch.getRoot());

        binarySearch.delete(50);
        System.out.println("Deleted value 50 from Binary Search Tree\n");

        binarySearch.inOrder(binarySearch.getRoot());
        
    }
}
