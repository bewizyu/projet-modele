package org.gestion.services;

import org.gestion.entite.Grade;

import java.util.List;

/**
 * Interface qui liste les méthodes de persistence pour la classe {@link Grade} que doit posséder une classe
 * d'implémentation
 *
 * @author DIGINAMIC
 */
public interface IGradeService {

	/**
	 * Sauvegarde un nouveau grade
	 *
	 * @param nouveauGrade nouveau grade
	 */
	Grade create(Grade nouveauGrade);

	/**
	 * Mise à jour d'un grade
	 *
	 * @param grade
	 */
	void update(Grade grade);

	/**
	 * Extrait tous les grades existants
	 *
	 * @return
	 */
	List<Grade> getGrades();

	/**
	 * Récupération d'un grade par son id
	 * @param id
	 * @return
	 */
	Grade getGradeById (final int id);

	/**
	 * Suppression d'un Grade
	 * @param id
	 */
	void deleteGrade(final int id);
}
