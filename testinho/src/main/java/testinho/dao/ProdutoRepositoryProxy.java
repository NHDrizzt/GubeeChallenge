package testinho.dao;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import testinho.annotation.Transaction;
import testinho.model.Produto;

public class ProdutoRepositoryProxy implements ProdutoRepository {

	private ProdutoRepositoryJdbc produtoRepositoryJdbc;
	
	public ProdutoRepositoryProxy(ProdutoRepositoryJdbc produtoRepositoryJdbc) {
		this.produtoRepositoryJdbc = produtoRepositoryJdbc;
	}
	
	@Transaction
	@Override
	public List<Produto> getMarketAndStack(String sqlMarket, String sqlStack) {
		List<Produto> listProd = new ArrayList<>();
		for(Method method : ProdutoRepositoryProxy.class.getDeclaredMethods()) {
			if(method.isAnnotationPresent(Transaction.class)) {
				System.out.println("Iniciando execução do método "+ method.getName());      
			}
		}
		
		try {
			listProd = produtoRepositoryJdbc.getMarketAndStack(sqlMarket, sqlStack);
			if(listProd != null) {
				System.out.println("Finalizando execução com sucesso");
			}
		}
		catch(Exception e) {
			System.out.println("Finalizando execução do metodo com erro "+ e.getMessage());
			throw e;
		}
		return listProd;
		
	}
	
}
