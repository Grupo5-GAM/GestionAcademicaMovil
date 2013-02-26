package com.example.gestionacademicamovil.GAM;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class AjustesActivity extends Activity {
	
	private  Bundle bundle;
	private String user;
	private TextView usuario,texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gam);
        
        bundle=getIntent().getExtras();
        user=bundle.getString("user");
        
        usuario=(TextView)findViewById(R.id.usuario);
        usuario.setText(user);
        texto=(TextView)findViewById(R.id.texto);
        texto.setText("Ajustes");
        
    }

    public void onBackPressed() 
	{
		Intent i = new Intent();
		i.setClass(AjustesActivity.this, ListaActivity.class);
  		i.putExtra("user",bundle.getString("user"));
  		startActivity(i);
  		AjustesActivity.this.finish();
	 }
    
}
