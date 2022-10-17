package com.curso.service;

import com.curso.model.Curso;

import java.util.List;

public interface CursosServices {
	List<Curso> cursos();
	Curso buscarCurso(String codCurso);
	List<Curso>altaCurso(Curso curso);
	void actualizarCurso(Curso curso);
	List<Curso> eliminarCurso(String codCurso);
	List<Curso> buscarCursoPrecio(double minPrecio, double maxPrecio);
	

}
