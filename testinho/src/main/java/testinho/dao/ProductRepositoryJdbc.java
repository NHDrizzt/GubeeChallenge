package testinho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

import testinho.annotation.Transaction;
import testinho.db.DbConnection;
import testinho.db.DbException;
import testinho.model.Market;
import testinho.model.Product;
import testinho.model.Stack;

public class ProductRepositoryJdbc implements ProductRepository, ConnectionProvider {
	@Override
	public Connection establishConnection() {
		return DbConnection.getConnection();
	}
	@Transaction
	@Override
	public Set<Product> listProductByMarketAndStack(List<Market> listMarket, List<Stack> listStack) {
		Set<Product> listProduct = new LinkedHashSet<>();
		try (Connection conn = establishConnection()){
			PreparedStatement psMarket = conn.prepareStatement(selectedMarket(listMarket));
			PreparedStatement psStack = conn.prepareStatement(selectedStack(listStack));
			listProduct.addAll(createResulSet(psMarket));
			listProduct.addAll(createResulSet(psStack));
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		return listProduct;
	}

	private Set<Product> createResulSet(PreparedStatement psStatement) {
		Set<Product> setProd = new LinkedHashSet<>();
		try {
			ResultSet rsMarket = psStatement.executeQuery();
			while(rsMarket.next()) {
				Product p = new Product();
				p.setId(rsMarket.getInt(1));
				p.setName(rsMarket.getString(2));
				p.setDescription(rsMarket.getString(3));
				setProd.add(p);
			}
			rsMarket.close();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		return setProd;
	}

	private String selectedMarket(List<Market> listMarket) {
		return String.format("select a.* from myjdbc.produto as a, myjdbc.market as b where a.id = b.produto_id and b.name in (%s) group by id,name,description",
				listMarket.stream()
						.map(String::valueOf)
						.collect(Collectors.joining("','", "'", "'")));
	}

	private String selectedStack(List<Stack> listStack) {
		return String.format("select a.* from myjdbc.produto as a, myjdbc.stack as c where a.id = c.produto_id and c.name in  (%s)  group by id,name,description",
				listStack.stream()
						.map(String::valueOf)
						.collect(Collectors.joining("','", "'", "'")));
	}
}
