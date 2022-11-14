package com.curso.model;

public class Formacion {
	private int  idcurso;
	private String nombre;
	private int duracion;
	private double precio;
	public Formacion(int idCurso,String nombre, int duracion, double precio) {
		super();
		this.idcurso=idCurso;
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
	public Formacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}



}
