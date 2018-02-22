package edu.bancofatec.entidades;

import java.util.Date;

public class Conta {

	private Long id;
	private String tipo,numero,nomeGerente;
	private float saldo,limite,taxaServico,taxaJuros,taxaRendimento,diaRendimento;
	private Date dataAbertura;
	
	
	public Conta(){}
	
	public Conta(Long id, String tipo, String numero, String nomeGerente,
			float saldo, float limite, float taxaServico, float taxaJuros,
			float taxaRendimento, float diaRendimento, Date dataAbertura) {
		
		this.id = id;
		this.tipo = tipo;
		this.numero = numero;
		this.nomeGerente = nomeGerente;
		this.saldo = saldo;
		this.limite = limite;
		this.taxaServico = taxaServico;
		this.taxaJuros = taxaJuros;
		this.taxaRendimento = taxaRendimento;
		this.diaRendimento = diaRendimento;
		this.dataAbertura = dataAbertura;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getNomeGerente() {
		return nomeGerente;
	}


	public void setNomeGerente(String nomeGerente) {
		this.nomeGerente = nomeGerente;
	}


	public float getSaldo() {
		return saldo;
	}


	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}


	public float getLimite() {
		return limite;
	}


	public void setLimite(float limite) {
		this.limite = limite;
	}


	public float getTaxaServico() {
		return taxaServico;
	}


	public void setTaxaServico(float taxaServico) {
		this.taxaServico = taxaServico;
	}


	public float getTaxaJuros() {
		return taxaJuros;
	}


	public void setTaxaJuros(float taxaJuros) {
		this.taxaJuros = taxaJuros;
	}


	public float getTaxaRendimento() {
		return taxaRendimento;
	}


	public void setTaxaRendimento(float taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}


	public float getDiaRendimento() {
		return diaRendimento;
	}


	public void setDiaRendimento(float diaRendimento) {
		this.diaRendimento = diaRendimento;
	}


	public Date getDataAbertura() {
		return dataAbertura;
	}


	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	
	
	
}
