package application.model.exception;

import java.sql.SQLException;

public class MySqlException extends SQLException {
    public MySqlException(){
        super("Sorry, something went wrong. We are working on getting this fixed as soon as we can.");
    }
}
