package com.curso.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosServices;

@CrossOrigin("*")
@RestController
public class CursoController {
	private static Logger log = LoggerFactory.getLogger(CursoController.class);
	
	@Value("${eureka.instances-id}")
	String instancia;
	String instancia1;
	String instancia3;
	@Autowired
	CursosServices service;
	
	
	@GetMapping(value="curso/{idCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@PathVariable("idCurso") int idCurso) {
		return service.buscarCurso(idCurso);
	}
	
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> Cursos(){
		System.out.println("instancia: " +instancia);
		return service.cursos();
		
	}
	@PostMapping(value="cursoAdd", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> anyadir(@RequestBody Curso curso) {
		System.out.println("curso " +curso.getNombre());
		return service.altaCurso(curso);
	}
	
	@PutMapping(value="cursoUpdate", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Curso curso) {
		service.actualizarCurso(curso);
	}
	@DeleteMapping(value="cursoDelete/{idCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso>borrar(@PathVariable("idCurso") int idCurso){
		return service.eliminarCurso(idCurso);
		
	}
	
	@GetMapping(value="cursoSearch/{minPrecio}/{maxPrecio}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarXprecio(@PathVariable("minPrecio") double minPrecio, @PathVariable("maxPrecio") double maxPrecio){
		return service.buscarCursoPrecio(minPrecio, maxPrecio);
	}
	
	
	@GetMapping(value="maxIdCurso")
	public int maxIdCurso(){
		return service.maxIdCurso();
	}
	

}
