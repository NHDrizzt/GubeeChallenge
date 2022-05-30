package testinho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import testinho.annotation.Transaction;
import testinho.db.DbConnection;
import testinho.db.DbException;
import testinho.model.Produto;

public class ProdutoRepositoryJdbc implements ProdutoRepository, ConnectionProvider {

	private static List<Produto> listResult = new ArrayList<>();
	private static Set<Produto> setProd = new LinkedHashSet<>();
	
	@Override
	public Connection establishConnection() {
		Connection conn = DbConnection.getConnection();
		return conn;
	}

	@Transaction
	@Override
	public List<Produto> getMarketAndStack(String sqlMarket, String sqlStack) {
				
		try {
			Connection conn = establishConnection();
			PreparedStatement psMarket = conn.prepareStatement(sqlMarket);
			PreparedStatement psStack = conn.prepareStatement(sqlStack);
			
			setProd = getResulSet(psMarket);
			setProd = getResulSet(psStack);
			listResult.addAll(setProd);
			
		}
		
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		finally {
			DbConnection.closeConnection();
		}
		return listResult;
	}

	private Set<Produto> getResulSet(PreparedStatement psStatement) {
		try {
			ResultSet rsMarket = psStatement.executeQuery();
			while(rsMarket.next()) {
				Produto	p = new Produto();
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
