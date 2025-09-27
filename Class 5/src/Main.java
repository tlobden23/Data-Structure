public class Main {
    public static void main(String[] args) {
        MyArrayList<String> array = new MyArrayList<String>();

        array.add("Bob");
        array.add("John");
        array.add("Susan");
        array.add("Alex");

//        array.removeFirst();
        array.remove(2);


        System.out.println(array);
    }
}
