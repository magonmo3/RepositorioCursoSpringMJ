/**
 * Copyright (c) 2022 Generalitat Valenciana - Todos los derechos reservados.
 */
package com.curso.model;

/**
 * @author mariajose.gonzalez at http://www.organizacion.web[ORGANIZACION]
 *
 */
public class Curso {
	private String  codCurso;
	private String nombre;
	private double duracion;
	private double precio;
	
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Curso(String codCurso, String nombre, double duracion, double precio) {
		super();
		this.codCurso = codCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}
	/**
	 * @return the codCurso
	 */
	public String getCodCurso() {
		return codCurso;
	}
	/**
	 * @param codCurso the codCurso to set
	 */
	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
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
