package com.example.gestionacademicamovil.GAM.model;

public class Beca {

	
	private String tipo;
	private String estado;
	
	public Beca()
	{
		this.tipo="movilidad";
		this.estado="abierta";
	}
	
	public Beca(String t,String e)
	{
		this.tipo=t;
		this.estado=e;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}