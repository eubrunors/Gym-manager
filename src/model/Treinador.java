package model;

import java.util.List;

public class Treinador extends Pessoa {
	
	private int idTreinador;
	private double salario; 
    private List<Aluno> alunos; // Agregação (1 Treinador -> vários Alunos)
    
	public int getIdTreinador() {
		return idTreinador;
	}
	public void setIdTreinador(int idTreinador) {
		this.idTreinador = idTreinador;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }
}
