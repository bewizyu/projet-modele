package org.gestion.services.impl;

import org.gestion.entite.Grade;
import org.gestion.services.IGradeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Service(value = "gradeServiceJpa")
public class GradeServiceJpa implements IGradeService {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Grade create(Grade nvGrade) {
		em.persist(nvGrade);
		return nvGrade;
	}

	@Override
	@Transactional
	public void update(Grade grade) {
		Query query = em.createQuery("FROM Grade c WHERE c.code=:code");
		query.setParameter("code", grade.getCode());

		List<Grade> oldGrades = query.getResultList();
		if (!oldGrades.isEmpty()) {
			Grade oldGrade = oldGrades.get(0);
			oldGrade.setCode(grade.getCode());
			oldGrade.setTauxBase(grade.getTauxBase());
			oldGrade.setNbHeuresBase(grade.getNbHeuresBase());
			em.merge(oldGrade);
			em.flush();
		}
	}

	@Override
	public List<Grade> getGrades() {
		TypedQuery<Grade> query = em.createQuery("FROM Grade", Grade.class);
		return query.getResultList();
	}

	@Override
	public void deleteGrade(int id) {
		throw new Error("Not yet implemented");
	}

	@Override
	public Grade getGradeById(int id) {
		throw new Error("Not yet implemented yet");
	}

}
