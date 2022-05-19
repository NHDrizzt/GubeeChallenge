package testinho.dao;

import java.sql.Connection;

public interface IConnectionProvider {
	
	public Connection establishConnection();
}
