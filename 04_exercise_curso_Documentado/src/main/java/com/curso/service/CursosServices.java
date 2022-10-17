package com.curso.service;

import com.curso.model.Curso;

import java.util.List;

public interface CursosServices {
	List<Curso> cursos();
	Curso buscarCurso(int idCurso);
	List<Curso>altaCurso(Curso curso);
	void actualizarCurso(Curso curso);
	List<Curso> eliminarCurso(int idCurso);
	List<Curso> buscarCursoPrecio(double minPrecio, double maxPrecio);
	int maxIdCurso();

}
