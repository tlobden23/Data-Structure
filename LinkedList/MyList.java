public interface MyList<T>  {

    public void addFirst(T e);
    public void addLast(T e);
    public T removeFirst();
    public T removeLast();
    public boolean isEmpty();

}
