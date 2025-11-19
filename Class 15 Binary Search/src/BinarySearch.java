public class BinarySearch {
    private int[] array;
    private int size;


    public BinarySearch(){
        this.array = new int[20];
        this.size = 0;
    }
    public void insert(int value){
        if (isEmtpy()) {
            array[size++] = value;
            ;
        }
        else {
            int parent = -1;
            int current = 0;
            while (current < array.length){
                if (parent > value) {

                    if (hasLeft(parent)) {
                        parent = current;
                        current = parent * 2 + 1;
                    }
                } else {
                    if (hasRight(parent)) {
                        parent = current;
                        current = parent * 2 + 2;
                    }
                }

            }
        }
    }

    public void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i -1; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public boolean isEmtpy(){
        if (array.length == 0) {
            return true;
        }
        return false;
    }

    public boolean hasLeft(int index){
        if (index*2+1 > size) {
            return false;
        }
        return true;
    }

    public boolean hasRight(int index){
        if (index*2 +2 > size) {
            return false;
        }
        return true;
    }

    public void main(String[] args) {
        int[] array = {50,20,100,30,60,10,8};

        bubbleSort(array);

        for (int i : array) {
            System.out.println(array);
        }
    }
}