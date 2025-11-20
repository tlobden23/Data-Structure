public class Main {
    public static void main(String[] args) {
        BinarySearch<Integer> binarySearch = new BinarySearch<>();

        binarySearch.insert(40);
        System.out.println("This is the Binary Search Tree");
        binarySearch.inOrder(binarySearch.getRoot());
        System.out.println("finished first part\n");
        binarySearch.insert(30);
        System.out.println("This is the Binary Search Tree");
        binarySearch.inOrder(binarySearch.getRoot());
        System.out.println("finished second part\n");
        binarySearch.insert(60);
        System.out.println("This is the Binary Search Tree");
        binarySearch.inOrder(binarySearch.getRoot());
        System.out.println("finished third part\n");
        binarySearch.insert(70);
        System.out.println("This is the Binary Search Tree");
        binarySearch.inOrder(binarySearch.getRoot());
        System.out.println("finished fourth part\n");
        binarySearch.insert(10);
        System.out.println("This is the Binary Search Tree");
        binarySearch.inOrder(binarySearch.getRoot());
        System.out.println("finished fifth part\n");
        System.out.println("finished all");

        binarySearch.inOrder(binarySearch.getRoot());
    }
}
