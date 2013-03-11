package com.example.gestionacademicamovil.GAM.model;

public class Convalidacion {

	private String asignatura;
	private String asignaturaAntigua;
	private int creditos;
	private String tipo;
	private Double nota;
	
	public Convalidacion()
	{
		this.asignatura="Informatica movil";
		this.asignaturaAntigua="nose que asig";
		this.creditos=6;
		this.tipo="obligatotia";
		this.nota=5.6;
	}
	
	public Convalidacion(String a,String aa,int c,String t,Double n)
	{
		this.asignatura=a;
		this.asignaturaAntigua=aa;
		this.creditos=c;
		this.tipo=t;
		this.nota=n;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getAsignaturaAntigua() {
		return asignaturaAntigua;
	}

	public void setAsignaturaAntigua(String asignaturaAntigua) {
		this.asignaturaAntigua = asignaturaAntigua;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	
	
	
}

