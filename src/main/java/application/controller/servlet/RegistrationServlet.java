package application.controller.servlet;


import application.controller.command.Command;
import application.controller.command.impl.LoginCommand;
import application.controller.command.impl.RegistrationCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "RegistrationServlet", urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDisp = request.getRequestDispatcher("/jsp/registration.jsp");
        requestDisp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ServletContext cont = request.getServletContext();
        //RegistrationCommand command = new RegistrationCommand();
        //String path = command.execute(request, response);
        // cont.getRequestDispatcher(path).forward(request, response);

        Command command = new RegistrationCommand();
        String path = command.execute(request, response);
        response.sendRedirect(path);

        //response.sendRedirect("/jsp/user/tours.jsp");
    }
}
