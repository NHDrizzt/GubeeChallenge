package testinho.service;

import java.util.List;
import java.util.Set;

import testinho.dao.AbstractDaoFactory;
import testinho.dao.ProductRepository;
import testinho.dao.ProductRepositoryInMemory;
import testinho.model.Market;
import testinho.model.Product;
import testinho.model.Stack;

public class ProductServiceInMemory  implements  ProductService {
	
	private final ProductRepository productRepositoryInMemory;
	
	public ProductServiceInMemory(AbstractDaoFactory factory) {
		productRepositoryInMemory = factory.createDatabase();
	}
	@Override
	public Set<Product> getMarketAndStack(List<Market> listMarket, List<Stack> listStack) {
		String sqlMarket = listMarket.toString();
		String sqlStack = listStack.toString();
		return productRepositoryInMemory.listProductByMarketAndStack(sqlMarket, sqlStack);
	}
}
