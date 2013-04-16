package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;
import java.util.List;

import com.example.gestionacademicamovil.GAM.managers.CrearPDF;
import com.example.gestionacademicamovil.GAM.model.Asignatura;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AsignaturasActivity extends Activity {
	
	private ListView list;
	
	private Bundle bundle;
	private String grado;
	private TextView usuario;
	
	
	private miAdapter adapter;
	private Button btDescargar;
	
	private ArrayList<Asignatura> datos=new ArrayList<Asignatura>();
	private ArrayList<Asignatura> datosMostrar=new ArrayList<Asignatura>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.asignaturas);
        
        bundle=getIntent().getExtras();
        grado=bundle.getString("grado");
        crearDatos();
        
        usuario=(TextView)findViewById(R.id.usuario);
        usuario.setText(GAMApplication.getInstance().getPreferencesManager().getName());
        
        for(int i=0;i<datos.size();i++)
        {
        	if(datos.get(i).getGrado().equals(grado))
        		datosMostrar.add(datos.get(i));
        }

        list= (ListView)findViewById(R.id.list);
        adapter=new miAdapter(this,R.layout.asignaturas_item,datosMostrar);
        list.setAdapter(adapter);
        btDescargar=(Button)findViewById(R.id.btDescargar);
	    btDescargar.setOnClickListener(new OnClickListener()
	    {
			  public void onClick(View view)
			  {
				 CrearPDF crearpdf= new CrearPDF(datos);				 
				 Toast toast = Toast.makeText(getApplicationContext(), "Descargando...", Toast.LENGTH_SHORT);
				 toast.show();
				 crearpdf.descargarPDFAsignaturas();
				 String ns = Context.NOTIFICATION_SERVICE;
				 NotificationManager notManager =  (NotificationManager) getSystemService(ns);
				 int icono = android.R.drawable.stat_sys_download;		 
				 
				 CharSequence textoEstado = "Descargado!";
				 long hora = System.currentTimeMillis();				  
				 Notification notif =  new Notification(icono, textoEstado, hora);
				 Context contexto = getApplicationContext();
				 CharSequence titulo = "Carga completa";
				 CharSequence descripcion = "Archivo descargado correctamente";
				  
				 Intent notIntent = new Intent(contexto, VerPDFAsignaturasActivity.class);
				 notIntent.putExtra("fichero","Asignaturas.pdf");
				 PendingIntent contIntent = PendingIntent.getActivity(contexto, 0, notIntent, 0);
				  
				 notif.setLatestEventInfo(contexto, titulo, descripcion, contIntent);
				 notif.flags |= Notification.FLAG_AUTO_CANCEL;				 
				 notManager.notify(3, notif);				 
				 
   	             	         
			  }
		  });
        
    }
    
    public void onStart()
    {
    	super.onStart();
    	crearDatos();
    }
    
    public void crearDatos()
    {

    	Asignatura a1=new Asignatura("Grado Administracion de empresas","Informática Movil",6,"Eloy Mata","http://Informaticamovil");
    	Asignatura a2=new Asignatura("Grado Informática","Instalaciones de Computadores",6,"Javier","http://Instalacion");
    	Asignatura a3=new Asignatura("Grado Matematicas","Arquitectura de computadores",6,"Ivan","http://Arquitectura");
    	Asignatura a4=new Asignatura("Grado Informática","Estructuras de computadores",6,"Ivan","http://Estructuras");
        datos.add(a1);
        datos.add(a2);
        datos.add(a3);
        datos.add(a4);
    }
    
    class miAdapter extends ArrayAdapter<Asignatura>  {

  		private final ArrayList<Asignatura> datos;

  		public miAdapter (Context context,int textViewResourceId, ArrayList<Asignatura> items)
  		{
  			   super(context,textViewResourceId, items);
  			   this.datos=items;
  		}
  		
  		public View getView(final int position, View convertView, final ViewGroup parent) {
  			   View row = null;
  			   
  			   if (convertView != null) 
  				   row = convertView;
  			   LayoutInflater inflater = getLayoutInflater();
  			   final Asignatura listDato = datos.get(position);
  			 
  			   if (row == null || row.getId() != R.layout.asignaturas_item)
  				   row = inflater.inflate(R.layout.asignaturas_item, parent, false);
  			
  			  TextView data1 = (TextView)row.findViewById(R.id.nombre);
  			  TextView data2 = (TextView)row.findViewById(R.id.creditos);
  			  TextView data3 = (TextView)row.findViewById(R.id.profesor);
  			  TextView data4 = (TextView)row.findViewById(R.id.guia);
  			 
  			  data1.setText(listDato.getNombre());
  			  data2.setText(String.valueOf(listDato.getCreditos()));
  			  data3.setText(listDato.getProfesor());
  			  data4.setText(listDato.getGuia());

  			 return row;
  		 
  		}
  	}
    
}
