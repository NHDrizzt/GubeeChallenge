package testinho.service;

import java.util.List;
import java.util.stream.Collectors;

import testinho.annotation.Transaction;
import testinho.dao.ProdutoRepository;
import testinho.dao.DaoFactory;
import testinho.dao.LayerInjector;
import testinho.model.Market;
import testinho.model.Produto;
import testinho.model.Stack;

public class ProdutoServiceJdbc implements ProdutoService {

	ProdutoRepository produtoRepository = DaoFactory.getProdutoRepositoryProxy();
	
	@Override
	public String sqlMarket(List<Market> mk) {
		String sqlMarket = String.format("select a.* from myjdbc.produto as a, myjdbc.market as b where a.id = b.produto_id and b.name in (%s) group by id,name,description",
				mk.stream()
	            .map(x -> String.valueOf(x))
	            .collect(Collectors.joining("','", "'", "'")));
		
		return sqlMarket;
	}

	@Override
	public String sqlStack(List<Stack> st) {
		String sqlStack = String.format("select a.* from myjdbc.produto as a, myjdbc.stack as c where a.id = c.produto_id and c.name in  (%s)  group by id,name,description",
				 st.stream()
	             .map(x -> String.valueOf(x))
	             .collect(Collectors.joining("','", "'", "'")));
		return sqlStack;
	}
	
	@Transaction
	@Override
	public List<Produto> getData(String sqlMarket, String sqlStack) {
		return produtoRepository.databaseImplementation(sqlMarket, sqlStack);
	}

}
