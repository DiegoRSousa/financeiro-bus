package com.uepb.financeirobus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Size(min = 2, max = 32)
	@Column(length = 32, nullable = false)
	private String logradouro;
	
	@NotEmpty
	@Size(max = 6)
	@Column(length = 6, nullable = false)
	private String numero;
	
	@NotEmpty
	@Size(max = 24)
	@Column(length = 24, nullable = false)
	private String bairro;
	
	@Size(max = 9)
	@Column(length = 9)
	private String cep;
	
	@NotEmpty
	@Size(min = 3, max = 48)
	@Column(length = 48, nullable = false)
	private String cidade;
	
	@NotEmpty
	@Size(min = 2, max = 18)
	@Column(length = 18, nullable = false)
	private String estado;
	
	public Endereco() {
		
	}
	
	public Endereco(String logradouro, String numero, String bairro, String cep, String cidade, String estado) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
