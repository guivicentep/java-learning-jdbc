package br.com.gui.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.gui.jdbc.dao.ProdutoDAO;
import br.com.gui.jdbc.modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("C?moda", "C?moda Vertical");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(comoda);
			List<Produto> listaDeProdutos = produtoDAO.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}

	}

}
