package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosServices;

@RestController
public class CursoController {
	
	@Autowired
	CursosServices service;
	
	
	@GetMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@PathVariable("codCurso") String codCurso) {
		return service.buscarCurso(codCurso);
	}
	
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> Cursos(){
		return service.cursos();
		
	}
	@PostMapping(value="cursoAdd", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> anyadir(@RequestBody Curso curso) {
		return service.altaCurso(curso);
	}
	
	@PutMapping(value="cursoUpdate", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Curso curso) {
		service.actualizarCurso(curso);
	}
	@DeleteMapping(value="cursoDelete/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso>borrar(@PathVariable("codCurso") String codCurso){
		return service.eliminarCurso(codCurso);
		
	}
	
	@GetMapping(value="cursoSearch/{minPrecio}/{maxPrecio}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarXprecio(@PathVariable("minPrecio") double minPrecio, @PathVariable("maxPrecio") double maxPrecio){
		return service.buscarCursoPrecio(minPrecio, maxPrecio);
	}
	

}
