package testinho.dao;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import testinho.annotation.Transaction;
import testinho.model.Produto;

public class daoFactory {
	
	IProdutoRepository pr = new ProdutoRepositoryProxy(new ProdutoRepository());

	public List<Produto> dataImpProxy(String sqlMarket, String sqlStack) {
		List<Produto> listProd = new ArrayList<>();
		
		for(Method method : ProdutoRepositoryProxy.class.getDeclaredMethods()) {
			if(method.isAnnotationPresent(Transaction.class)) {
				System.out.println("Iniciando execução do método "+ method.getName());
		        
			}
		}
		listProd = pr.databaseImplementation(sqlMarket, sqlStack);
		if(listProd != null) {
			pr.endData();
		}
		return listProd;
	}
	
}
