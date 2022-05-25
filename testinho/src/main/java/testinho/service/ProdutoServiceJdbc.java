package testinho.service;

import java.util.List;
import java.util.stream.Collectors;

import testinho.annotation.Transaction;
import testinho.dao.BancoRepositoryFactory;
import testinho.dao.DaoRepositoryAbstractFactory;
import testinho.dao.ProdutoRepositoryJdbc;
import testinho.model.Market;
import testinho.model.Produto;
import testinho.model.Stack;

public class ProdutoServiceJdbc implements ProdutoService {

	DaoRepositoryAbstractFactory daoFactory = new BancoRepositoryFactory();
	
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
		return daoFactory.criarBancoJdbc().databaseImplementationJdbc(sqlMarket, sqlStack);
	}

}
