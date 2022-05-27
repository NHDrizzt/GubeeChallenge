package testinho.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testinho.dao.AbstractDaoFactory;
import testinho.dao.ProdutoRepositoryInMemoryFactory;
import testinho.dao.ProdutoRepositoryJdbcFactory;
import testinho.db.ControllerException;
import testinho.enums.TypeDatabase;
import testinho.model.Market;
import testinho.model.Produto;
import testinho.model.Stack;
import testinho.service.ProdutoServiceInMemory;
import testinho.service.ProdutoServiceJdbc;

public class ExibirProdutoCommand extends FrontCommand {

	//AbstractDaoFactory abstractFactory = TypeDatabase.MEMORY.getFactory();
	//ProdutoServiceInMemory produtoServiceInMemory = new ProdutoServiceInMemory(abstractFactory);

	AbstractDaoFactory abstractDaoFactory = TypeDatabase.JDBC.getFactory();
	 ProdutoServiceJdbc produtoServiceJdbc = new ProdutoServiceJdbc(abstractDaoFactory);

	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) {
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
			listResult = produtoServiceJdbc.getMarketAndStack(listMarket, listStack);
			//listResult = produtoServiceInMemory.getMarketAndStack(listMarket, listStack);
			request.setAttribute("produtos", listResult);
			forward("exibirProduto", request, response);
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
	}
}
