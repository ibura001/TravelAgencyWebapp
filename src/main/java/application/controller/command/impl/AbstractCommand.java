package application.controller.command.impl;

import application.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractCommand implements Command {

    public void setErrorRequest(HttpServletRequest request, HttpServletResponse response, String errMessage, String page) throws ServletException, IOException {
        request.setAttribute("error", errMessage);
        request.setAttribute("pagelink", page);
        request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    }
}
