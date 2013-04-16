package com.example.gestionacademicamovil.GAM;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class About extends Activity {
	
	private TextView about,desarrolladores;
	private  Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        
        about=(TextView)findViewById(R.id.about);
        about.setText("Gestion academica movil es una aplicacion desarrollada especialmente" +
        		"para estudiantes universitaios. Pretende facilitar el acceso a las notas,asignaturas" +
        		",horarios de clases y de examenes e incluso al aula virtual. " +
        		"Una aplicacion muy facil de utilizar y con una interfaz agradable y sencilla.");
        
        desarrolladores=(TextView)findViewById(R.id.desarrolladores);
        desarrolladores.setText("Aplicacion desarrollada por Carolina Ponce Marin, Elena García" +
        		" Fernandez y Oscar Mezquita Dominguez");
    }

    public void onBackPressed() 
	{
		Intent i = new Intent();
		i.setClass(About.this, ListaActivity.class);
		About.this.finish();
  		startActivity(i);
	 }
    
}
