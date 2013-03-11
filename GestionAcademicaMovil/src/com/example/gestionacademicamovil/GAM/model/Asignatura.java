package com.example.gestionacademicamovil.GAM.model;

public class Asignatura {

	private String grado;
	private String nombre;
	private int creditos;
	private String profesor;
	private String guia;
	
	public Asignatura()
	{
		this.grado="Grado informatica";
		this.nombre="Taller transversal";
		this.creditos=6;
		this.profesor="Cesar dominguez";
		this.guia="http:/blabla";
	}
	
	public Asignatura(String gr,String n,int c,String p,String g)
	{
		this.grado=gr;
		this.nombre=n;
		this.creditos=c;
		this.profesor=p;
		this.guia=g;
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

	public String getGuia() {
		return guia;
	}

	public void setGuia(String guia) {
		this.guia = guia;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}
	
	
	
}

