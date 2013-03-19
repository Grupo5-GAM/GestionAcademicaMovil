package com.example.gestionacademicamovil.GAM;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;
import com.example.gestionacademicamovil.GAM.managers.UsuarioManager;
import com.example.gestionacademicamovil.GAM.model.SecurityToken;
import com.example.gestionacademicamovil.GAM.model.Usuario;

public class MatriculaActivity extends Activity {
	
	private Bundle bundle;
	private Usuario alumno1,alumno2;
	private TextView usuario,documento,nombre,apellidos,email,telefono,grado,curso,
					fecha_matricula,forma_pago,importe;
	
	SecurityToken token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matricula);
        
        usuario=(TextView)findViewById(R.id.usuario);
        usuario.setText(GAMApplication.getInstance().getPreferencesManager().getName());
        
        documento=(TextView)findViewById(R.id.documento);
        nombre=(TextView)findViewById(R.id.nombre);
        apellidos=(TextView)findViewById(R.id.apellidos);
        email=(TextView)findViewById(R.id.email);
        telefono=(TextView)findViewById(R.id.telefono);
        grado=(TextView)findViewById(R.id.grado);
        curso=(TextView)findViewById(R.id.curso);
        fecha_matricula=(TextView)findViewById(R.id.fecha_matricula);
        forma_pago=(TextView)findViewById(R.id.forma_pago);
        importe=(TextView)findViewById(R.id.importe);
        
        alumno1=new Usuario();
        token=new SecurityToken();
		token.setUsername(GAMApplication.getInstance().getPreferencesManager().getUser());
		token.setUsername(GAMApplication.getInstance().getPreferencesManager().getPassword());
		
    	alumno2=UsuarioManager.getUsuario(token);
    	
    	alumno1.setNIF(alumno2.getNIF());
    	alumno1.setNombre(alumno2.getNombre());
    	alumno1.setApellidos(alumno2.getApellidos());
    	alumno1.setTelefono(alumno2.getTelefono());
    	alumno1.setEmail(alumno2.getEmail());
        
        documento.setText(alumno1.getNIF());
        nombre.setText(alumno1.getNombre());
        apellidos.setText(alumno1.getApellidos());
        telefono.setText(alumno1.getTelefono());
        email.setText(alumno1.getEmail());
        
    }
    
    public void OnStart()
    {
    	super.onStart();
    }

    public void onBackPressed() 
	{
		Intent i = new Intent();
		i.setClass(MatriculaActivity.this, ListaActivity.class);
  		MatriculaActivity.this.finish();
  		startActivity(i);
	}
    
}
