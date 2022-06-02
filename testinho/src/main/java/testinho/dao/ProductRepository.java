package testinho.dao;

import java.util.List;
import java.util.Set;

import testinho.model.Product;

public interface ProductRepository {

	Set<Product> listProductByMarketAndStack(String sqlMarket, String sqlStack);
	
}
