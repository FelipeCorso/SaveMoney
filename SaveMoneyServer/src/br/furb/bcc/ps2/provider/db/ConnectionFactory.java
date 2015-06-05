package br.furb.bcc.ps2.provider.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    static {
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	} catch (Exception e) {
	    System.out.println("ERRO");
	    e.printStackTrace();
	}
    }

    public static Connection getConnection() {
	try {
	    return DriverManager.getConnection("jdbc:mysql://localhost:3306/fj21", "root", "root");
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }
}