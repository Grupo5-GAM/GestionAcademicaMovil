package com.example.gestionacademicamovil.GAM;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class MatriculaActivity extends Activity {
	
	private  Bundle bundle;
	private String user;
	private TextView usuario,texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matricula);
        
        bundle=getIntent().getExtras();
        user=bundle.getString("user");
        
        usuario=(TextView)findViewById(R.id.usuario);
        usuario.setText(user);
        texto=(TextView)findViewById(R.id.texto);
        texto.setText("Matricula");
        
        
        
    }

    public void onBackPressed() 
	{
		Intent i = new Intent();
		i.setClass(MatriculaActivity.this, ListaActivity.class);
  		i.putExtra("user",bundle.getString("user"));
  		startActivity(i);
  		MatriculaActivity.this.finish();
	 }
    
}
