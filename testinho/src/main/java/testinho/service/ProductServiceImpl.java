package testinho.service;

import java.util.List;
import java.util.Set;

import testinho.dao.AbstractDaoFactory;
import testinho.dao.ProductRepository;
import testinho.model.Market;
import testinho.model.Product;
import testinho.model.Stack;

public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(AbstractDaoFactory factory) {
		productRepository = factory.createDatabase();
	}

	@Override
	public Set<Product> getMarketAndStack(List<Market> listMarket, List<Stack> listStack) {
		return productRepository.listProductByMarketAndStack(listMarket, listStack);
	}
}
