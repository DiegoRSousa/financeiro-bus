package com.uepb.financeirobus.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.uepb.financeirobus.model.Aluno;
import com.uepb.financeirobus.repository.AlunoRepository;
import com.uepb.financeirobus.repository.FiltroAluno;
import com.uepb.financeirobus.service.AlunoService;



@Named
@javax.faces.view.ViewScoped
public class AlunoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	AlunoService service;
	
	@Inject
	AlunoRepository repository;
	
	private List<Aluno> alunos;
	private Aluno aluno = new Aluno();
	
	private Aluno alunoSelecionado; 
	private FiltroAluno filtro = new FiltroAluno();
	private List<Aluno> alunosFiltrados;
	
	public void prepararCadastro() {
		this.aluno = new Aluno();
	}
	
	public void todos() {
		System.out.println("todos");
		this.alunos = repository.todos();
	}
	
	public void salvar() {
		System.out.println("salvar");
		FacesContext context = FacesContext.getCurrentInstance();
		this.service.salvar(aluno);
		todos();
		context.addMessage(null, new FacesMessage("Aluno " 
				+ "salvo com sucesso!"));
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:alunos-table"));
	}
	
	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		this.service.excluir(alunoSelecionado);
		alunoSelecionado = null;
		todos();
		
		context.addMessage(null, new FacesMessage("Aluno " 
				+ "excluído com sucesso!"));
	}
	
	public void filtrar(){
		System.out.println("x");
		this.alunosFiltrados = repository.filtrar(filtro);
		System.out.println(alunosFiltrados);
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}

	public FiltroAluno getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroAluno filtro) {
		this.filtro = filtro;
	}

	public List<Aluno> getAlunosFiltrados() {
		return alunosFiltrados;
	}
	
	public void x() {
		System.out.println(filtro.getNome());
	}
}

