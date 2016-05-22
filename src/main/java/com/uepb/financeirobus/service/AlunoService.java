package com.uepb.financeirobus.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.uepb.financeirobus.model.Aluno;
import com.uepb.financeirobus.repository.AlunoRepository;
import com.uepb.financeirobus.util.Transactional;

public class AlunoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlunoRepository repository;

	@Transactional
	public void salvar(Aluno aluno) {
		this.repository.guardar(aluno);
	}
	
	@Transactional
	public void excluir(Aluno aluno) {
		this.repository.remover(aluno);
	}
	
	
}
