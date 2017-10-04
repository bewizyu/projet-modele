package org.gestion.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.gestion.entite.Grade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GradeServiceJpa implements GradeService {

	@PersistenceContext 
	private EntityManager em;

	@Override
	@Transactional
	public void sauvegarder(Grade nvGrade) {
		em.persist(nvGrade);
	}

	@Override
	@Transactional
	public void mettreAJour(Grade grade) {
		Query query = em.createQuery("FROM Grade c WHERE c.code=:code");
		query.setParameter("code", grade.getCode());
		
		List<Grade> oldGrades = query.getResultList();
		if (!oldGrades.isEmpty()){
			Grade oldGrade = oldGrades.get(0);
			oldGrade.setCode(grade.getCode());
			oldGrade.setTauxBase(grade.getTauxBase());
			oldGrade.setNbHeuresBase(grade.getNbHeuresBase());
			em.merge(oldGrade);
			em.flush();
		}
	}

	@Override
	public List<Grade> lister() {
		TypedQuery<Grade> query = em.createQuery("FROM Grade", Grade.class);
	    return query.getResultList();
	}

}
