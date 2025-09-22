package persistence;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import calcularsalario.FolhaPagamento;
import conexao.ConnectionFactory;

public class FolhaPagamentoDao {
	private Connection connection;
	public boolean inserir = false;

	public FolhaPagamentoDao() {
		connection = new ConnectionFactory().getConnection();
	}

	public void inserir(FolhaPagamento fp) {
		String sql = "insert into folha_pagamento(id_funcionario, salario_bruto, data_pagamento,desconto_inss,desconto_ir,salario_liquido) values (?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, fp.getFuncionario().getId());
			stmt.setDouble(2, fp.getSalarioBruto());
			stmt.setDate(3, java.sql.Date.valueOf(fp.getDataPagamento()));
			stmt.setDouble(4, fp.getDescontoINSS());
			stmt.setDouble(5, fp.getDescontoIR());
			stmt.setDouble(6, fp.getSalarioLiquido());

			stmt.executeUpdate();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("Problemas ao gravar registro");
			e.printStackTrace();
			
		}
	}

}