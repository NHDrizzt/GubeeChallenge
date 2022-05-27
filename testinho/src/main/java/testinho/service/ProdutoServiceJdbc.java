package testinho.service;

import java.util.List;
import java.util.stream.Collectors;

import testinho.annotation.Transaction;
import testinho.dao.AbstractDaoFactory;
import testinho.dao.ProdutoRepository;
import testinho.dao.ProdutoRepositoryJdbc;
import testinho.dao.ProdutoRepositoryJdbcFactory;
import testinho.dao.ProdutoRepositoryProxy;
import testinho.model.Market;
import testinho.model.Produto;
import testinho.model.Stack;

public class ProdutoServiceJdbc implements ProdutoService {

	ProdutoRepository produtoRepository = new ProdutoRepositoryProxy(new ProdutoRepositoryJdbc());
	
	public ProdutoServiceJdbc(AbstractDaoFactory factory) {
		produtoRepository = factory.criarBanco();
	}
	
	@Override
	public List<Produto> getMarketAndStack(List<Market> listMarket, List<Stack> listStack) {
		String sqlMarket = sqlMarket(listMarket);
		String sqlStack = sqlStack(listStack);
		return produtoRepository.getMarketAndStack(sqlMarket, sqlStack);
	}
	
	public String sqlMarket(List<Market> mk) {
		String sqlMarket = String.format("select a.* from myjdbc.produto as a, myjdbc.market as b where a.id = b.produto_id and b.name in (%s) group by id,name,description",
				mk.stream()
	            .map(x -> String.valueOf(x))
	            .collect(Collectors.joining("','", "'", "'")));
		
		return sqlMarket;
	}

	public String sqlStack(List<Stack> st) {
		String sqlStack = String.format("select a.* from myjdbc.produto as a, myjdbc.stack as c where a.id = c.produto_id and c.name in  (%s)  group by id,name,description",
				 st.stream()
	             .map(x -> String.valueOf(x))
	             .collect(Collectors.joining("','", "'", "'")));
		return sqlStack;
	}

}
