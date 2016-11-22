package br.com.gpmodontosystem.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao implements IDao {
	
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
	@Override
	public void opne() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql//localhost:3306/BDGPMODONTOSYSTEM", "root", "");
	}
	
	@Override
	public void close() throws Exception{
		con.close();
	}

}
