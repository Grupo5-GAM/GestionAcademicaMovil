package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gestionacademicamovil.GAM.managers.UsuarioManager;
//import com.example.gestionacademicamovil.GAM.model.SecurityToken;
import com.example.gestionacademicamovil.GAM.model.Usuario;

import es.unirioja.ae.academico.api.jws.SecurityToken;

public class MatriculaActivity extends Activity {
	
	private Bundle bundle;
	private Usuario alumno1,alumno2;
	private TextView usuario,documento,nombre,apellidos,email,telefono,grado,curso,
					fecha_matricula,forma_pago,importe;
	
	private ArrayList<Usuario> datos=new ArrayList<Usuario>();
	
	//SecurityToken token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.matricula);
        
        crearUsuarios();
        
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
        alumno2=getUsuario(GAMApplication.getInstance().getPreferencesManager().getUser(),GAMApplication.getInstance().getPreferencesManager().getPassword());
        /*token=new SecurityToken();
		token.setUsername(GAMApplication.getInstance().getPreferencesManager().getUser());
		token.setUsername(GAMApplication.getInstance().getPreferencesManager().getPassword());
		
    */
        
        documento.setText(alumno2.getNIF());
        nombre.setText(alumno2.getNombre());
        apellidos.setText(alumno2.getApellidos());
        telefono.setText(alumno2.getTelefono());
        email.setText(alumno2.getEmail());
        
    }
    
    public void OnStart()
    {
    	super.onStart();
    	crearUsuarios();
    }

    public void crearUsuarios()
    {
    	Usuario u1=new Usuario("carol","1234","Carol","12345678","ponce marin","941225689","carol@gmail.com");
    	Usuario u2=new Usuario("elena","4321","Elena","987654321","garcia fernandez","941362154","elena@gmail.com");
    	Usuario u3=new Usuario("oscar","1423","Oscar","192837465","mezquita gonzalez","941325541","oscar@gmail.com");
    	Usuario u4=new Usuario("eloy","1234","Eloy","12345678","mata","941225689","eloy@gmail.com");
    
    	datos.add(u1);
    	datos.add(u2);
    	datos.add(u3);
    	datos.add(u4);
    }
    
    public Usuario getUsuario(String user,String pass)
    {

    	Usuario u=new Usuario();
    	for(int i=0;i<datos.size();i++)
    	{
    		if(datos.get(i).getCuasi().equals(user) & datos.get(i).getPassword().equals(pass))
    		{
    			u=datos.get(i);
    		}
    	}
		return u;
    }
    
}
