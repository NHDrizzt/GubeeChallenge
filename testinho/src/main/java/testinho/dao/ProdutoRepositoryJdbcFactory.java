package testinho.dao;

import testinho.service.ProdutoService;
import testinho.service.ProdutoServiceJdbc;

public class ProdutoRepositoryJdbcFactory implements AbstractDaoFactory {

	@Override
	public ProdutoRepository criarBanco() {
		return new ProdutoRepositoryProxy(new ProdutoRepositoryJdbc());
		
	}

	@Override
	public ProdutoService criaServico() {
		return null;
	}

	
}
