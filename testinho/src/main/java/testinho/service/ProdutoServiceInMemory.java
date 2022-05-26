package testinho.service;

import java.util.List;

import testinho.dao.AbstractDaoFactory;
import testinho.dao.ProdutoRepository;
import testinho.dao.ProdutoRepositoryInMemory;
import testinho.dao.ProdutoRepositoryInMemoryFactory;
import testinho.model.Market;
import testinho.model.Produto;
import testinho.model.Stack;

public class ProdutoServiceInMemory implements ProdutoService {
	
	ProdutoRepository produtoRepository = new ProdutoRepositoryInMemory();
	
	public ProdutoServiceInMemory(AbstractDaoFactory factory) {
		produtoRepository = factory.criarBanco();
	}

	@Override
	public List<Produto> getMarketAndStack(String sqlMarket, String sqlStack) {
		return produtoRepository.getMarketAndStack(sqlMarket, sqlStack);
	}

}
