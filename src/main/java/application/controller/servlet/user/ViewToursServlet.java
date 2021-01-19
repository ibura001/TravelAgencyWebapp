package application.controller.servlet.user;


import application.controller.command.impl.ViewToursCommand;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewUserToursServlet", urlPatterns = {"/userTours"})
public class ViewToursServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        ViewToursCommand command = new ViewToursCommand();
        String path = command.execute(request,response);
        context.getRequestDispatcher(path).forward(request,response);
    }

}
