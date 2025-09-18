package calcularsalario;

import java.time.LocalDate;

public class Dependente extends Pessoa {
	private Parentesco parentesco;

	public Dependente(String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco) {
		super(nome, cpf, dataNascimento);
		this.parentesco = parentesco;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}

	public Dependente(String nome, String cpf, LocalDate dataNascimento) throws DependenteException {
		super(nome, cpf, dataNascimento);
		if (LocalDate.now().minusYears(18).isBefore(dataNascimento)) {

		} else {
			throw new DependenteException("Dependente deve ser menor que 18 anos!");
		}

	}

}
