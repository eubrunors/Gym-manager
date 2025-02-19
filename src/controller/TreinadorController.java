package controller;

import java.util.List;

import dao.TreinadorDAO;
import dao.TreinadorDAOImpl;
import model.Treinador;

public class TreinadorController {
	
	private TreinadorDAO treinadorDAO;
	
	public TreinadorController() {
		this.treinadorDAO = new TreinadorDAOImpl();
	}
	
	public void cadastrarTreinador(Treinador treinador) {
		treinadorDAO.salvar(treinador);
		System.out.println("Treinador cadastrado com sucesso!");
	}
	
	public void atualizarTreinador(Treinador treinador) {
		treinadorDAO.atualizar(treinador);
		System.out.println("Treinador atualizado com sucesso!");
	}

	public void removerTreinador(int idTreinador) {
		treinadorDAO.remover(idTreinador);
		System.out.println("Treinador removido com sucesso!");
	}
	
	public Treinador buscarTreinadorPorIdTreinador(int idTreinador) {
		return treinadorDAO.buscarPorIdTreinador(idTreinador);
	}
	
	public List<Treinador> listarTreinadores(){
		return treinadorDAO.listarTodos();
	}
}
