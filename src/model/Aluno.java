package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa{
	private int matricula;
	private String objetivo;
	private String observacao;
	private Treinador treinador; //	N:1 Aluno - Treinador
	private List<Pagamento> pagamentos; //	Relação de Composição  1:N Aluno - Pagamento 
    private boolean ativo; //falso caso aluno tiver com debitos;
	
    public Aluno(int matricula, String objetivo, String observacao, Treinador treinador, List<Pagamento> pagamentos,
			boolean ativo) {
		super();
		this.matricula = matricula;
		this.objetivo = objetivo;
		this.observacao = observacao;
		this.treinador = treinador;
		this.pagamentos = pagamentos;
		this.ativo = ativo;
	}

	public Aluno(int matricula, String objetivo, List<Pagamento> pagamentos, boolean ativo) {
		super();
		this.matricula = matricula;
		this.objetivo = objetivo;
		this.pagamentos = pagamentos;
		this.ativo = ativo;
	}
	
	public Aluno() {
		this.pagamentos = new ArrayList<Pagamento>();
		this.ativo = true;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public String getObservacao() {
		return observacao;
	}

	public Treinador getTreinador() {
		return treinador;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setTreinador(Treinador treinador) {
		this.treinador = treinador;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
    
}