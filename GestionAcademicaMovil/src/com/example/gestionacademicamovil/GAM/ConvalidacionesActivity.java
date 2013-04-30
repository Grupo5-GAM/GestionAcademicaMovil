package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;

import com.example.gestionacademicamovil.GAM.managers.CrearPDF;
import com.example.gestionacademicamovil.GAM.model.Asignatura;
import com.example.gestionacademicamovil.GAM.model.Convalidacion;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ConvalidacionesActivity  extends Activity 
{
private ListView list;
	
	private Bundle bundle;
	private String grado;
	private TextView usuario;
	
	private miAdapter adapter;
	private Button btDescargar;
	
	private ArrayList<Convalidacion> datos=new ArrayList<Convalidacion>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.convalidaciones);
		
        bundle=getIntent().getExtras();
        crearDatos();
	        
	     usuario=(TextView)findViewById(R.id.usuario);
	     usuario.setText(GAMApplication.getInstance().getPreferencesManager().getName());
	        
	     list= (ListView)findViewById(R.id.list);
	     adapter=new miAdapter(this,R.layout.convalidacion_item,datos);
	     list.setAdapter(adapter);
	     btDescargar=(Button)findViewById(R.id.btDescargar);
	     if(datos.size()==0)
	     {
	    	 GAMApplication.getInstance().showToast("No hay datos");	//Colocar un dialogalert		 
			 btDescargar.setEnabled(false);
			 ConvalidacionesActivity.this.finish();
	     }
	     btDescargar.setOnClickListener(new OnClickListener(){
			  public void onClick(View view)
			  {
				 CrearPDF crearpdf= new CrearPDF(datos);				 
				 GAMApplication.getInstance().showToast("Descargando...");
				 crearpdf.descargarPDFConvalidaciones();
				 String ns = Context.NOTIFICATION_SERVICE;
				 NotificationManager notManager =  (NotificationManager) getSystemService(ns);
				 int icono = android.R.drawable.stat_sys_download;		 
				 
				 CharSequence textoEstado = "Descargado!";
				 long hora = System.currentTimeMillis();				  
				 Notification notif =  new Notification(icono, textoEstado, hora);
				 Context contexto = getApplicationContext();
				 CharSequence titulo = "Carga completa";
				 CharSequence descripcion = "Archivo descargado correctamente";
				  
				 Intent notIntent = new Intent(contexto, VerPDFConvalidacionesActivity.class);
				 notIntent.putExtra("fichero","Convalidaciones.pdf");
				 PendingIntent contIntent = PendingIntent.getActivity(contexto, 0, notIntent, 0);
				  
				 notif.setLatestEventInfo(contexto, titulo, descripcion, contIntent);
				 notif.flags |= Notification.FLAG_AUTO_CANCEL;				 
				 notManager.notify(6, notif);				 
				 
    	             	         
			  }
		  });
	}
	
	public void onStart()
    {
    	super.onStart();
    	
    }
	
	private void crearDatos()
	{
    	Convalidacion a1=new Convalidacion("Informatica Movil","Informatica Movil",6,"Optativa",9.0);
    	Convalidacion a2=new Convalidacion("Instalación y Mantenimiento de computadores","Instalación y Mantenimiento de computadores",6,"Optativa",9.0);
    	Convalidacion a3=new Convalidacion("Estructura de Computadores","Arquitectura de computadores",6,"Obligatoria",8.0);
    	Convalidacion a4=new Convalidacion("Arquitectura de Computadores","Arquitectura de computadores",6,"Obligatoria",8.0);
        datos.add(a1);
        datos.add(a2);
        datos.add(a3);
        datos.add(a4);
	}
	
	class miAdapter extends ArrayAdapter<Convalidacion>  {

		private final ArrayList<Convalidacion> datos;

		public miAdapter (Context context,int textViewResourceId, ArrayList<Convalidacion> items)
		{
			   super(context,textViewResourceId, items);
			   this.datos=items;
		}
		
		public View getView(final int position, View convertView, final ViewGroup parent) {
			   View row = null;
			   
			   if (convertView != null) 
				   row = convertView;
			   LayoutInflater inflater = getLayoutInflater();
			   final Convalidacion listDato = datos.get(position);
			 
			   if (row == null || row.getId() != R.layout.convalidacion_item)
				   row = inflater.inflate(R.layout.convalidacion_item, parent, false);
			
			  TextView data1 = (TextView)row.findViewById(R.id.asignatura);
			  TextView data2 = (TextView)row.findViewById(R.id.asignaturaAntigua);
			  TextView data3 = (TextView)row.findViewById(R.id.creditos);
			  TextView data4 = (TextView)row.findViewById(R.id.tipo);
			  TextView data5 = (TextView)row.findViewById(R.id.nota);
			 
			  data1.setText(listDato.getAsignatura());
			  data2.setText(listDato.getAsignaturaAntigua());
			  data3.setText(String.valueOf(listDato.getCreditos()));
			  data4.setText(listDato.getTipo());
			  data5.setText(String.valueOf(listDato.getNota()));

			 return row;
		 
		}
	}
	
	
}
	