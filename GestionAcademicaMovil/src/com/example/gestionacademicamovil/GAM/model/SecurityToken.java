package com.example.gestionacademicamovil.GAM.model;

import java.io.Serializable;


public class SecurityToken extends Object 
{
	private String user;
	private String pass;
	
	public SecurityToken()
	{
		this.user="eee";
		this.pass="eee";
	}
	
	public String getUsername()
	{
		return user;
	}
	
	public void setUsername(String username)
	{
		this.user=username;
	}
	
	public String getPasswd()
	{
		return pass;
	}
	
	public void setPasswd(String passwd)
	{
		this.pass=passwd;
	}
}
