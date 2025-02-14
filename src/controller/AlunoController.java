package controller;

import java.util.List;

import dao.AlunoDAO;
import dao.AlunoDAOImpl;
import model.Aluno;

public class AlunoController {

    private AlunoDAO alunoDAO;

    public AlunoController() {
        this.alunoDAO = new AlunoDAOImpl();
    }

    public void cadastrarAluno(Aluno aluno) {
        alunoDAO.salvar(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public void atualizarAluno(Aluno aluno) {
        alunoDAO.atualizar(aluno);
        System.out.println("Aluno atualizado com sucesso!");
    }

    public void removerAluno(int matricula) {
        alunoDAO.remover(matricula);
        System.out.println("Aluno removido com sucesso!");
    }

    public Aluno buscarAlunoPorMatricula(int matricula) {
        return alunoDAO.buscarPorMatricula(matricula);
    }

    public List<Aluno> listarAlunos() {
        return alunoDAO.listarTodos();
    }
}