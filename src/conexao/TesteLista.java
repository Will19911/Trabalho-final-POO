package conexao;

import persistence.FuncionarioDao;

public class TesteLista {

	public static void main(String[] args) {
		FuncionarioDao dao = new FuncionarioDao();
		
		System.out.println(dao.listar());
		
		

	}

}
