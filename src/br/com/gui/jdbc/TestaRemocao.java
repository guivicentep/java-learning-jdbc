package br.com.gui.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("delete from PRODUTO where id > ?");
		stm.setInt(1, 2);
		stm.execute();
		
		Integer modificatedlines = stm.getUpdateCount();
		
		System.out.println("Quantidade de linhas modificadas: " + modificatedlines);
		stm.close();
		connection.close();

	}

}
