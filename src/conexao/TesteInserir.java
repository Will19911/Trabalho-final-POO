package conexao;

import java.time.LocalDate;
import java.util.Scanner;
import entity.Funcionario;
//import entity.Funcionario;
import persistence.FuncionarioDao;

public class TesteInserir {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		System.out.println("Digite o nome:");
		String nome = sc.next();

		System.out.println("Digite o cpf:");
		String cpf = sc.next();

		System.out.println("Digite o salario Bruto :");
		
		Double salario_bruto = sc.nextDouble();

		
		
		
		Funcionario funcionario = new Funcionario(0, nome, cpf, salario_bruto);

		FuncionarioDao dao = new FuncionarioDao();
		dao.inserir(funcionario);
		sc.close();
		

	}

}
