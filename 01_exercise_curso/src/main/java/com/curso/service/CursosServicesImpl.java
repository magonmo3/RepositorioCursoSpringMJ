package com.curso.service;

import com.curso.model.Curso;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CursosServicesImpl implements CursosServices {
	List<Curso> cursos;
	
	public CursosServicesImpl() {
		cursos=new ArrayList<>();
		cursos.add(new Curso("001", "Spring boot", 50,1500.00));
		cursos.add(new Curso("002", "Angular Básico", 150,2500.00));
		cursos.add(new Curso("003", "Spring boot ||", 200,3000.00));
		cursos.add(new Curso("004", "CSS3", 250,4500.00));
		cursos.add(new Curso("005", "HTML5", 1250,6000.00));
		cursos.add(new Curso("006", "Java 13", 50,7500.00));

		
	}
	@Override
	public List<Curso> cursos() {
		// TODO Auto-generated method stub
		return cursos;
	}

	@Override
	public Curso buscarCurso(String codCurso) {
		// TODO Auto-generated method stub
		return cursos.stream().filter(c->(c.getCodCurso()).equals(codCurso)).findFirst().orElse(null);
		 
	}

	@Override
	public List<Curso> altaCurso(Curso curso) {
		// TODO Auto-generated method stub
		cursos.add(curso);
		return cursos;

	}

	@Override
	public void actualizarCurso(Curso curso) {
		// TODO Auto-generated method stub
		Curso curs =buscarCurso(curso.getCodCurso());
		if (curs !=null) {
			curs.setDuracion(curso.getDuracion());
		}

	}

	@Override
	public List<Curso> eliminarCurso(String codCurso) {
		// TODO Auto-generated method stub
		cursos.removeIf(c->(c.getCodCurso()).equals(codCurso));
		return cursos;
	}
	
	@Override
	public List<Curso> buscarCursoPrecio(double minPrecio, double maxPrecio){
		
		 List<Curso> cursoPrecio = cursos.stream().
				filter(c->c.getPrecio() > minPrecio ).
				filter(c->c.getPrecio() < maxPrecio )
				.toList();
		 return cursoPrecio;
		
	}

}
