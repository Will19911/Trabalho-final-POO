package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import Enum.Parentesco;
import calcularsalario.DependenteException;
import conexao.ConnectionFactory;
import entity.Dependente;

public class DependenteDAO {
	private static final Parentesco Parentesco = null;
	private Connection connection;

	public DependenteDAO() {
		connection = new ConnectionFactory().getConnection();
	}

	public void inserir(Dependente dependente) {
		String sql = "insert into dependente(nome,cpf_funcionario,data_nascimento,parentesco) values (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, dependente.getNome());
			stmt.setString(2, dependente.getCpf());
			stmt.setDate(3, java.sql.Date.valueOf(dependente.getDataNascimento()));
			stmt.setString(4, dependente.getParentesco().name());

			int linhasAfetadas = stmt.executeUpdate();

			if (linhasAfetadas > 0) {
				System.out.println("Dependente inserido com sucesso!");
			} else {
				System.out.println("Erro ao inserir dependente");
			}

			connection.close();
		} catch (SQLException e) {
			System.out.println("Problemas ao gravar registro" + e.getMessage());
			e.printStackTrace();

		} finally {
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void atualizar(Dependente dependente) {
		String sql = "update dependente set nome=?, cpf_funcionario=?, data_nascimento=?, parentesco=? where id =?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, dependente.getNome());
			stmt.setString(2, dependente.getCpf());
			stmt.setDate(3, java.sql.Date.valueOf(dependente.getDataNascimento()));
			stmt.setString(4, dependente.getParentesco().name());
			stmt.setInt(5, dependente.getId());

			int linhasAfetadas = stmt.executeUpdate();

			if (linhasAfetadas > 0) {
				System.out.println("Dependente atualixado com Sucesso!");
			} else {
				System.out.println("Erro ao atualizar o dependente!");
			}

			connection.close();

		} catch (SQLException e) {
			System.out.println("Problemas ao gravar registro" + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (connection != null && connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void apagar(Dependente dependente) {
		String sql = "delete from dependente where id =?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, dependente.getId());

			stmt.execute();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("Problemas ao apagar registro");
		}
	}

	public List<Dependente> listar() {
		String sql = "select * from dependente";
		List<Dependente> dependentes = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf_funcionario");
				setDataNascimento(rs.getDate("data_nascimento"));
				String parentesco = rs.getString("parentesco");

				dependentes.add(new Dependente(rs.getString("nome"), rs.getString("cpf_funcionario"),
						rs.getDate("data_nascimento").toLocalDate(), Parentesco));

			}

			stmt.close();
			connection.close(); 

		} catch (SQLException e) {
			System.out.println("Problemas ao listar registros!");
		}
		return dependentes;
	}

	private void setDataNascimento(Date date) {
		// TODO Auto-generated method stub

	}

}
