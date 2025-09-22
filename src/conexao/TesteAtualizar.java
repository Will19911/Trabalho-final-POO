package conexao;

import java.time.LocalDate;

import entity.Funcionario;

import persistence.FuncionarioDao;

public class TesteAtualizar {

	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario("Caroline", "22222233344", LocalDate.of(1993,10, 21), 6000);
		funcionario.setId(2);
		FuncionarioDao dao = new FuncionarioDao();
		dao.atualizar(funcionario);
		System.out.println("Cliente atualizado com sucesso!");

	}

}
