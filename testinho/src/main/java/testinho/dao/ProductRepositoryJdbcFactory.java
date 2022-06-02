package testinho.dao;

public class ProductRepositoryJdbcFactory implements AbstractDaoFactory {

	@Override
	public ProductRepository createDatabase() {
		return new ProductRepositoryProxy(new ProductRepositoryJdbc());
	}
}
