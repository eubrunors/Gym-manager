package model;

import java.time.LocalDate;

public class Pagamento {
    private int idOperacao;
    private double valor;
    private LocalDate dataPaga;
    private LocalDate dataVencimento;
    private String tipoPlano;
    private int alunoId;
    
	public Pagamento(int idOperacao, double valor, LocalDate dataPaga, LocalDate dataVencimento, String tipoPlano) {
		this.idOperacao = idOperacao;
		this.valor = valor;
		this.dataPaga = dataPaga;
		this.dataVencimento = dataVencimento;
		this.tipoPlano = tipoPlano;
	}
	
	public int getIdOperacao() {
		return idOperacao;
	}
	public void setIdOperacao(int idOperacao) {
		this.idOperacao = idOperacao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDate getDataPaga() {
		return dataPaga;
	}
	public void setDataPaga(LocalDate dataPaga) {
		this.dataPaga = dataPaga;
	}
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public String getTipoPlano() {
		return tipoPlano;
	}
	public void setTipoPlano(String tipoPlano) {
		this.tipoPlano = tipoPlano;
	}
	public int getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}
}