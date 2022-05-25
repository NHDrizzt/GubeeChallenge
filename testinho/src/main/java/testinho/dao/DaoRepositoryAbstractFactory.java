package testinho.dao;

import testinho.service.ProdutoService;

public interface DaoRepositoryAbstractFactory {
	
	public ProdutoRepository criarBancoJdbc();
	
	public ProdutoService criaServicoJdbc();

}
