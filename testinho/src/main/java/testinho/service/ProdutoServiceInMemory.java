package testinho.service;

import java.util.List;

import testinho.dao.AbstractDaoFactory;
import testinho.dao.ProdutoRepository;
import testinho.dao.ProdutoRepositoryInMemory;
import testinho.dao.ProdutoRepositoryInMemoryFactory;
import testinho.model.Market;
import testinho.model.Produto;
import testinho.model.Stack;

public class ProdutoServiceInMemory {
	
	ProdutoRepository produtoRepository = new ProdutoRepositoryInMemory();
	
	public ProdutoServiceInMemory(AbstractDaoFactory factory) {
		produtoRepository = factory.criarBanco();
	}

	public List<Produto> getMarketAndStack(List<Market> listMarket, List<Stack> listStack) {
		String sqlMarket = listMarket.toString();
		String sqlStack = listStack.toString();
		return produtoRepository.getMarketAndStack(sqlMarket, sqlStack);
	}
}
