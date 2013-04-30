package com.example.gestionacademicamovil.GAM.model;

public class Nota {

	private int cuatrimestre;
	private String asignatura;
	private String grado;
	private int creditos;
	private double nota;
	private String definitiva;
	private String revision;
	
	public Nota()
	{
		this.cuatrimestre=1;
		this.asignatura="TOO";
		this.grado="";
		this.creditos=6;
		this.nota=8.5;
		this.definitiva="";
		this.revision="desp 350 12/05/2013";
	}
	
	public Nota(int cu,String a,String g,int c,double n,String d,String r)
	{
		this.cuatrimestre=cu;
		this.asignatura=a;
		this.grado=g;
		this.creditos=c;
		this.nota=n;
		this.definitiva=d;
		this.revision=r;
	}
	
	public int getCuatrimestre() {
		return cuatrimestre;
	}
	public void setCuatrimestre(int cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
	asignatura = asignatura;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public String isDefinitiva() {
		return definitiva;
	}
	public void setDefinitiva(String definitiva) {
		this.definitiva = definitiva;
	}
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}
	
}