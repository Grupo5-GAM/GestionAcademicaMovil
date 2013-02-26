package com.example.gestionacademicamovil.GAM;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class Todas extends Activity {
	
	private TextView usuario,texto;
	private  Bundle bundle;
	private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuatrimestres);
        
        bundle=getIntent().getExtras();
        user=bundle.getString("user");
        
        texto=(TextView)findViewById(R.id.texto);
        texto.setText("Primero");
        
    }

    public void onBackPressed() 
	{
		Intent i = new Intent();
		i.setClass(Todas.this, ListaActivity.class);
		i.putExtra("user",bundle.getString("user"));
  		startActivity(i);
  		Todas.this.finish();
	 }
    
}
