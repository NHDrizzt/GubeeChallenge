package testinho.enums;

import testinho.dao.AbstractDaoFactory;
import testinho.dao.ProductRepository;
import testinho.dao.ProductRepositoryInMemoryFactory;
import testinho.dao.ProductRepositoryJdbcFactory;

public enum TypeDatabase {

	JDBC(new ProductRepositoryJdbcFactory()),
	MEMORY(new ProductRepositoryInMemoryFactory());

	final AbstractDaoFactory abstractFactory;


	private TypeDatabase(AbstractDaoFactory factory) {
		this.abstractFactory = factory;
	}
	
	public AbstractDaoFactory getFactory() {
		return this.abstractFactory;
	}
}
