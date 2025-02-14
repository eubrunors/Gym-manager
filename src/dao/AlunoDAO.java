package dao;

import java.util.List;

import model.Aluno;

public interface AlunoDAO {
	
	void salvar(Aluno aluno);
	
	void atualizar(Aluno aluno);
	
	void remover(int matricula);
	
	Aluno buscarPorMatricula(int matricula);
	
	List<Aluno> listarTodos();
	
}
