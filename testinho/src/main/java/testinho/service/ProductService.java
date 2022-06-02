package testinho.service;

import java.util.List;
import java.util.Set;

import testinho.model.Market;
import testinho.model.Product;
import testinho.model.Stack;

public interface ProductService {

	Set<Product> getMarketAndStack(List<Market> listMarket, List<Stack> listStack);
	
}
