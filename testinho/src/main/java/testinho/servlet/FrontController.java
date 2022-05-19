package testinho.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import testinho.controller.FrontCommand;
import testinho.controller.UnknownCommand;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request,
    HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
    HttpServletResponse response)
            throws ServletException, IOException {
    	FrontCommand command = getCommand(request);
        command.init(request, response);
        command.process();
    }
    
    private FrontCommand getCommand(HttpServletRequest request) {
        try {
            Class type = Class.forName("testinho.controller.ExibirProdutoCommand");
            return (FrontCommand) type.asSubclass(FrontCommand.class).newInstance();
        } catch (Exception e) {
        	return new UnknownCommand();
        }
    }

}
