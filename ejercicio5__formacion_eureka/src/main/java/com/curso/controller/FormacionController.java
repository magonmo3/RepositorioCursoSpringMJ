package com.curso.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionService;

@CrossOrigin("*")
@RestController
public class FormacionController {
	  private static Logger log = LoggerFactory.getLogger(FormacionController.class);
	@Autowired
	FormacionService service;
	
	@PostMapping(value="formacion/{curso}/{asignaturas}/{precio}")
	public List<Formacion> altaFormacion(@PathVariable("curso") String curso, @PathVariable("asignaturas")  int asignaturas, @PathVariable("precio") double precio){
		
		int idCurso = service.maxIdCurso();
		
		Formacion formacion= new Formacion (idCurso+1, curso, asignaturas*10, precio );
		log.info("formacion: " + formacion.getNombre());
		
		return service.nuevaFormacion(formacion);
		
		
	}
	

}
