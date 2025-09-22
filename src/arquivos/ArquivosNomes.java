package arquivos;

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

import Enum.Parentesco;
import calcularsalario.DependenteException;
import entity.Dependente;
import entity.Funcionario;

public class ArquivosNomes {

	public static void main(String[] args) {

		try {
			File file = new File("C:\\Users\\Will\\Documents\\Serratec\\funcionarios.csv");
			Scanner sc = new Scanner(file);

			Set<Funcionario> funcionarios = new HashSet<>();
			Set<Dependente> dependentes = new HashSet<>();
			
			Funcionario funcionarioAtual = null; //Mantém o último funcionário lido

			while (sc.hasNextLine()) {
				String linha = sc.nextLine();

				if (linha.isEmpty())
					continue; 

				String[] dados = linha.split(";");

				
				if (dados.length == 4) {
					try {
						//  le como funcionário
						String nome = dados[0];
						String cpf = dados[1];
						DateTimeFormatter formatterFunc = DateTimeFormatter.ofPattern("yyyyMMdd");
						LocalDate dataNascimento = LocalDate.parse(dados[2], formatterFunc);
						double salarioBruto = Double.parseDouble(dados[3]);
                        
						funcionarioAtual = new Funcionario(nome, cpf, dataNascimento, salarioBruto);
						funcionarios.add(funcionarioAtual);
						
						

					} catch (NumberFormatException e) {
						// Se não for possível converter salário, trata como dependente
						if(linha.isEmpty()) {
							break;
						}
						
						String nomedep = dados[0];
						String cpfdep = dados[1];
						DateTimeFormatter formatterDep = DateTimeFormatter.ofPattern("yyyyMMdd");
						LocalDate dataNascDep = LocalDate.parse(dados[2], formatterDep);
						Parentesco parentesco = Parentesco.valueOf(dados[3].toUpperCase());

						Dependente dependente = new Dependente(nomedep, cpfdep, dataNascDep, parentesco);
						dependentes.add(dependente);

						if (funcionarioAtual != null) {
							funcionarioAtual.adicionarDependente(dependente);
						}
					}
				}
			}
			sc.close();

			
			System.out.println("===== Leitura de arquivo =====\n");
			for (Funcionario f : funcionarios) {
				System.out.println(f);
			}

			System.out.println("\n==== Gravação de arquivo ====");
			FileWriter caminho = new FileWriter("C:\\Users\\Will\\Documents\\Serratec\\funcionarios_saida.csv");
			PrintWriter gravar = new PrintWriter(caminho);

			
			for (Funcionario f : funcionarios) {
				String linhaArquivo = f.getNome() + ";" + f.getCpf() + ";" + f.getDataNascimento() + ";"
						+ String.format("%.2f", f.calcularINSS()) + ";" + String.format("%.2f", f.calcularIR()) + ";"
						+ String.format("%.2f", f.calcularSalarioLiquido()) + "\n";

				gravar.printf(linhaArquivo);
			}

			//Não imprimir os nomes dos dependentes na saida!
//			for (Dependente d : dependentes) {
//				String linhaArquivoDep = d.getNome() + ";" + d.getCpf() + ";" + d.getDataNascimento() + ";"
//						+ d.getParentesco() + "\n";
//
//				gravar.printf(linhaArquivoDep);
//			}

			gravar.close();
			System.out.println("\nGravação de arquivo feita com sucesso!");

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
			e.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Arquivo de saída com problema");
			e1.printStackTrace();
		} catch (DependenteException e1) {
			System.out.println("Erro no dependente");
			e1.printStackTrace();
		}
	}
}
