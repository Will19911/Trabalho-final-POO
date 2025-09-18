package arquivos;

import java.io.File;
import java.sql.Connection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import calcularsalario.Dependente;
import calcularsalario.Funcionario;

public class ArquivosNomes {

	public static void main(String[] args) {

		try {
			Scanner entrada = new Scanner(System.in);
			System.out.println("Digite o caminho do arquivo de entrada: ");
			Scanner entradaConsole = new Scanner(System.in);
			String nomeArquivo = entradaConsole.nextLine();

			File file = new File(nomeArquivo);
			Scanner sc = new Scanner(file);

			Set<Funcionario> funcionarios = new HashSet<>();
			Set<Dependente> dependentes = new HashSet<>();

			while (sc.hasNext()) {
				String linha = sc.nextLine();
				if (!linha.isEmpty()) {
					String[] dados = linha.split(";");

					if (dados.length >= 4) {

						String nome = dados[0];
						String cpf = dados[1];
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
						LocalDate dataNascimento = LocalDate.parse(dados[2], formatter);
						// LocalDate dataNascimento = LocalDate.parse(dados[2]);
						double salarioBruto = Double.parseDouble(dados[3]);
						double descontoInss = Double.parseDouble(dados[4]);
						double descontoIr = Double.parseDouble(dados[5]);

						funcionarios.add(
								new Funcionario(0, nome, cpf, dataNascimento, salarioBruto, descontoInss, descontoIr));

					}
					if (linha.isEmpty()) {
						for (Dependente e : dependentes) {
							String linhaArquivo = e.getNome() + " ; " + e.getDataNascimento() + " ; "
									+ e.getParentesco() + "\n";
						}
					}

				}

			}
			sc.close();

			System.out.println("=====Leitura de arquivo=====");
			for (Funcionario e : funcionarios) {
				System.out.println(e);
			}

			System.out.println("====Gravação de arquivo====");
			FileWriter caminho = new FileWriter("C:\\Users\\Will\\Documents\\Serratec\\empregadoFolha.csv");
			PrintWriter gravar = new PrintWriter(caminho);

			for (Funcionario e : funcionarios) {
				String linhaArquivo = e.getNome() + " ; " + e.getCpf() + " ; " + e.getDataNascimento() + " ; "
						+ e.calcularINSS() + " ; " + e.calcularIR() + " ; " + e.calcularSalarioLiquido() + " ; " + "\n";
				gravar.printf(linhaArquivo);
			}

			gravar.close();
			System.out.println("Gravação de arquivo feita com sucesso!");
			entradaConsole.close();

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		}

		catch (IOException e1) {
			System.out.println("Arquivo de saída com problema");

		}

	}

}
