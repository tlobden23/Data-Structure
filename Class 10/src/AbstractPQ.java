import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class AbstractPQ<K,V> implements PQ<K,V> {

    int size;

    static class PQEntry<K,V> implements Entry<K,V> {
        // instance variable for the static class
        private K key;
        private V value;

        // getters
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        // setters
        public void setKey(K key){
            this.key = key;
        }

        public void setValue(V value){
            this.value = value;
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
