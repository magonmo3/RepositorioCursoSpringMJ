/**
 * Copyright (c) 2022 Generalitat Valenciana - Todos los derechos reservados.
 */
package com.curso.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author mariajose.gonzalez at http://www.organizacion.web[ORGANIZACION]
 *
 */
@Entity
@Table(name="cursos")
public class Curso {
	@Id
	private int  idcurso;
	private String nombre;
	private double duracion;
	private double precio;
	
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Curso(int idcurso, String nombre, double duracion, double precio) {
		super();
		this.idcurso = idcurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}
	
	public int getIdcurso() {
		return idcurso;
	}
	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the duracion
	 */
	public double getDuracion() {
		return duracion;
	}
	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}


}
