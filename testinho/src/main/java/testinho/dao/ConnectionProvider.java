package testinho.dao;

import java.sql.Connection;

public interface ConnectionProvider {
	public Connection establishConnection();
}
