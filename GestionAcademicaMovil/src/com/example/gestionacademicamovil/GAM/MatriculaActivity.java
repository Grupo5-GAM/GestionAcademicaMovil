package com.example.gestionacademicamovil.GAM;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class MatriculaActivity extends Activity {
	
	private  Bundle bundle;
	private String user;
	private TextView usuario,documento,nombre,apellidos,fecha_nacimiento,grado,curso,
					fecha_matricula,forma_pago,importe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matricula);
        
        bundle=getIntent().getExtras();
        user=bundle.getString("user");
        
        usuario=(TextView)findViewById(R.id.usuario);
        usuario.setText(user);
        
        documento=(TextView)findViewById(R.id.documento);
        nombre=(TextView)findViewById(R.id.nombre);
        apellidos=(TextView)findViewById(R.id.apellidos);
        fecha_nacimiento=(TextView)findViewById(R.id.fecha_nacimiento);
        grado=(TextView)findViewById(R.id.grado);
        curso=(TextView)findViewById(R.id.curso);
        fecha_matricula=(TextView)findViewById(R.id.fecha_matricula);
        forma_pago=(TextView)findViewById(R.id.forma_pago);
        importe=(TextView)findViewById(R.id.importe);
        
        
        
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
