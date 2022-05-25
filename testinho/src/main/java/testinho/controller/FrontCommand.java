package testinho.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class FrontCommand {

    public abstract void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    protected void forward(String target, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        target = String.format("%s.jsp", target);
        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }
}