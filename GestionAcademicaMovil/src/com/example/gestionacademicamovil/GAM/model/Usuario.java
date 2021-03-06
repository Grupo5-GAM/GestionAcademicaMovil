package com.example.gestionacademicamovil.GAM.model;

import java.io.Serializable;
import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class Usuario {

	private String cuasi;
	private String password;
	private String nombre;
	private String NIF;
	private String apellidos;
	private String telefono;
	private String email;
	
	private String grado;
	private String curso;
	private String curso2;
	private String fecha_matricula;
	private String forma_pago;
	private String importe;
	
	public Usuario()
	{
		setCuasi("");
		setPassword("");
		setNombre("");
		setNIF("");
		setApellidos("");
		setTelefono("");
		setEmail("");
		
		setGrado("g");
		setCurso("c");
		setCurso2("c2");
		setFecha_matricula("f");
		setForma_pago("fp");
		setImporte("i");
	}
	
	public Usuario(String no,String n,String a,String t,String e,String g,String c,String f,String fp,String i)
	{
		setNombre(no);
		setNIF(n);
		setApellidos(a);
		setTelefono(t);
		setEmail(e);
	}
	
	public Usuario(String u,String p,String no,String n,String a,String t,String e,String g,String c,String c2,String f,String fp,String i)
	{
		setCuasi(u);
		setPassword(p);
		setNombre(no);
		setNIF(n);
		setApellidos(a);
		setTelefono(t);
		setEmail(e);
		setGrado(g);
		setCurso(c);
		setCurso2(c2);
		setFecha_matricula(f);
		setForma_pago(fp);
		setImporte(i);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getFecha_matricula() {
		return fecha_matricula;
	}

	public void setFecha_matricula(String fecha_matricula) {
		this.fecha_matricula = fecha_matricula;
	}

	public String getForma_pago() {
		return forma_pago;
	}

	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public String getCurso2() {
		return curso2;
	}

	public void setCurso2(String curso2) {
		this.curso2 = curso2;
	}
	
	/*@Override
	public Object getProperty(int arg0) {
	 
	    switch(arg0)
	        {
	        case 0:
	            return nombre;
	        case 1:
	            return NIF;
	        case 2:
	            return apellidos;
	        case 3:
	        	return telefono;
	        case 4:
	        	return email;
	        }
	    
	 
	    return null;
	}

	@Override
	public int getPropertyCount() {
		return 5;
	}

	@Override
	public void getPropertyInfo(int ind, Hashtable ht, PropertyInfo info) {
		switch(ind)
        {
        case 0:
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Nombre";
            break;
        case 1:
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "NIF";
            break;
        case 2:
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "apellidos";
            break;
        case 3:
        	 info.type = PropertyInfo.STRING_CLASS;
             info.name = "telefono";
             break;
        case 4:
       	 	info.type = PropertyInfo.STRING_CLASS;
            info.name = "email";
            break;
        	
        default:break;
        }
		
	}

	@Override
	public void setProperty(int ind, Object val) {
		switch(ind)
        {
        case 0:
            nombre = val.toString();
            break;
        case 1:
            NIF = val.toString();
            break;
        case 2:
            apellidos =val.toString();
            break;
        case 3:
            telefono =val.toString();
            break;
        case 4:
            email =val.toString();
            break;
        default:
            break;
        }
		
	}*/
}

