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
	
	public void endData() {
		System.out.println("Finalizando execução do método : ");
	}
	
	@Transaction
	@Override
	public List<Produto> databaseImplementation(String sqlMarket, String sqlStack) {
		List<Produto> listProd = new ArrayList<>();
		
		for(Method method : ProdutoRepositoryProxy.class.getDeclaredMethods()) {
			if(method.isAnnotationPresent(Transaction.class)) {
				System.out.println("Iniciando execução do método "+ method.getName());
		        
			}
		}
		
		listProd = produtoRepositoryJdbc.databaseImplementation(sqlMarket, sqlStack);
		if(listProd != null) {
			endData();
		}
		
		return produtoRepositoryJdbc.databaseImplementation(sqlMarket, sqlStack);
	}

	@Override
	public Produto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	
}
