package testinho.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import testinho.model.Market;
import testinho.model.Produto;
import testinho.model.Stack;

public class ProdutoRepositoryInMemory implements ProdutoRepository {
	
	private static final Map<Integer, Produto> myMapProduct = new HashMap<>();
	private static final Map<Integer, Stack> myMapStack = new HashMap<>();
	private static final Map<Integer, Market> myMapMarket = new HashMap<>();
	
	static {
		Produto p1 = new Produto(1, "Gubee Frete", "Gubee Frete Zero");
		Produto p2 = new Produto(2, "Gubee Seguro", "Gubee Segurança");
		Produto p3 = new Produto(3, "Gubee Dev", "Gubee Dev");
		myMapProduct.put(1,p1);
		myMapProduct.put(2,p2);
		myMapProduct.put(3,p3);
		
		Stack s1 = new Stack(1, "Java 10");
		Stack s2 = new Stack(2, "Kotlin");
		Stack s3 = new Stack(3, "Kafka");
		myMapStack.put(1,s1);
		myMapStack.put(2,s2);
		myMapStack.put(3,s3);
		
		Market m1 = new Market(1, "Ecommerce");
		Market m2 = new Market(2, "ERP");
		Market m3 = new Market(3, "Loja Fisica");
		myMapMarket.put(1,m1);
		myMapMarket.put(2,m2);
		myMapMarket.put(3,m3);
	}

	@Override
	public List<Produto> getMarketAndStack(String sqlMarket, String sqlStack) {
		List<Produto> list = new ArrayList<Produto>(myMapProduct.values());
		return list;
	}
	
}
