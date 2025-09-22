package conexao;

import java.time.LocalDate;
import java.util.Scanner;

import Enum.Parentesco;
import entity.Dependente;
import persistence.DependenteDAO;

public class TesteDeletarDependente {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o id do dependente a ser deletado:");
		int id = sc.nextInt();
		
		DependenteDAO dao = new DependenteDAO();
		Dependente dependente = new Dependente("nome","cpf",LocalDate.of(2010, 05, 12),Parentesco.OUTROS);
		dependente.setId(2);
		
		try {
			dao.apagar(dependente);
			System.out.println("Dependente apagado com Sucesso!");
		}catch(Exception e) {
			System.out.println("Erro ao apagar dependente");
			e.getStackTrace();
		}

	}

}
