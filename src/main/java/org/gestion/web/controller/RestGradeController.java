package org.gestion.web.controller;

import org.gestion.entite.Grade;
import org.gestion.services.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class RestGradeController {

	@Autowired
	@Qualifier("gradeServiceJpa")
	private IGradeService gradeServiceJpa;

	@Autowired
	@Qualifier("gradeServiceRepository")
	private IGradeService gradeServiceRepository;



	// ********************************** //
	// ******* GET LIST GRADES ********** //
	// ********************************** //

	@RequestMapping(path = "/withJpa", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Grade> getGradesWithJPA() {
		return gradeServiceJpa.getGrades();
	}

	@RequestMapping(path = "/withRepository", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Grade> getGradesWithRepository() {
		return gradeServiceRepository.getGrades();
	}

	// *********************************** //
	// ******* GET GRADES BY ID ********** //
	// *********************************** //

	@RequestMapping(path = "/grades/{idGrade}/path-param", method = RequestMethod.GET)
	@ResponseBody
	public Grade getGradeByIdWithPathParam(@PathVariable("idGrade") int idGrade) {
		return gradeServiceRepository.getGradeById(idGrade);
	}

	@RequestMapping(path = "/grades/query-param", method = RequestMethod.GET)
	@ResponseBody
	public Grade getGradeByIdWithQueryParam(@RequestParam("idGrade") int idGrade) {
		return gradeServiceRepository.getGradeById(idGrade);
	}

	// *********************************** //
	// ********** CREATE GRADES ********** //
	// *********************************** //

	@RequestMapping(method = RequestMethod.POST, path = "/", consumes = "application/json;charset=UTF-8")
	public Grade createGrade(@RequestBody Grade newGrade) {
		return gradeServiceJpa.create(newGrade);
	}

	// *********************************** //
	// ******* UPDATE GRADE BY ID ******** //
	// *********************************** //

	@RequestMapping(path = "/grades", method = RequestMethod.PUT)
	@ResponseBody
	public void updateGrade(@RequestBody Grade updateGrade) {
		gradeServiceRepository.update(updateGrade);
	}

	//
	// *********************************** //
	// ******* DELETE GRADE BY ID ******** //
	// *********************************** //
}
