package application.controller.command.impl;

import application.controller.util.Validator;
import application.model.entity.User;
import application.model.exception.BookedUsernameException;
import application.model.exception.InvalidPasswordException;
import application.model.exception.MySqlException;
import application.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand extends AbstractCommand {

    private UserService service;

    public RegistrationCommand(){
        this.service = new UserService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String registrationResult = null;
        try {
            Validator.checkUsername(request);
            Validator.checkPassword(request);
            registrationResult = service.registration(getUserData(request));
        } catch (BookedUsernameException | InvalidPasswordException e) {
            setErrorRequest(request, response, e.getMessage(), "/TravelAgencyWebapp_war/registration");
        } catch (MySqlException e) {
            setErrorRequest(request, response, e.getMessage(), "/TravelAgencyWebapp_war/registration");
        }
        //request.setAttribute("success", registrationResult);
        request.setAttribute("pagelink", "/login");
        return "/TravelAgencyWebapp_war/userTours";
    }

    private User getUserData(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");

        return new User(username, password, firstName, lastName, email, phoneNumber );
    }
}
