package application.controller.servlet;


import application.controller.command.Command;
import application.controller.command.impl.LoginCommand;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDisp = request.getRequestDispatcher("/index.jsp");
        requestDisp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //ServletContext cont = request.getServletContext();
        Command command = new LoginCommand();
        String path = command.execute(request, response);
        //cont.getRequestDispatcher(path).forward(request, response);

        response.sendRedirect(path);
    }

}

