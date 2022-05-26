package testinho.dao;

import java.util.List;

import testinho.model.Produto;

public interface ProdutoRepository {
	
	List<Produto> getMarketAndStack(String sqlMarket, String sqlStack);
	
}
