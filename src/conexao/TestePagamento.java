package conexao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import calcularsalario.FolhaPagamento;
import entity.Funcionario;
import persistence.FolhaPagamentoDao;

public class TestePagamento {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
            
            System.out.print("Digite o nome do funcionário: ");
            String nome = sc.nextLine();

            System.out.print("Digite o CPF: ");
            String cpf = sc.nextLine();

            System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
            String data = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNascimento = LocalDate.parse(data, formatter);

            System.out.print("Digite o salário bruto: ");
            double salarioBruto = sc.nextDouble();

            
            Funcionario funcionario = new Funcionario(nome, cpf, dataNascimento, salarioBruto);
            funcionario.setId(10);
            

            System.out.println("Digite a data do pagamento (dd/MM/yyyy");
            String dataPag = sc.next();
            LocalDate dataPagamento = LocalDate.parse(dataPag, formatter);
            
            FolhaPagamento folha = new FolhaPagamento(funcionario, dataPagamento);

           
            FolhaPagamentoDao dao = new FolhaPagamentoDao();
            dao.inserir(folha);

            if(dao.inserir == true) {
            System.out.println("Folha de pagamento gerada com sucesso para: " + funcionario.getNome());

            }
        } catch (Exception e) {
            System.out.println("Erro ao gerar folha de pagamento: " + e.getMessage());
        }

        sc.close();
    }
}


