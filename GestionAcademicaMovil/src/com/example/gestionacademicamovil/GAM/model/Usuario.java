package com.example.gestionacademicamovil.GAM.model;

public class Usuario {

	private String cuasi;
	private String password;
	private String nombre;
	private String NIF;
	private String apellidos;
	private String telefono;
	
	public Usuario()
	{
		setCuasi("");
		setPassword("");
		setNombre("");
		setNIF("");
		setApellidos("");
		setTelefono("");
	}
	
	public Usuario(String u,String p,String no,String n,String a,String t)
	{
		setCuasi(u);
		setPassword(p);
		setNombre(no);
		setNIF("n");
		setApellidos("a");
		setTelefono("t");
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCuasi() {
		return cuasi;
	}

	public void setCuasi(String cuasi) {
		this.cuasi = cuasi;
	}
	
}

