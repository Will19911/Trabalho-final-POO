package calcularsalario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Funcionario extends Pessoa implements SalarioCalculavel {
	private double salarioBruto;
	private double descontoInss;
	private double descontoIr;
	private Set<Dependente> dependentes = new HashSet<>();
	public int getId;

	public Funcionario(int id, String nome, String cpf, LocalDate dataNascimento, double salarioBruto, double descontoInss,
			double descontoIr) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.descontoInss = descontoInss;
		this.descontoIr = descontoIr;
	}

	

	@Override
	public String toString() {
		return "salarioBruto: " + salarioBruto + ", descontoInss: " + descontoInss + ", descontoIr: " + descontoIr;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public double getDescontoInss() {
		return descontoInss;
	}

	public void setDescontoInss(double descontoInss) {
		this.descontoInss = descontoInss;
	}

	public double getDescontoIr() {
		return descontoIr;
	}

	public void setDescontoIr(double descontoIr) {
		this.descontoIr = descontoIr;
	}

	@Override
	public double calcularINSS() {
		// TODO Auto-generated method stub
		return descontoInss;
	}

	@Override
	public double calcularIR() {
		// TODO Auto-generated method stub
		return descontoIr;
	}

	@Override
	public double calcularSalarioLiquido() {
		this.descontoInss = calcularINSS();
		this.descontoIr = calcularIR();

		return salarioBruto - descontoInss - descontoIr;
	}

	public void AdicionarDependente(Dependente dependente) throws DependenteException {
		dependentes.add(dependente);
		throw new DependenteException("Não é permitido cpf duplicado");
	}
}
