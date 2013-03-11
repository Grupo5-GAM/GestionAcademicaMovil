package com.example.gestionacademicamovil.GAM.model;

public class Nota {

	private int cuatrimestre;
	private String asignatura;
	private int creditos;
	private double nota;
	private boolean definitiva;
	private String revision;
	
	public Nota()
	{
		this.cuatrimestre=1;
		this.asignatura="TOO";
		this.creditos=6;
		this.nota=8.5;
		this.definitiva=true;
		this.revision="desp 350 12/05/2013";
	}
	
	public Nota(int cu,String a,int c,double n,boolean d,String r)
	{
		this.cuatrimestre=cu;
		this.asignatura=a;
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
	public boolean isDefinitiva() {
		return definitiva;
	}
	public void setDefinitiva(boolean definitiva) {
		this.definitiva = definitiva;
	}
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	
}