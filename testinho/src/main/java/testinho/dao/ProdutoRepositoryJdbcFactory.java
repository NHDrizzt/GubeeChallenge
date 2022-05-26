package testinho.dao;

public class ProdutoRepositoryJdbcFactory implements AbstractDaoFactory {

	@Override
	public ProdutoRepository criarBanco() {
		return new ProdutoRepositoryProxy(new ProdutoRepositoryJdbc());
	}
}
