package testinho.dao;

import java.util.List;

import testinho.annotation.Transaction;
import testinho.model.Produto;

public class ProdutoRepositoryProxy implements IProdutoRepository {

	private ProdutoRepository pr;
	
	public ProdutoRepositoryProxy(ProdutoRepository pr) {
		this.pr = pr;
	}
	
	@Transaction
	@Override
	public List<Produto> databaseImplementation(String sqlMarket, String sqlStack) {
		return pr.databaseImplementation(sqlMarket, sqlStack);
	}
	
	public void endData() {
		System.out.println("Finalizando execução do método : ");
	}
	

	
}
