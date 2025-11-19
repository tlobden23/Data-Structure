import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Integer list of arrays not int because generics don't work with primitive data types
        Integer[] arrayInteger = {4,8,3,0};

        Character[] arrayChar = {'h', 'd', 'e', 'p'};

//        bubbleSort(arrayInteger);
//        bubbleSort(arrayChar);

//        selectionSort(arrayInteger);
//        selectionSort(arrayChar);

//        insertionSortSwapBased(arrayInteger);
//        insertionSortSwapBased(arrayChar);

        insertionSortShiftBased(arrayInteger);
        insertionSortShiftBased(arrayChar);


        output(arrayInteger);
        output(arrayChar
        );

    }

    // bubble sort method
    public static <E extends Comparable<E>> void bubbleSort(E[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // iterate through the whole array by comparing neighbors
            for (int j = 0; j < array.length - 1 - i; j++) {
                // compare the first element vs second element
                // if the compareTo returns an int bigger than 0, first element is bigger than second element
                if (array[j].compareTo(array[j + 1]) > 0){
                    E temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static <E extends Comparable<E>> void selectionSort(E[] array) {
        for (int i = 0; i < array.length; i++) {
            // save index of the first index of iteration and make min
            int min = i;

            // iterate the array from i
            for (int j = i; j < array.length; j++) {
                // check if array[j] is less than array[min]
                if (array[j].compareTo(array[min]) < 0) {
                    // save new min index
                    min = j;
                }
            }

            // save value at index min array[min]
            E temp = array[min];
            // replace array[min] with array[i]
            array[min] = array[i];
            // replace array[i] with temp
            array[i] = temp;
        }
    }


    public static <E extends Comparable<E>> void insertionSortSwapBased(E[] array) {
        for (int i = 1; i < array.length; i++) {
            // retrieve temp value at index j
            E temp = array[i];

            // iterate through left indexes of i
            for (int j = i; j > 0; j--) {



                System.out.printf("comparing index: %d, %d\nvalues: %s, %s\n", j-1, j, array[j-1], array[j]);
                System.out.println(Arrays.toString(array) + "\n");

                // check if index left of j is bigger than value at index j
                if (array[j - 1].compareTo(temp) > 0) {
                    // swap
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
                // if the index left of j is smaller than everything else is smaller than value at index j, move to next index (i)
                else {
                    break;
                }
            }

            System.out.println("Array outside for loop = " + Arrays.toString(array) + "\n");

        }
    }

    public static <E extends Comparable<E>> void insertionSortShiftBased(E[] array) {
        for (int i = 1; i < array.length; i++) {
            E temp = array[i];

            int j = i;

            while (j > 0 && array[j-1].compareTo(temp) > 0){
                array[j] = array[j-1];
                j--;

            }
            array[j] = temp;

        }
    }

    // output the sorted array
    public static <E> void output(E[] array) {
        for (E i: array) {
            System.out.print(i + " ");
        }

        // create line break;
        System.out.println();
    }
}