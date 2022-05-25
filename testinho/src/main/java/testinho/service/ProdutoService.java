package testinho.service;

import java.util.List;

import testinho.model.Market;
import testinho.model.Produto;
import testinho.model.Stack;

public interface ProdutoService {
	
	String sqlMarket(List<Market> mk);
	
	String sqlStack(List<Stack> st);

	List<Produto> getData(String sqlMarket, String sqlStack);
}
