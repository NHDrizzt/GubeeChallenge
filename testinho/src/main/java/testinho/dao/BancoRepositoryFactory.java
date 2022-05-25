package testinho.dao;

import testinho.service.ProdutoService;
import testinho.service.ProdutoServiceJdbc;

public class BancoRepositoryFactory implements DaoRepositoryAbstractFactory {

	@Override
	public ProdutoRepository criarBancoJdbc() {
		return new ProdutoRepositoryProxy(new ProdutoRepositoryJdbc());
		
	}

	@Override
	public ProdutoService criaServicoJdbc() {
		return new ProdutoServiceJdbc();
	}

	
}
