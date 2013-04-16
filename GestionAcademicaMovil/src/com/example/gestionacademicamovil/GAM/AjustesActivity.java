package com.example.gestionacademicamovil.GAM;

import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class AjustesActivity extends PreferenceActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.ajustes);
        
        /*Intent i = new Intent();
 		i.setClass(AjustesActivity.this, MatriculaActivity.class);
		startActivity(i);*/
        
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean v=sharedPrefs.getBoolean("cbVibracion", false);
        boolean s=sharedPrefs.getBoolean("cbSonido", false);
        //builder.append("\n" + sharedPrefs.getString("updates_interval", "-1"));
        //builder.append("\n" + sharedPrefs.getString("welcome_message", "NULL"));//*/
        
        final Preference preferencia1 = (Preference)findPreference("cbVibracion");
        preferencia1.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
        		public boolean onPreferenceChange(Preference preference, Object newValue) { 
        			
        			GAMApplication.getInstance().getPreferencesManager().setVibracion((Boolean) newValue);
        			
        			return true;
        }});

        
        final Preference preferencia2 = (Preference)findPreference("cbSonido");
        preferencia2.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
        		public boolean onPreferenceChange(Preference preference, Object newValue) { ;
        			
        			GAMApplication.getInstance().getPreferencesManager().setSonido((Boolean) newValue);
        			
        			return true;
        }});
        
        Preference about = (Preference) findPreference("about");
        about.setOnPreferenceClickListener(new OnPreferenceClickListener() {
   
         public boolean onPreferenceClick(Preference preference) {
        	 Intent i = new Intent();
      		 i.setClass(AjustesActivity.this, About.class);
     		 startActivity(i);
                   
     		 return true;
         }
      
        });

    }
    
    
    /*public static boolean getVibration(Context context) {
             return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(OPT_VIBRATION, OPT_VIBRATION_DEF);
    }
    	       
    public static boolean getSound(Context context) {
    	     return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(OPT_SOUND, OPT_SOUND_DEF);
     }*/
   

    
}
