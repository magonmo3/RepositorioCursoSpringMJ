package com.curso.service;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {
	private static Logger log = LoggerFactory.getLogger(FormacionServiceImpl.class);
	@Autowired
	RestTemplate template;
	
	private String url="http://localhost:8080/";
	@Override
	public	List<Formacion> nuevaFormacion(Formacion formacion){
		
		log.info("Accedo a  nuevaFormacion: " + formacion.getIdcurso());
		template.postForLocation(url+"cursoAdd", formacion);
		log.info("formacion: " + formacion.getIdcurso());
			
		log.info("Cursos: " + Arrays.asList(template.getForObject(url+"cursos", Formacion[].class)));
		return Arrays.asList(template.getForObject(url+"cursos", Formacion[].class));
		
		
	}
	private String url2="http://localhost:8080/";
	@Override
	public int maxIdCurso(){
		return template.getForObject(url+"maxIdCurso", int.class);
	}

}
