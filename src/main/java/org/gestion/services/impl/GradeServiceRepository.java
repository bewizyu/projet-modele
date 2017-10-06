package org.gestion.services.impl;

import org.gestion.entite.Grade;
import org.gestion.repository.GradeRepository;
import org.gestion.services.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nicolas Hodicq (nhodicq@sqli.com)
 */
@Service(value = "gradeServiceRepository")
public class GradeServiceRepository implements IGradeService {

	@Autowired
	private GradeRepository gradeRepository;

	@Override
	public void deleteGrade(int id) {
		gradeRepository.delete(id);
	}

	@Override
	public Grade getGradeById(int id) {
		return gradeRepository.findOne(id);
	}

	@Override
	public Grade create(Grade nouveauGrade) {
		return gradeRepository.save(nouveauGrade);
	}

	@Override
	public void update(Grade grade) {

		final Grade toUpdate = gradeRepository.findOne(grade.getId());

		if (toUpdate != null) {
			toUpdate.setCode(grade.getCode());
			toUpdate.setNbHeuresBase(grade.getNbHeuresBase());
			toUpdate.setTauxBase(grade.getTauxBase());
			gradeRepository.save(toUpdate);
		}

	}

	@Override
	public List<Grade> getGrades() {
		return gradeRepository.findAll();
	}
}
