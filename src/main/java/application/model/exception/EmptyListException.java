package application.model.exception;

public class EmptyListException extends RuntimeException{
    public EmptyListException(){
        super("List is empty.");
    }
    public EmptyListException(String message){
        super(message);
    }
}
