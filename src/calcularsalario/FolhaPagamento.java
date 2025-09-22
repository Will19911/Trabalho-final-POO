package calcularsalario;

import java.time.LocalDate;

import entity.Funcionario;

public class FolhaPagamento {
	private Funcionario funcionario;
	private LocalDate dataPagamento;
    private Double salarioBruto;
	private Double descontoINSS;
	private Double descontoIR;
	private Double salarioLiquido;
	

	public FolhaPagamento(Funcionario funcionario, LocalDate dataPagamento) {
		super();

		this.funcionario = funcionario;
		this.dataPagamento = dataPagamento;
		this.descontoINSS = funcionario.calcularINSS();
		this.descontoIR = funcionario.calcularIR();
		this.salarioLiquido = funcionario.calcularSalarioLiquido();
		this.salarioBruto = funcionario.getSalarioBruto();
	}

	@Override
	public String toString() {
		return " funcionario: " + funcionario + ", dataPagamento: " + dataPagamento + ", descontoINSS: " + descontoINSS
				+ ", descontoIR: " + descontoIR + ", salarioBruto" + ", salarioLiquido: " + salarioLiquido;
	}

	public Double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(Double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getDescontoINSS() {
		return descontoINSS;
	}

	public void setDescontoINSS(Double descontoINSS) {
		this.descontoINSS = descontoINSS;
	}

	public Double getDescontoIR() {
		return descontoIR;
	}

	public void setDescontoIR(Double descontoIR) {
		this.descontoIR = descontoIR;
	}

	public Double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(Double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

}
