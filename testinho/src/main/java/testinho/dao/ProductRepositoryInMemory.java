package testinho.dao;

import java.util.*;

import testinho.model.Market;
import testinho.model.Product;
import testinho.model.Stack;

public class ProductRepositoryInMemory implements ProductRepository {
	
	private static final Map<Integer, Product> myMapProduct = new HashMap<>();
	private static final Map<Integer, Stack> myMapStack = new HashMap<>();
	private static final Map<Integer, Market> myMapMarket = new HashMap<>();

	private static final Product p1 = new Product(1, "Gubee Frete", "Gubee Frete Zero");
	private static final Product p2 = new Product(2, "Gubee Seguro", "Gubee Segurança");
	private static final Product p3 = new Product(3, "Gubee Dev", "Gubee Dev");

	private static final Stack s1 = new Stack("Java 10");
	private static final Stack s2 = new Stack("Kotlin");
	private static final Stack s3 = new Stack("Kafka");

	private static final Market m1 = new Market("Ecommerce");
	private static final Market m2 = new Market("ERP");
	private static final Market m3 = new Market("Loja Fisica");

	static {

		myMapProduct.put(1,p1);
		myMapProduct.put(2,p2);
		myMapProduct.put(3,p3);

		myMapStack.put(1,s1);
		myMapStack.put(2,s2);
		myMapStack.put(3,s3);

		myMapMarket.put(1,m1);
		myMapMarket.put(2,m2);
		myMapMarket.put(3,m3);
	}

	@Override
	public Set<Product> listProductByMarketAndStack(List<Market> listMarket, List<Stack> listStack) {
		String sqlMarket = listMarket.toString();
		String sqlStack = listStack.toString();
		return new LinkedHashSet<>(myMapProduct.values());
	}
}
