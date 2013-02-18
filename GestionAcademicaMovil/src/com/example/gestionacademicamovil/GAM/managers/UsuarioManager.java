package com.example.gestionacademicamovil.GAM.managers;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import android.content.Context;

import com.example.gestionacademicamovil.GAM.model.Usuario;

public class UsuarioManager {
	
	
	private Usuario user;
	private Boolean existe;
	
	private Context context;
	
	public UsuarioManager(Context context) {
		this.context = context;
	}
	
	
	/*public Usuario getUsuario(String cuasi)
	{
		//conexion
		//consulta que me devuelva los datos del usuario con esa cuasi
		String u,p,no,n,a,t;
		
		user=new Usuario(u,p,no,n,a,t);
		
		return user;
	}*/
	
}