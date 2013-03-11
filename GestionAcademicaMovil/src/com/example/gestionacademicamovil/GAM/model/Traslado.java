package com.example.gestionacademicamovil.GAM.model;

public class Traslado {

	private String universidad;
	private String ciudad;
	private String pais;
	
	public Traslado()
	{
		this.universidad="Universidad de salamanca";
		this.ciudad="Salamanca";
		this.pais="España";
	}
	
	public Traslado(String u,String c,String p)
	{
		this.universidad=u;
		this.ciudad=c;
		this.pais=p;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	
	
}

