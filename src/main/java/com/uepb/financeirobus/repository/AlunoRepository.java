package com.uepb.financeirobus.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.uepb.financeirobus.model.Aluno;



public class AlunoRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	@Inject
	public AlunoRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Aluno> todos() {
		TypedQuery<Aluno> query = manager.createQuery(
				"from Aluno", Aluno.class);
		return query.getResultList();
	}
	
	public Aluno porId(Long id) {
		return manager.find(Aluno.class, id);
	}
	
	public void adicionar(Aluno aluno) {
		this.manager.persist(aluno);
	}
	
	public Aluno guardar(Aluno aluno) {
		return this.manager.merge(aluno);
	}
	
	public void remover(Aluno aluno) {
		aluno = porId(aluno.getId());
		this.manager.remove(aluno);
	}

	
	public List<Aluno> filtrar(FiltroAluno filtro) {
		Session session = manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(Aluno.class);
		
		if(StringUtils.isNotEmpty(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), 
					MatchMode.ANYWHERE));
		}
		return criteria.list();
	
	}

}
