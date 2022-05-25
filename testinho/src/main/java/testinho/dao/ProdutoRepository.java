package testinho.dao;

import java.util.List;

import testinho.model.Produto;

public interface ProdutoRepository {
	
	List<Produto> databaseImplementation(String sqlMarket, String sqlStack);
	
	void endData();
}
