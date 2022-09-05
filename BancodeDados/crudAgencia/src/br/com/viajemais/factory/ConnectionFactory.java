package br.com.viajemais.factory;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
	// nome do usário do mysql
	private static final String USERNAME = "root";
	// senha do banco
	private static final String PASSWORD = "123456789";
	
	// caminho do banco de dados, porta e o nome do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/viajemais";
	
	/*
	 * Conexão com o banco de dados
	 */
	
	public static Connection creatConnectiontoMySQL() throws Exception {
		// faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Cria a conexão com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}
 
	public static void main (String[] args) throws Exception {
		// Recuperar uma conexao com o banco de dados
		Connection con = creatConnectiontoMySQL();
		
		// testar se a conexão é nula 
		if( con != null) {
			System.out.println("Conexão realizada com sucesso!");
			con.close();
		}
		
	}
		
}
