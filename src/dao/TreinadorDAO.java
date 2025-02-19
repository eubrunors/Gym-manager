package dao;

import java.util.List;

import model.Treinador;

public interface TreinadorDAO {
	
	void salvar(Treinador treinador);
	
	void atualizar(Treinador treinador);
	
	void remover(int idTreinador);
	
	Treinador buscarPorIdTreinador(int idTreinador);
	
	List<Treinador> listarTodos();
}
