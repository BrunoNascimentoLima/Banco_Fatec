package edu.bancofatec.entidades;

import java.util.Date;

public class Lancamento {

 private Long id,idConta;
 private String tipo,descricao;
 private float saldoAnterior,saldoPosterior,valor;
 private Date dataLancamento;

 public Lancamento(){}
 
 
 public Lancamento(Long id, Long idConta, String tipo, String descricao,
		float saldoAnterior, float saldoPosterior, float valor,
		Date dataLancamento) {
	this.id = id;
	this.idConta = idConta;
	this.tipo = tipo;
	this.descricao = descricao;
	this.saldoAnterior = saldoAnterior;
	this.saldoPosterior = saldoPosterior;
	this.valor = valor;
	this.dataLancamento = dataLancamento;
}




public Long getId() {
	return id;
}




public void setId(Long id) {
	this.id = id;
}




public Long getIdConta() {
	return idConta;
}




public void setIdConta(Long idConta) {
	this.idConta = idConta;
}




public String getTipo() {
	return tipo;
}




public void setTipo(String tipo) {
	this.tipo = tipo;
}




public String getDescricao() {
	return descricao;
}




public void setDescricao(String descricao) {
	this.descricao = descricao;
}




public float getSaldoAnterior() {
	return saldoAnterior;
}




public void setSaldoAnterior(float saldoAnterior) {
	this.saldoAnterior = saldoAnterior;
}




public float getSaldoPosterior() {
	return saldoPosterior;
}




public void setSaldoPosterior(float saldoPosterior) {
	this.saldoPosterior = saldoPosterior;
}




public float getValor() {
	return valor;
}




public void setValor(float valor) {
	this.valor = valor;
}




public Date getDataLancamento() {
	return dataLancamento;
}




public void setDataLancamento(Date dataLancamento) {
	this.dataLancamento = dataLancamento;
}
 
 
 

}
