package testinho.controller;

import java.util.ArrayList;
import java.util.List;
import testinho.dao.LayerInjector;
import testinho.db.DbException;
import testinho.model.Market;
import testinho.model.Produto;
import testinho.model.Stack;
import testinho.service.IProdutoService;

public class ExibirProdutoCommand extends FrontCommand {

	IProdutoService rs = LayerInjector.getProdutoService();
	@Override
	public void process() {

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
			forward("exibirProduto");

		} catch (Exception e) {
			throw new DbException(e.getMessage());
		
		}
	}
}
