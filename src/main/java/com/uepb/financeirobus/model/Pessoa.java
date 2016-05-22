package com.uepb.financeirobus.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Inheritance(strategy  = InheritanceType.JOINED)
@Table(name = "pessoas")
public abstract class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	@Size(min = 3, max = 64)
	@Column(length = 64 ,nullable = false)
	private String nome;
	
	@CPF
	@Column(length = 14, nullable = false)
	private String cpf;
	
	@NotEmpty
	@Size(min = 8)
	@Column(length = 14)
	private String telefone;
	
	@Email
	@Column(length = 32)
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;
	
	public Pessoa() {
		this.dataCadastro = new Date();
	}	

	public Pessoa(String nome, String cpf, String telefone, String email, Date dataCadastro) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.dataCadastro = dataCadastro;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
			if (obj == null)
			return false;
			if (getClass() != obj.getClass())
				return false;
			final Pessoa other = (Pessoa) obj;
			if (id == null) {
			if (other.id != null)
			return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
	}
}
