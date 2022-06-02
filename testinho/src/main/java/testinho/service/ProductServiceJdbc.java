package testinho.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import testinho.dao.AbstractDaoFactory;
import testinho.dao.ProductRepository;
import testinho.dao.ProductRepositoryJdbc;
import testinho.model.Market;
import testinho.model.Product;
import testinho.model.Stack;

public class ProductServiceJdbc implements ProductService {

	private final ProductRepository productRepository;

	public ProductRepository selectFactory(){
		return new ProductRepositoryJdbc();
	}
	public ProductServiceJdbc(AbstractDaoFactory factory) {
		productRepository = factory.createDatabase();
	}

	@Override
	public Set<Product> getMarketAndStack(List<Market> listMarket, List<Stack> listStack) {
		String sqlMarket = sqlMarket(listMarket);
		String sqlStack = sqlStack(listStack);
		return productRepository.listProductByMarketAndStack(sqlMarket, sqlStack);
	}
	
	public String sqlMarket(List<Market> mk) {
		return String.format("select a.* from myjdbc.produto as a, myjdbc.market as b where a.id = b.produto_id and b.name in (%s) group by id,name,description",
				mk.stream()
	            .map(String::valueOf)
	            .collect(Collectors.joining("','", "'", "'")));
	}

	public String sqlStack(List<Stack> st) {
		return String.format("select a.* from myjdbc.produto as a, myjdbc.stack as c where a.id = c.produto_id and c.name in  (%s)  group by id,name,description",
				 st.stream()
	             .map(String::valueOf)
	             .collect(Collectors.joining("','", "'", "'")));
	}

}
