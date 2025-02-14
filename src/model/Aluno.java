package model;

import java.util.List;

public class Aluno extends Pessoa{
	private int matricula;
	private String objetivo;
	private String observacao;
	private Treinador treinador; //	N:1 Aluno - Treinador
	private List<Pagamento> pagamentos; //	Relação de Composição  1:N Aluno - Pagamento 
    private boolean ativo; //falso caso aluno tiver com debitos;
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Treinador getTreinador() {
		return treinador;
	}
	public void setTreinador(Treinador treinador) {
		this.treinador = treinador;
	}
	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}
	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
    public void adicionarPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
    }
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}