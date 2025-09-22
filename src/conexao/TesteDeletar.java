package conexao;

import java.util.Scanner;

import entity.Funcionario;
import persistence.FuncionarioDao;

public class TesteDeletar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o id do funcionário a ser deletado: ");
		int id = sc.nextInt();

		FuncionarioDao dao = new FuncionarioDao();
		Funcionario funcionario = new Funcionario(null, null, null, id);
		funcionario.setId(id);

		try {
			dao.delete(funcionario);
			System.out.println("Funcionario deletado com Sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao deletar o funcionário" + e.getMessage());
		}

		sc.close();

	}

}
