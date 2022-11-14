package com.curso.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.curso.dao.CursosDao;
import com.curso.model.Curso;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;



@Service
public class CursosServicesImpl implements CursosServices {
	private static Logger log = LoggerFactory.getLogger(CursosServicesImpl.class);
	
	@Autowired
	CursosDao dao;
	
	@Override
	public List<Curso> cursos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Curso buscarCurso(int idCurso) {
		// TODO Auto-generated method stub
		return dao.findById(idCurso).orElse(null);
		 
	}

	@Override
	public List<Curso> altaCurso(Curso curso) {
		// TODO Auto-generated method stub
		System.out.println("nombre curso: "+curso.getNombre());
		dao.save(curso);
		return dao.findAll();

	}

	@Override
	public void actualizarCurso(Curso curso) {
		// TODO Auto-generated method stub
		Curso curs =buscarCurso(curso.getIdcurso());
		if (curs !=null) {
			curs.setDuracion(curso.getDuracion());
		}

	}

	@Override
	public List<Curso> eliminarCurso(int idCurso) {
		// TODO Auto-generated method stub
		dao.deleteById(idCurso);
		return dao.findAll();
	}
	
	@Override
	public List<Curso> buscarCursoPrecio(double minPrecio, double maxPrecio){
		
		 List<Curso> cursoPrecio = dao.findAll().stream().
				filter(c->c.getPrecio() > minPrecio ).
				filter(c->c.getPrecio() < maxPrecio )
				.toList();
		 return cursoPrecio;
		
	}
	@Override
	public int maxIdCurso() {
		//Obtener el curso con el max Idcurso
	    Curso curso = dao.findAll().stream()
                .max(Comparator.comparingInt(Curso::getIdcurso))
                .get();
	
		return curso.getIdcurso();
	}

}
