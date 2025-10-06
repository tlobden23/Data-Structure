
public interface StackInterface <T>{

    public void push(T e) throws StackException;

    public T pop() throws StackException;

    public T peek();

    public boolean isEmpty();

    public boolean isFull();
}
