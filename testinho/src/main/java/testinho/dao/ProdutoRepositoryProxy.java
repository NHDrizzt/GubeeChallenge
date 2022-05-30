package testinho.dao;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import testinho.annotation.Transaction;
import testinho.model.Produto;

public class ProdutoRepositoryProxy implements ProdutoRepository {

	private ProdutoRepository produtoRepository;
	
	public ProdutoRepositoryProxy(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@Override
	public List<Produto> getMarketAndStack(String sqlMarket, String sqlStack) {
		List<Produto> listProd = new ArrayList<>();
		try {
			for(Method method : ProdutoRepositoryJdbc.class.getDeclaredMethods()) {
				if(method.isAnnotationPresent(Transaction.class)) {
					System.out.println("Iniciando execução do método "+ method.getName());
					listProd = produtoRepository.getMarketAndStack(sqlMarket, sqlStack);
				}
				
			}
			if(listProd == null) {
				System.out.println("Finalizando execução com sucesso");
				throw new Exception();
			}
		}
		catch(Exception e) {
			System.out.println("Finalizando execução do metodo com erro "+ e.getMessage());
		}
		return listProd;
 
	}
	
}
