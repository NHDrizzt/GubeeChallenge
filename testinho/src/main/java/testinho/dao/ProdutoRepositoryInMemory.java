package testinho.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import testinho.model.Produto;

public class ProdutoRepositoryInMemory implements ProdutoRepository {
	
	private static final Map<Integer, Produto> myMap = new HashMap<>();
	
	static {
		Produto p1 = new Produto(1, "Gubee Frete", "Gubee Frete Zero");
		Produto p2 = new Produto(2, "Gubee Seguro", "Gubee Segurança");
		Produto p3 = new Produto(3, "Gubee Dev", "Gubee Dev");
		myMap.put(1,p1);
		myMap.put(2,p2);
		myMap.put(3,p3);
	}

	@Override
	public List<Produto> getMarketAndStack(String sqlMarket, String sqlStack) {
		List<Produto> list = new ArrayList<Produto>(myMap.values());
		return list;
	}
	
}
