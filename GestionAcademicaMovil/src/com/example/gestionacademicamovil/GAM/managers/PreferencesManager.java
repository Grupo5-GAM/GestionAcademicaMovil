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
	
	/**
	 * Class constructor. Instances a new object of type PreferencesManager
	 * to manage all the iDigi service preferences.
	 * 
	 * @param context The application context.
	 */
	public PreferencesManager(Context context) {
		preferences = PreferenceManager.getDefaultSharedPreferences(context);
		editor = preferences.edit();
	}
	
	/**
	 * Retrieves the Alias setting value.
	 * 
	 * @return Alias setting value, default one if not configured.
	 */
	public String getName() {
		return preferences.getString(PreferencesConstants.NAME, PreferencesConstants.NAME_DEFAULT);
	}
	
	/**
	 * Sets the Alias setting new value.
	 * 
	 * @param alias Alias setting new value.
	 */
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
	
	/**
	 * Retrieves the Email setting value.
	 * 
	 * @return Email setting value, default one if not configured.
	 */
	public String getUser() {
		return preferences.getString(PreferencesConstants.USER, PreferencesConstants.USER_DEFAULT);
	}
	
	/**
	 * Sets the Email setting new value.
	 * 
	 * @param email Email setting new value.
	 */
	public void setUser(String user) {
		editor.putString(PreferencesConstants.USER, user);
		editor.commit();
	}
	
	/**
	 * Retrieves the Password setting value.
	 * 
	 * @return Password setting value, default one if not configured.
	 */
	public String getPassword() {
		return preferences.getString(PreferencesConstants.PASSWORD, PreferencesConstants.PASSWORD_DEFAULT);
	}
	
	/**
	 * Sets the Password setting new value.
	 * 
	 * @param password Password setting new value.
	 */
	public void setPassword(String password) {
		editor.putString(PreferencesConstants.PASSWORD, password);
		editor.commit();
	}
	
	
	
	/**
	 * Retrieves the remember login setting value.
	 * 
	 * @return Remember login setting value, default one if not configured.
	 */
	public boolean getRememberLogin() {
		return preferences.getBoolean(PreferencesConstants.REMEMBER_LOGIN, PreferencesConstants.REMEMBER_LOGIN_DEFAULT);
	}
	
	/**
	 * Sets the remember login setting new value.
	 * 
	 * @param time Remember login setting new value.
	 */
	public void setRememberLogin(boolean rememberLogin) {
		editor.putBoolean(PreferencesConstants.REMEMBER_LOGIN, rememberLogin);
		editor.commit();
	}
	
	/**
	 * Retrieves the shared preferences instance.
	 * 
	 * @return The shared preferences instance.
	 */
	public SharedPreferences getSharedPreferences() {
		return preferences;
	}
}
