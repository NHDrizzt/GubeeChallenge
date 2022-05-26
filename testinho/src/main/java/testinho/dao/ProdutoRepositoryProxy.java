package testinho.dao;

import java.lang.reflect.Method;
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
		
		for(Method method : ProdutoRepositoryProxy.class.getDeclaredMethods()) {
			if(method.isAnnotationPresent(Transaction.class)) {
				System.out.println("Iniciando execução do método "+ method.getName());      
			}
		}
		
		try {
			return produtoRepositoryJdbc.getMarketAndStack(sqlMarket, sqlStack);
		}
		catch(Exception e) {
			throw e;
		}
		
	}
	
}
