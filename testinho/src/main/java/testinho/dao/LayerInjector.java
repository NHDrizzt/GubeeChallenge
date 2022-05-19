package testinho.dao;

import testinho.service.IProdutoService;
import testinho.service.ProdutoService;

public class LayerInjector {
	
	public static IProdutoRepository getProdutoRepository() {
		return new ProdutoRepository();
	}
	
	public static IProdutoService getProdutoService() {
		return new ProdutoService();
	}
	
}