package testinho.dao;

public class DaoFactory {
	
	public static ProdutoRepository getProdutoRepositoryProxy() {
		return new ProdutoRepositoryProxy(new ProdutoRepositoryJdbc());
	}
}
