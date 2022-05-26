package testinho.service;

import java.util.List;

import testinho.model.Market;
import testinho.model.Produto;
import testinho.model.Stack;

public interface ProdutoService {

	List<Produto> getMarketAndStack(String sqlMarket, String sqlStack);
	
}
