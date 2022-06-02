package testinho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import testinho.annotation.Transaction;
import testinho.db.DbConnection;
import testinho.db.DbException;
import testinho.model.Product;

public class ProductRepositoryJdbc implements ProductRepository, ConnectionProvider {
	@Override
	public Connection establishConnection() {
		return DbConnection.getConnection();
	}
	@Transaction
	@Override
	public Set<Product> listProductByMarketAndStack(String sqlMarket, String sqlStack) {
		Set<Product> listProduct = new LinkedHashSet<>();
		try (Connection conn = establishConnection()){
			PreparedStatement psMarket = conn.prepareStatement(sqlMarket);
			PreparedStatement psStack = conn.prepareStatement(sqlStack);
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
}
