package persistence;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexao.ConnectionFactory;
import entity.Funcionario;

public class FuncionarioDao {
	private Connection connection;
	private java.sql.Date dataNascimento;

	public FuncionarioDao() {
		connection = new ConnectionFactory().getConnection();
	}

	public void inserir(Funcionario funcionario) {
		String sql = "insert into funcionario(id, cpf, data_nascimento, salario_bruto) values(?, ?, ?, ?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, funcionario.getId());
			stmt.setString(2, funcionario.getCpf());
			funcionario.getDataNascimento();
			stmt.setDate(3, java.sql.Date.valueOf(funcionario.getDataNascimento()));
			stmt.setDouble(4, funcionario.getSalarioBruto());

			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				funcionario.setId(rs.getInt("id"));
			}
			connection.close();
			System.out.println("Funcionario adicionado com Sucesso!");
		} catch (SQLException e) {
			System.out.println("Problemas ao Inserir Registro");
		}
	}

	public void atualizar(Funcionario funcionario) {
		String sql = "update funcionario set nome=?, cpf=?, data_nascimento=?, salario_bruto=? where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getCpf());
			stmt.setDate(3, java.sql.Date.valueOf(funcionario.getDataNascimento()));
			stmt.setDouble(4, funcionario.getSalarioBruto());
            stmt.setInt(5, funcionario.getId());
			stmt.execute();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("Problemas ao Atualizar Registro");
			e.printStackTrace();
		}

	}

	public void delete(Funcionario funcionario) {
		String sql = "delete from funcionario where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, funcionario.getId());

			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Problemas ao apagar o registro");
			e.printStackTrace();
		}
	}

	public List<Funcionario> listar() {
		String sql = "select * from funcionario";
		List<Funcionario> funcionarios = new ArrayList<>();

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			// SalarioCalculavel calculoINSS = new CalculoINSS();
			// CalculaFolha calculoIR = new CalculoIR();

			while (rs.next()) {
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				setDataNascimento(rs.getDate("data_nascimento"));
				double salarioBruto = rs.getDouble("salario_bruto");

				// Funcionario funcionario = new Funcionario(0, "Marco", "22223445", null,
				// salario_bruto, 0, 0);

				funcionarios.add(new Funcionario(rs.getString("nome"), rs.getString("cpf"),
						  rs.getDate("data_nascimento").toLocalDate(), rs.getDouble("salario_bruto")));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Problemas ai listar os registros");
			e.printStackTrace();
		}
		return funcionarios;

	}

	public java.sql.Date getDataNascimento() {
		return dataNascimento;
	}

	public java.sql.Date setDataNascimento(java.sql.Date dataNascimento) {
		this.dataNascimento = dataNascimento;
		return dataNascimento;
	}

	

}
