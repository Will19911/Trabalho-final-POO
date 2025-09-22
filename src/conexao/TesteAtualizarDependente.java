package conexao;

import java.time.LocalDate;

import Enum.Parentesco;
import entity.Dependente;
import persistence.DependenteDAO;

public class TesteAtualizarDependente {

	public static void main(String[] args) {
		Dependente dependente = new Dependente("Tiago", "11122233344", LocalDate.of(2012, 10, 10), Parentesco.OUTROS);
		dependente.setId(1);
		DependenteDAO dao = new DependenteDAO();
		dao.atualizar(dependente);
		System.out.println("Dependente atualizado com sucesso!");

	}

}
