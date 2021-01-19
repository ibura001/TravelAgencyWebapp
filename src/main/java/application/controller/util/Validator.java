package application.controller.util;

import application.model.exception.UnsupportedUsernameException;
import application.model.exception.WrongPasswordException;

import javax.servlet.http.HttpServletRequest;

public class Validator {

    public static void checkPassword(HttpServletRequest request) {
        String password = request.getParameter("password");
        String confirmPass = request.getParameter("confirm_password");
        if (!password.equals(confirmPass))
            throw new WrongPasswordException();
    }

    public static void checkUsername(HttpServletRequest request) throws UnsupportedUsernameException {
        String username = request.getParameter("username");
        if (!username.matches("^[a-z0-9_-]{3,20}$"))
            throw new UnsupportedUsernameException();
    }


}
