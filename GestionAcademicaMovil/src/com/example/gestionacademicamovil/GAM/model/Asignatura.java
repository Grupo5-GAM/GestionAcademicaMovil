package com.example.gestionacademicamovil.GAM.model;

public class Asignatura {

	private String nombre;
	private String c;
	private String NIF;
	private String apellidos;
	private String telefono;
	
	public Asignatura()
	{
	
		setNIF("");
		setApellidos("");
		setTelefono("");
	}
	
	public Asignatura(String u,String p,String n,String a,String t)
	{
		
		setNIF("n");
		setApellidos("a");
		setTelefono("t");
	}

	

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
}

