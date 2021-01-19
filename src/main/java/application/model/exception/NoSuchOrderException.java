package application.model.exception;

public class NoSuchOrderException extends RuntimeException{
    public NoSuchOrderException(){
        super("User don't have such order");
    }
    public NoSuchOrderException(String message){
        super(message);
    }
}
