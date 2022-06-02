package testinho.dao;

public class ProductRepositoryInMemoryFactory implements AbstractDaoFactory{

	@Override
	public ProductRepository createDatabase() {
		return new ProductRepositoryInMemory();
	} 
}
