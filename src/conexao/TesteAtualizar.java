package conexao;

import calcularsalario.Funcionario;
import persistence.FuncionarioDao;

public class TesteAtualizar {

	public static void main(String[] args) {
		entity.Funcionario funcionario = new entity.Funcionario(2, "Caroline", "22222233344", (double) 5000);
		FuncionarioDao dao = new FuncionarioDao();
		dao.atualizar(funcionario);
		System.out.println("Cliente atualizado com sucesso!");

	}

}
