package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;

import com.example.gestionacademicamovil.GAM.managers.CrearPDF;
import com.example.gestionacademicamovil.GAM.model.Asignatura;
import com.example.gestionacademicamovil.GAM.model.Traslado;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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

public class TrasladosActivity extends Activity 
{
	private ListView list;
	
	private Bundle bundle;
	private TextView usuario;
	
	private miAdapter adapter;
	private Button btDescargar;
	
	private Resources mResources;
	
	private ArrayList<Traslado> datos=new ArrayList<Traslado>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
         setContentView(R.layout.traslados);
         
         mResources = getResources();
        
		 bundle=getIntent().getExtras();
		 crearDatos();
	        
	     usuario=(TextView)findViewById(R.id.usuario);
	     usuario.setText(GAMApplication.getInstance().getPreferencesManager().getName());
	        
	     list= (ListView)findViewById(R.id.list);
	     adapter=new miAdapter(this,R.layout.traslados_item,datos);
	     list.setAdapter(adapter);
	     btDescargar=(Button)findViewById(R.id.btDescargar);
	     if(datos.size()==0)
	     {
	    	 GAMApplication.getInstance().showToast(mResources.getString(R.string.nohaydatos));	//Colocar un dialogalert		 
			 btDescargar.setEnabled(false);
			 TrasladosActivity.this.finish();
	     }
	     btDescargar.setOnClickListener(new OnClickListener(){
			  @SuppressWarnings("deprecation")
			public void onClick(View view)
			  {
				 CrearPDF crearpdf= new CrearPDF(datos);				 
				 GAMApplication.getInstance().showToast(mResources.getString(R.string.descargando));
				 crearpdf.descargarPDFNotas();
				 String ns = Context.NOTIFICATION_SERVICE;
				 NotificationManager notManager =  (NotificationManager) getSystemService(ns);
				 int icono = android.R.drawable.stat_sys_download;		 
				 
				 CharSequence textoEstado = mResources.getString(R.string.descargado);
				 long hora = System.currentTimeMillis();				  
				 Notification notif =  new Notification(icono, textoEstado, hora);
				 Context contexto = getApplicationContext();
				 CharSequence titulo = mResources.getString(R.string.cargacompleta);
				 CharSequence descripcion = mResources.getString(R.string.archdescargado);
				  
				 Intent notIntent = null;
				 notIntent=new Intent(contexto, VerPDFTrasladosActivity.class);
				 notIntent.putExtra("fichero","Traslados.pdf");
				 PendingIntent contIntent = PendingIntent.getActivity(contexto, 0, notIntent, 0);
				  
				 notif.setLatestEventInfo(contexto, titulo, descripcion, contIntent);
				 notif.flags |= Notification.FLAG_AUTO_CANCEL;				 
				 notManager.notify(1, notif);
				
				 
    	             	         
			  }
		  });
	}
	
	public void onStart()
    {
    	super.onStart();
    	
    }
	
	private void crearDatos()
	{

    	/*Traslado a1=new Traslado("Universidad de Madrid","Madrid","España");
    	Traslado a2=new Traslado("Universidad de Bilbao","Bilbao","España");
        datos.add(a1);
        datos.add(a2);*/
	}
	
	class miAdapter extends ArrayAdapter<Traslado>  {

		private final ArrayList<Traslado> datos;

		public miAdapter (Context context,int textViewResourceId, ArrayList<Traslado> items)
		{
			   super(context,textViewResourceId, items);
			   this.datos=items;
		}
		
		public View getView(final int position, View convertView, final ViewGroup parent) {
			   View row = null;
			   
			   if (convertView != null) 
				   row = convertView;
			   LayoutInflater inflater = getLayoutInflater();
			   final Traslado listDato = datos.get(position);
			 
			   if (row == null || row.getId() != R.layout.traslados_item)
				   row = inflater.inflate(R.layout.traslados_item, parent, false);
			
			  TextView data1 = (TextView)row.findViewById(R.id.universidad);
			  TextView data2 = (TextView)row.findViewById(R.id.ciudad);
			  TextView data3 = (TextView)row.findViewById(R.id.pais);
			 
			  data1.setText(listDato.getUniversidad());
			  data2.setText(listDato.getCiudad());
			  data3.setText(listDato.getPais());
			  
			 return row;
		 
		}
	}	
	
	
}

