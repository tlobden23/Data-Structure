public class Main {
    public static void main(String[] args) {

        // Integer list of arrays not int because generics don't work with primitive data types
        Integer[] arrayInteger = {4,8,3,0};

        Character[] arrayChar = {'h', 'd', 'e', 'p'};

        bubbleSort(arrayInteger);
        bubbleSort(arrayChar);

        output(arrayInteger);
        output(arrayChar
        );

    }

    // bubble sort method
    public static <E extends Comparable<E>> void bubbleSort(E[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0){
                    E temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // output the sorted array
    public static <E> void output(E[] array) {
        for (E i: array) {
            System.out.println(i);
        }
    }
}