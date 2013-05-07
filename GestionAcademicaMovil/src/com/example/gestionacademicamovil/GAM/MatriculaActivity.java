package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gestionacademicamovil.GAM.managers.UsuarioManager;
//import com.example.gestionacademicamovil.GAM.model.SecurityToken;
import com.example.gestionacademicamovil.GAM.model.Usuario;

//import es.unirioja.ae.academico.api.jws.SecurityToken;

public class MatriculaActivity extends Activity {
	
	private Bundle bundle;
	private Usuario alumno1,alumno2;
	private TextView usuario,documento,nombre,apellidos,email,telefono,grado,curso,
					fecha_matricula,forma_pago,importe;
	
	private ImageButton edit_email,edit_tfno;
	
	private ArrayList<Usuario> datos=new ArrayList<Usuario>();
	
	private Resources mResources;
	
	//SecurityToken token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.matricula);
        
        mResources = getResources();
        
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
        
        edit_email=(ImageButton)findViewById(R.id.edit_email);
        edit_tfno=(ImageButton)findViewById(R.id.edit_tfno);
        
        edit_tfno.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		ModificarDatos(mResources.getString(R.string.telefono));
  		  }
  	  	});
        
        edit_email.setOnClickListener(new OnClickListener(){
    		  public void onClick(View view){
    			  ModificarDatos(mResources.getString(R.string.email));
    		  }
    	  });
        
        alumno1=new Usuario();
        /*token=new SecurityToken();
		token.setUsername(GAMApplication.getInstance().getPreferencesManager().getUser());
		token.setPasswd(GAMApplication.getInstance().getPreferencesManager().getPassword());
		alumno2=GAMApplication.getInstance().getUsuarioManager().getUsuario(token);*/
        
        alumno2=getUsuario(GAMApplication.getInstance().getPreferencesManager().getUser(),GAMApplication.getInstance().getPreferencesManager().getPassword());

        documento.setText(alumno2.getNIF());
        nombre.setText(alumno2.getNombre());
        apellidos.setText(alumno2.getApellidos());
        telefono.setText(alumno2.getTelefono());
        email.setText(alumno2.getEmail());
        
        grado.setText(alumno2.getGrado());
        curso.setText(alumno2.getCurso());
        fecha_matricula.setText(alumno2.getFecha_matricula());
        forma_pago.setText(alumno2.getForma_pago());
        importe.setText(alumno2.getImporte());
    }
    
    public void ModificarDatos(final String dato)
    {
    	 AlertDialog.Builder editalert = new AlertDialog.Builder(this);

    	 editalert.setTitle((mResources.getString(R.string.intro))+dato);
    	 editalert.setMessage(dato);

    	 final EditText input = new EditText(this);
    	 LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
    	         LinearLayout.LayoutParams.FILL_PARENT,
    	         LinearLayout.LayoutParams.FILL_PARENT);
    	 input.setLayoutParams(lp);
    	 editalert.setView(input);

    	 editalert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    	     public void onClick(DialogInterface dialog, int whichButton) {
    	    	 
    	    	 if(dato.equals(mResources.getString(R.string.email)))
    	    	 {
    	    		 alumno2.setEmail(input.getText().toString());
    	    		 email.setText(alumno2.getEmail());
    	    	 }
    	    	 else 
    	    	 {
    	    		 alumno2.setTelefono(input.getText().toString());
    	    		 telefono.setText(alumno2.getTelefono());
    	    	 }
    	    	 	
    	     }
    	 });
    	 editalert.setNegativeButton(mResources.getString(R.string.cancel), new DialogInterface.OnClickListener() {
    	     public void onClick(DialogInterface dialog, int whichButton) {
    	    	 	finish();
    	     }
    	 });
    	 
    	 AlertDialog alert = editalert.create();
     	 alert.show();
    }
    
    public void crearUsuarios()
    {
    	Usuario u1=new Usuario("carol","1234","Carol","12345678","ponce marin","941225689","carol@gmail.com","Grado en Ingeniería Informática","2012/2013","3","18/08/2012","Domiciliacion","985.54");
    	Usuario u2=new Usuario("elena","4321","Elena","987654321","garcia fernandez","941362154","elena@gmail.com","Grado en Ingeniería Informática","2012/2013","3","20/08/2012","Domiciliacion","1200");
    	Usuario u3=new Usuario("oscar","1423","Oscar","192837465","mezquita gonzalez","941325541","oscar@gmail.com","Grado en Matematicas","2012/2013","3","22/08/2012","Domiciliacion","1145.50");
    	Usuario u4=new Usuario("eloy","1234","Eloy","12345678","mata","941225689","eloy@gmail.com","Grado en Ingeniería agricola","2012/2013","2","25/08/2012","Domiciliacion","840.79");
    
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
