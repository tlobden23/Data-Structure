public interface PQ <K,V>{

    // the reason this method throws an exception is becuase you have to have a key that is valid and
    // comparable
    Entry<K,V> insert(K k,V v) throws IllegalArgumentException;

    Entry<K,V> removeMin();

    Entry<K,V> min();

    int size();

    boolean isEmpty();

}
