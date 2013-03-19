package com.example.gestionacademicamovil.GAM;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class AjustesActivity extends Activity {
	
	private  Bundle bundle;
	private TextView usuario,texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gam);
        
        bundle=getIntent().getExtras();
        usuario.setText(GAMApplication.getInstance().getPreferencesManager().getName());
        
        usuario=(TextView)findViewById(R.id.usuario);
        usuario.setText(GAMApplication.getInstance().getPreferencesManager().getName());
        texto=(TextView)findViewById(R.id.texto);
        texto.setText("Ajustes");
        
    }

    public void onBackPressed() 
	{
		Intent i = new Intent();
		i.setClass(AjustesActivity.this, ListaActivity.class);
  		startActivity(i);
  		AjustesActivity.this.finish();
	 }
    
}
