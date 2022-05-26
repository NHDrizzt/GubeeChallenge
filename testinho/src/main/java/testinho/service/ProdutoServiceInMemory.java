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
	public String sqlMarket(List<Market> mk) {
		return null;
	}

	@Override
	public String sqlStack(List<Stack> st) {
		return null;
	}

	@Override
	public List<Produto> getData(String sqlMarket, String sqlStack) {
		return null;
	}
	
	public Produto getById(int id) {
		return produtoRepository.findById(id);
	}
	
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}
	
	public void Application(AbstractDaoFactory factory) {
		
	}

}
