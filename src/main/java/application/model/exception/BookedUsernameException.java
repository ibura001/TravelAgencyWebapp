package application.model.exception;

public class BookedUsernameException extends RuntimeException{
    public BookedUsernameException(){
        super("Unsupported username");
    }
    public BookedUsernameException(String message) {
        super(message);
    }
}
