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

	@Override
	public Connection establishConnection() {
		Connection conn = DbConnection.getConnection();
		return conn;
	}

	@Transaction
	@Override
	public List<Produto> databaseImplementationJdbc(String sqlMarket, String sqlStack) {
	
		List<Produto> listResult = new ArrayList<>();
		Set<Produto> setProd = new LinkedHashSet<>();
				
		try {
			Connection conn = establishConnection();

			PreparedStatement psMarket = conn.prepareStatement(sqlMarket);
			PreparedStatement psStack = conn.prepareStatement(sqlStack);
			
			ResultSet rsMarket = psMarket.executeQuery();
			ResultSet rsStack = psStack.executeQuery();
			
			while(rsMarket.next()) {
				Produto p = new Produto();
				p.setId(rsMarket.getInt(1));
				p.setName(rsMarket.getString(2));
				p.setDescription(rsMarket.getString(3));
				setProd.add(p);
				
			}
			while(rsStack.next()) {
				Produto p = new Produto();
				p.setId(rsStack.getInt(1));
				p.setName(rsStack.getString(2));
				p.setDescription(rsStack.getString(3));
				setProd.add(p);
			}
			
			listResult.addAll(setProd);
		}
		
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		finally {
		}
		
		return listResult;
	}

	@Override
	public void endData() {
		// TODO Auto-generated method stub
		
	}
}
