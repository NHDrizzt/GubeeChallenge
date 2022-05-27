package testinho.service;

import java.util.List;

import testinho.model.Produto;

public interface AbstractServiceFactory {

	List<Produto> getMarketAndStack(String sqlMarket, String sqlStack);
	
}
