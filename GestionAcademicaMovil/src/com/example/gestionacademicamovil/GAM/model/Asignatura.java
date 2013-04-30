package com.example.gestionacademicamovil.GAM.model;

public class Asignatura {

	private String grado;
	private String nombre;
	private int creditos;
	private String profesor;
	private String guia;
	private int cuatrimestre;
	
	public Asignatura()
	{
		this.grado="Grado informatica";
		this.nombre="Taller transversal";
		this.creditos=6;
		this.profesor="Cesar dominguez";
	}
	
	public Asignatura(String gr,String n,int c,String p,String gu,int cu)
	{
		this.grado=gr;
		this.nombre=n;
		this.creditos=c;
		this.profesor=p;
		this.guia=gu;
		this.setCuatrimestre(cu);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getGuia() {
		return guia;
	}

	public void setGuia(String guia) {
		this.guia = guia;
	}

	public int getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(int cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}
	
	
	
}

