package org.gestion.web.controller;

import java.util.List;

import org.gestion.entite.Grade;
import org.gestion.repository.GradeRepository;
import org.gestion.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grades")
public class RestGradeController {

	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@RequestMapping(path="/withJpa", method = RequestMethod.GET)
	@ResponseBody
	public List<Grade> listeEmployesWithJpa() {
		return gradeService.lister();
	}
	
	@RequestMapping(path="/withRepository", method = RequestMethod.GET)
	@ResponseBody
	public List<Grade> listeEmployesWithRepository() {
		return gradeRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/creer", consumes = "application/json;charset=UTF-8")
	public String ajoutAbsence(@RequestBody Grade newGrade) {
		gradeService.sauvegarder(newGrade);
		return "{'success': true}";

	}

}
