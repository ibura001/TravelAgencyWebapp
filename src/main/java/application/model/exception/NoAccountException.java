package application.model.exception;

public class NoAccountException extends RuntimeException{
    public NoAccountException(){
        super("Account doesn`t exist");
    }
    public NoAccountException(String message){
        super(message);
    }
}
