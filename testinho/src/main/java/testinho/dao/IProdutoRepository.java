package testinho.dao;

import java.util.List;

import testinho.model.Produto;

public interface IProdutoRepository {
	
	List<Produto> databaseImplementation(String sqlMarket, String sqlStack);
	
	void endData();
}
