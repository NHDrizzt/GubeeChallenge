package testinho.dao;

import java.util.List;
import java.util.Set;

import testinho.model.Market;
import testinho.model.Product;
import testinho.model.Stack;

public interface ProductRepository {

	Set<Product> listProductByMarketAndStack(List<Market> listMarket, List<Stack> listStack);
	
}
