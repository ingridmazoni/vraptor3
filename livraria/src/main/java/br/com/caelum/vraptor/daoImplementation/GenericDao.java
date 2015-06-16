package br.com.caelum.vraptor.daoImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {

private static Connection con;

public static Connection getConnection() { 

	try { 
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/teste","root","123456");
		System.out.println("Conexao ok");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (Exception e) { 
		e.printStackTrace();
	}
	return con; 
}


	public static void fechaConexao(){
			try {
				if(con!=null) con.close();
				con =null;
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
}