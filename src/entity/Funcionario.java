package entity;

public class Funcionario {
	private int id;
	private String nome;
	private String cpf;
	private Double salario_bruto;
	
	public Funcionario(int id, String nome, String cpf, Double salario_bruto) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.salario_bruto = salario_bruto;
	}

	@Override
	public String toString() {
		return "Funcionario: " + id + ", nome: " + nome + ", cpf: " + cpf + ", salario_bruto: " + salario_bruto ;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalario_bruto() {
		return salario_bruto;
	}

	public void setSalario_bruto(Double salario_bruto) {
		this.salario_bruto = salario_bruto;
	}
	
	
	
	
	

}
