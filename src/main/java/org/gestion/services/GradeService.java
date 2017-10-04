package org.gestion.services;

import java.util.List;

import org.gestion.entite.Grade;

/**
 * Interface qui liste les méthodes de persistence pour la classe {@link Grade}
 * que doit posséder une classe d'implémentation
 * 
 * @author DIGINAMIC
 */
public interface GradeService {

	/**
	 * Sauvegarde un nouveau grade
	 * 
	 * @param nouveauGrade
	 *            nouveau grade
	 */
	void sauvegarder(Grade nouveauGrade);

	/**
	 * Mise à jour d'un grade
	 * 
	 * @param grade
	 */
	void mettreAJour(Grade grade);

	/**
	 * Extrait tous les grades existants
	 * 
	 * @return
	 */
	List<Grade> lister();
}
