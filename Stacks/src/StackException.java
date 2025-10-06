public class StackException extends Exception {

    public StackException(){
        super("Invalid operation in the stack!");
    }

    public StackException(String message){
        super(message);
    }
}
