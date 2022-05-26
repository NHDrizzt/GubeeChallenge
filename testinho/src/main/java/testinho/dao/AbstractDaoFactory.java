package testinho.dao;

import testinho.service.ProdutoService;

public interface AbstractDaoFactory {
	
	public ProdutoRepository criarBanco();
	
	public ProdutoService criaServico();

}
