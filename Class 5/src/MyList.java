public interface MyList <T>{

    public void add(T elements);

    public T removeLast();

    public T removeFirst();

    public T remove(int index);

    public boolean isEmpty();

    public boolean isFull();
}
