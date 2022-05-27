package testinho.dao;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import testinho.annotation.Transaction;
import testinho.db.DbException;
import testinho.model.Produto;

public class ProdutoRepositoryProxy implements ProdutoRepository {

	private ProdutoRepository produtoRepositoryJdbc;
	
	public ProdutoRepositoryProxy(ProdutoRepositoryJdbc produtoRepositoryJdbc) {
		this.produtoRepositoryJdbc = produtoRepositoryJdbc;
	}
	
	@Override
	public List<Produto> getMarketAndStack(String sqlMarket, String sqlStack) {
		List<Produto> listProd = new ArrayList<>();
		try {
			for(Method method : ProdutoRepositoryJdbc.class.getDeclaredMethods()) {
				if(method.isAnnotationPresent(Transaction.class)) {
					System.out.println("Iniciando execu��o do m�todo "+ method.getName());  
					method.invoke(sqlMarket, sqlStack);
					listProd = produtoRepositoryJdbc.getMarketAndStack(sqlMarket, sqlStack);	
				}
				
			}
			if(listProd == null) {
				System.out.println("Finalizando execu��o com sucesso");
				throw new Exception();
			}
		}
		catch(Exception e) {
			System.out.println("Finalizando execu��o do metodo com erro "+ e.getMessage());
		}
		return listProd;
 
	}
	
}
