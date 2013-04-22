package com.example.gestionacademicamovil.GAM.managers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.example.gestionacademicamovil.GAM.preferences.PreferencesConstants;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;



/**
 * This class is used to read and set application preferences from any
 * activity or service in an easy and direct way.
 */
public class PreferencesManager {

	// Variables
	private SharedPreferences preferences;
	
	private Editor editor;

	public PreferencesManager(Context context) {
		preferences = PreferenceManager.getDefaultSharedPreferences(context);
		editor = preferences.edit();
	}

	public String getName() {
		return preferences.getString(PreferencesConstants.NAME, PreferencesConstants.NAME_DEFAULT);
	}
	
	public void setName(String name) {
		editor.putString(PreferencesConstants.NAME, name);
		editor.commit();
	}
	
	/*public List<String> getAllUser() {
		Map<String,?> AllData=preferences.getAll();
		Iterator<?> itr = AllData.entrySet().iterator();
		List<String> usuarios=new ArrayList<String>();;
		
		while (itr.hasNext()) {
			Map.Entry e = (Map.Entry)itr.next();
			if(e.getKey().equals("USER"))
			{
				usuarios.add(e.getValue().toString());
			}
		}
		return usuarios;
	}*/
	
	public String getUser() {
		return preferences.getString(PreferencesConstants.USER, PreferencesConstants.USER_DEFAULT);
	}

	public void setUser(String user) {
		editor.putString(PreferencesConstants.USER, user);
		editor.commit();
	}
	
	public String getGrado() {
		return preferences.getString(PreferencesConstants.GRADO, PreferencesConstants.GRADO_DEFAULT);
	}

	public void setGrado(String grado) {
		editor.putString(PreferencesConstants.GRADO, grado);
		editor.commit();
	}
	
	public String getPassword() {
		return preferences.getString(PreferencesConstants.PASSWORD, PreferencesConstants.PASSWORD_DEFAULT);
	}

	public void setPassword(String password) {
		editor.putString(PreferencesConstants.PASSWORD, password);
		editor.commit();
	}

	public boolean getRememberLogin() {
		return preferences.getBoolean(PreferencesConstants.REMEMBER_LOGIN, PreferencesConstants.REMEMBER_LOGIN_DEFAULT);
	}
	
	public void setRememberLogin(boolean rememberLogin) {
		editor.putBoolean(PreferencesConstants.REMEMBER_LOGIN, rememberLogin);
		editor.commit();
	}
	
	public boolean getSonido() {
		return preferences.getBoolean(PreferencesConstants.SONIDO, PreferencesConstants.SONIDO_DEFAULT);
	}
	
	public void setSonido(boolean sonido) {
		editor.putBoolean(PreferencesConstants.SONIDO, sonido);
		editor.commit();
	}

	public boolean getVibracion() {
		return preferences.getBoolean(PreferencesConstants.VIBRACION, PreferencesConstants.VIBRACION_DEFAULT);
	}
	
	public void setVibracion(boolean vibracion) {
		editor.putBoolean(PreferencesConstants.VIBRACION, vibracion);
		editor.commit();
	}
	

	public SharedPreferences getSharedPreferences() {
		return preferences;
	}
}
