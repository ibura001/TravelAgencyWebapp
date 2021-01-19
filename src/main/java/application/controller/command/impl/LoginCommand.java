package application.controller.command.impl;

import application.model.entity.User;
import application.model.exception.BlockedUserException;
import application.model.exception.InvalidPasswordException;
import application.model.exception.MySqlException;
import application.model.exception.NoAccountException;
import application.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand extends AbstractCommand{

    private UserService service;

    public LoginCommand() {
        service = new UserService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = null;
        try {
            User user = service.login(getUserData(request));
            session = request.getSession(true);
            session.setAttribute("username", user.getUsername());
            session.setAttribute("role", user.getRole());
        } catch (NoAccountException | InvalidPasswordException | BlockedUserException | MySqlException e) {
            setErrorRequest(request, response, e.getMessage(), "/TravelAgencyWebapp_war/login");
        }
        //request.setAttribute("success", "Welcome,  " + session.getAttribute("username") + "! ");
        request.setAttribute("pagelink", "/registration");
        return "/TravelAgencyWebapp_war/userTours";
    }

    private User getUserData(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return new User(username, password);
    }

}
