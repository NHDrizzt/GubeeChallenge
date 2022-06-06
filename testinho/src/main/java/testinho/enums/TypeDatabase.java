package testinho.enums;

import testinho.dao.AbstractDaoFactory;
import testinho.dao.ProductRepositoryInMemoryFactory;
import testinho.dao.ProductRepositoryJdbcFactory;

import java.lang.reflect.Type;

public enum TypeDatabase {

	JDBC(new ProductRepositoryJdbcFactory()),
	INMEMORY(new ProductRepositoryInMemoryFactory()),

	DEFAULT();
	private AbstractDaoFactory abstractFactory;

	TypeDatabase(AbstractDaoFactory factory) {
		this.abstractFactory = factory;
	}
	TypeDatabase() {

	}

	public AbstractDaoFactory getInstance() {
		return this.abstractFactory;
	}

	public AbstractDaoFactory getDefaultFactory() {
		return TypeDatabase.JDBC.getInstance();
	}
}
