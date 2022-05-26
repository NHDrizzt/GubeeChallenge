package testinho.dao;

import testinho.service.ProdutoService;

public class ProdutoRepositoryInMemoryFactory implements AbstractDaoFactory{

	@Override
	public ProdutoRepository criarBanco() {
		return new ProdutoRepositoryInMemory();
	}

	@Override
	public ProdutoService criaServico() {
		return null;
	}

}
