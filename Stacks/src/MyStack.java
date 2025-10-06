public class MyStack<T> implements StackInterface<T>{

    Object[] stack;
    int size;
    int top; //  Top means where you are and always should start with -1

    public MyStack(){
        size = 10;
        stack  = new Object[size];
        top = -1;

    }
    public MyStack(int size){
        this.size = size;
        stack = new Object[size];
        top = -1;
    }
    @Override
    public void push(T e) throws StackException {

        if(isFull())
            throw new StackException("The stack is full");

        stack[++top] = e;
    }

    @SuppressWarnings("Unchecked")
    @Override
    public T pop() throws StackException {

        if(isEmpty())
            throw new StackException("The stack is empty");

        return (T) stack[top--];
    }

    @Override
    public T peek() {
        if(isEmpty())
        return null;

        return (T) stack[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;

    }

    @Override
    public boolean isFull() {
        return top == size-1;
    }
}
