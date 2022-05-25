package testinho.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testinho.annotation.Transaction;
import testinho.controller.Command;
import testinho.dao.IProdutoRepository;
import testinho.dao.LayerInjector;
import testinho.model.Market;
import testinho.model.Produto;
import testinho.model.Stack;
import testinho.service.IProdutoService;

@WebServlet("/exibirProdutoController")
public class ExibirProdutoController extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;
	
	IProdutoService rs = LayerInjector.getProdutoService();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	
	}

	@Transaction
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Market> listMarket = new ArrayList<>();
		List<Stack> listStack = new ArrayList<>();
		List<Produto> listResult = new ArrayList<>();

		String[] valuesMarket = request.getParameterValues("anyMarket");
		String[] valuesStack = request.getParameterValues("anyStack");
		
		if(valuesMarket != null && valuesMarket.length != 0) {
			for(int i=0; i<valuesMarket.length;i++) {
				Market mk = new Market();
				mk.setName(valuesMarket[i]);
				listMarket.add(mk);
			}
		}
		
		if(valuesStack != null && valuesStack.length != 0) {
			for(int i=0; i<valuesStack.length;i++) {
				Stack st = new Stack();
				st.setName(valuesStack[i]);
				listStack.add(st);
			}
		}
		
		try {
			
			String sqlMarket = rs.sqlMarket(listMarket);
			String sqlStack = rs.sqlStack(listStack);
			
			listResult = rs.getData(sqlMarket, sqlStack);	
			request.setAttribute("produtos", listResult);
			String target = "exibirProduto";
			forward(request,response,target);

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void forward(HttpServletRequest request, HttpServletResponse response, String target) {
		target = String.format("%s.jsp", target);
        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
        try {
        	System.out.println("Finalizando execução do método");
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
}

