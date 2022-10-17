package com.curso.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class CursoController {
	private static Logger log = LoggerFactory.getLogger(CursoController.class);
	@Autowired
	CursosServices service;
	
	@ApiOperation(value="Busca el libro que coincide con idCurso")
	@GetMapping(value="curso/{idCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@ApiParam(value="ID del curso a buscar")@PathVariable("idCurso") int idCurso) {
		return service.buscarCurso(idCurso);
	}
	@ApiOperation(value="Devuelve la lista con todos los cursos")
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> Cursos(){
		return service.cursos();
		
	}
	@ApiOperation(value="Añade un nuevo curso recibido en el cuerpo de la petición")
	@PostMapping(value="cursoAdd", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> anyadir(@ApiParam(value="Objeto JSOn con los datos del curso a dar de alta") @RequestBody Curso curso) {
		System.out.println("curso " +curso.getNombre());
		return service.altaCurso(curso);
	}
	
	@ApiOperation(value="Actualiza el curso que pasamos en el cuerpo de la petición")
	@PutMapping(value="cursoUpdate", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@ApiParam(value="Objeto JSOn con los datos del curso a modificar")@RequestBody Curso curso) {
		service.actualizarCurso(curso);
	}
	@ApiOperation(value="Elimina el curso con el ID que pasamos como parámetro")
	@DeleteMapping(value="cursoDelete/{idCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso>borrar(@ApiParam(value="ID del curso a eliminar") @PathVariable("idCurso") int idCurso){
		return service.eliminarCurso(idCurso);
		
	}
	@ApiOperation(value="Busca el curso que está comprendido entre el mínimo y máximo precio")
	@GetMapping(value="cursoSearch/{minPrecio}/{maxPrecio}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarXprecio(@ApiParam(value="Double que indica el mínimo precio") @PathVariable("minPrecio") double minPrecio, @ApiParam(value="Double que indica el máximo precio")@PathVariable("maxPrecio") double maxPrecio){
		return service.buscarCursoPrecio(minPrecio, maxPrecio);
	}
	
	
	@GetMapping(value="maxIdCurso")
	public int maxIdCurso(){
		return service.maxIdCurso();
	}
	

}
