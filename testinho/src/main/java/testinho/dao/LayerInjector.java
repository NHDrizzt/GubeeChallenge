package testinho.dao;

import testinho.service.ProdutoService;
import testinho.service.ProdutoServiceJdbc;

public class LayerInjector {
	
	public static ProdutoRepository getProdutoRepository() {
		return new ProdutoRepositoryJdbc();
	}
	
	public static ProdutoService getProdutoService() {
		return new ProdutoServiceJdbc();
	}
	
}