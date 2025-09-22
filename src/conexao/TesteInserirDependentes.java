package conexao;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

import Enum.Parentesco;

import entity.Dependente;
import persistence.DependenteDAO;

public class TesteInserirDependentes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o nome:");
		String nome = sc.nextLine();

		System.out.println("Digite o cpf:");
		String cpf = sc.nextLine();

		LocalDate dataNascimento = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		while (dataNascimento == null) {

			System.out.println("Digite a Data de nascimento: dd/MM/yyyy: ");
			String data = sc.nextLine();

			try {
				dataNascimento = LocalDate.parse(data, formatter);

			} catch (DateTimeException e) {
				System.out.println("Data de nascimento com erro! digite no formato: dd/MM/yyyy");
			}

		}
		Parentesco parentesco = null;
		while (parentesco == null) {
			System.out.println("Qual seu parentesco?" + Arrays.toString(Parentesco.values()));
			String parentescoStr = sc.nextLine().trim();

			try {
				parentesco = Parentesco.valueOf(parentescoStr.toUpperCase());
			} catch (IllegalArgumentException e) {
				System.out.println("Parentesco Inválido!");
			}

		}

		Dependente dependente = new Dependente(nome, cpf, dataNascimento, parentesco);

		DependenteDAO dao = new DependenteDAO();
		dao.inserir(dependente);
		System.out.println("Dependente inserido com sucesso!");
		sc.close();

	}

}
