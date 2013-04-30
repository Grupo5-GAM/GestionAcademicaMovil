package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;

import com.example.gestionacademicamovil.GAM.managers.CrearPDF;
import com.example.gestionacademicamovil.GAM.model.Asignatura;
import com.example.gestionacademicamovil.GAM.model.Beca;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class BecasActivity extends Activity 
{
	private ListView list;
	
	private Bundle bundle;
	private TextView usuario;
	
	private miAdapter adapter;
	private Button btDescargar;
	
	private ArrayList<Beca> datos=new ArrayList<Beca>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
         setContentView(R.layout.becas);
        
		 bundle=getIntent().getExtras();
		 
		 crearDatos();
	        
	     usuario=(TextView)findViewById(R.id.usuario);
	     usuario.setText(GAMApplication.getInstance().getPreferencesManager().getName());
	        
	     list= (ListView)findViewById(R.id.list);
	     adapter=new miAdapter(this,R.layout.becas_item,datos);
	     list.setAdapter(adapter);
	     btDescargar=(Button)findViewById(R.id.btDescargar);
	     if(datos.size()==0)
	     {
	    	 GAMApplication.getInstance().showToast("No hay datos");	//Colocar un dialogalert		 
			 btDescargar.setEnabled(false);
			 BecasActivity.this.finish();
	     }
	     btDescargar.setOnClickListener(new OnClickListener()
	     {
			  @SuppressWarnings("deprecation")
			public void onClick(View view)
			  {
				 CrearPDF crearpdf= new CrearPDF(datos);				 
				 GAMApplication.getInstance().showToast("Descargando...");
				 crearpdf.descargarPDFBecas();
				 String ns1 = Context.NOTIFICATION_SERVICE;
				 NotificationManager notManager =  (NotificationManager) getSystemService(ns1);
				 int icono = android.R.drawable.stat_sys_download;		 
				 
				 CharSequence textoEstado = "Descargado!";
				 long hora = System.currentTimeMillis();				  
				 Notification notif1 =  new Notification(icono, textoEstado, hora);
				 Context contexto1 = getApplicationContext();
				 CharSequence titulo1 = "Carga completa";
				 CharSequence descripcion1 = "Archivo descargado correctamente";
				  
				 Intent notIntent1 = null; 
				 notIntent1= new Intent(contexto1, VerPDFBecasActivity.class);
				 notIntent1.putExtra("fichero","Becas.pdf");
				 PendingIntent contIntent1 = PendingIntent.getActivity(contexto1, 0, notIntent1, 0);
				  
				 notif1.setLatestEventInfo(contexto1, titulo1, descripcion1, contIntent1);
				 notif1.flags |= Notification.FLAG_AUTO_CANCEL;				 
				 notManager.notify(2, notif1);				 
				 
    	             	         
			  }
		  });
	}
	
	public void onStart()
    {
    	super.onStart();
    	
    }
	
	public void crearDatos()
    {

    	Beca a1=new Beca("Movilidad","Abierta");
    	Beca a2=new Beca("Colaboración","Cerrada");
    	Beca a3=new Beca("Transporte","Abierta");
        datos.add(a1);
        datos.add(a2);
        datos.add(a3);
    }
	
	class miAdapter extends ArrayAdapter<Beca>  {

		private final ArrayList<Beca> datos;

		public miAdapter (Context context,int textViewResourceId, ArrayList<Beca> items)
		{
			   super(context,textViewResourceId, items);
			   this.datos=items;
		}
		
		public View getView(final int position, View convertView, final ViewGroup parent) {
			   View row = null;
			   
			   if (convertView != null) 
				   row = convertView;
			   LayoutInflater inflater = getLayoutInflater();
			   final Beca listDato = datos.get(position);
			 
			   if (row == null || row.getId() != R.layout.becas_item)
				   row = inflater.inflate(R.layout.becas_item, parent, false);
			
			  TextView data1 = (TextView)row.findViewById(R.id.tipo);
			  TextView data2 = (TextView)row.findViewById(R.id.estado);
			 
			  data1.setText(listDato.getTipo());
			  data2.setText(String.valueOf(listDato.getEstado()));

			 return row;
		 
		}	
	}
	
	
	
}
