import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    // capacity is how much the array can hold
    private int capacity;
    // how many elements are currently in the array
    private int size;
    // array
    private Object[] array;

    public MyArrayList(){
        // calls the constructor for the class
        this(10);
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        array = new Object[this.capacity];
    }

    @Override
    public void add(T elements) {
        if (isFull()) {
            grow();
        } else {
            // adds the size after setting the value
            array[size++] = elements;
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        // this decreases the size and the array will only hold up to size - 1
        return (T) array[--size];
    }

    @Override
    public T removeFirst() {
//        if (isEmpty())
//            return null;
//
//        Object carry = array[size-1];
//
//        for (int i = size-2; i > 0; i++) {
//            Object temp = array[i];
//            array[i] = carry;
//            carry = temp;
//        }
//        size--;
//        T t = (T) array[0];
//        for (int i = 1; i < size; i++) {
//            array[i-1] = array[1];
//        }
//        size--;
//        return t;
        return remove(0);
    }

    @Override
    public T remove(int index) {
        if (isEmpty())
            return null;
        T t = (T) array[index];
        for (int i = index + 1; i < size; i++) {
            array[i-1] = array[i];
        }
        array[--size] = null;
        return t;
    }

    @Override
    public boolean isEmpty() {
//        if (this.size == 0) {
//            return true;
//        } else {
//            return false;
//        }
        // one-liner
        return this.size == 0;
    }

    @Override
    public boolean isFull() {
//        if (this.size == this.capacity) {
//            return true;
//        } else {
//            return false;
//        }
        return this.size == this.capacity;
    }

    private void grow(){
        this.capacity *= 2;
        Object[] temp = new Object[capacity];

        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }

        array = temp;
    }

    @Override
    public String toString(){
        String str = "The list is\n";

        if (isEmpty()) {
            return "List is empty";
        }

        for (int i = 0; i < size; i++) {
            str += array[i] + "\n";
        }
        return str;
    }


//    @Override
//    public Iterator<T> iterator() {
//        return new Iterable<>() {
//            int cursor = 0;
//            @Override
//            public boolean hasNext(){
//                return cursor != size;
//            }
//
//            @Override
//        }
//    }
}
