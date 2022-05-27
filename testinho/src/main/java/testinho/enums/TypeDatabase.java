package testinho.enums;

import testinho.dao.AbstractDaoFactory;
import testinho.dao.ProdutoRepository;
import testinho.dao.ProdutoRepositoryInMemoryFactory;
import testinho.dao.ProdutoRepositoryJdbcFactory;

public enum TypeDatabase {

	JDBC(new ProdutoRepositoryJdbcFactory()),
	MEMORY(new ProdutoRepositoryInMemoryFactory());

	AbstractDaoFactory abstractFactory;
	
	private TypeDatabase(AbstractDaoFactory factory) {
		this.abstractFactory = factory;
	}
	
	public AbstractDaoFactory getFactory() {
		return this.abstractFactory;
	}
}
