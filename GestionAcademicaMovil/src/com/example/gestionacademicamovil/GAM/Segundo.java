package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;

import com.example.gestionacademicamovil.GAM.AsignaturasActivity.miAdapter;
import com.example.gestionacademicamovil.GAM.managers.CrearPDF;
import com.example.gestionacademicamovil.GAM.model.Asignatura;
import com.example.gestionacademicamovil.GAM.model.Nota;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Segundo extends Activity 
{
	
	private ListView list;
	private miAdapter adapter;
	
	private ArrayList<Nota> datos=new ArrayList<Nota>();
	private ArrayList<Nota> datosMostrar=new ArrayList<Nota>();
	
	private TextView usuario,texto;
	private  Bundle bundle;
	private Button btDescargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuatrimestres);
        
        bundle=getIntent().getExtras();
        
        crearDatos();
        for(int i=0;i<datos.size();i++)
        {
        	if(datos.get(i).getCuatrimestre()==2)
        		datosMostrar.add(datos.get(i));
        }
        
        list= (ListView)findViewById(R.id.list);
        adapter=new miAdapter(this,R.layout.cuatrimestres_item,datosMostrar);
        list.setAdapter(adapter);
        btDescargar=(Button)findViewById(R.id.btDescargar);
	    btDescargar.setOnClickListener(new OnClickListener(){
			  public void onClick(View view)
			  {
				 seleccion();			 
   	             	         
			  }
		  });
        
    }
    private void seleccion()
    {
    	
       final CharSequence[] items = {"Segundo", "Todas"};
       
    	 
       AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	 
            builder.setTitle("Descargar notas de:");
    	    builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() 
    	    {
    	        public void onClick(DialogInterface dialog, int item) 
    	        {
    	        	Intent i = new Intent();
    	        	if(item==0)
            		{
            			descargarPDF("Segundo");
            		}
    	        	else
    	        	{
    	        		descargarPDF("Todas");
    	        	}
    	        	
    	        	dialog.cancel();
    	        }   	        
    	        
    	    });
    	 
    	   builder.create().show();    	
    }
    public void descargarPDF(String opcion)
    {
    	CrearPDF crearpdf;
    	if(opcion.equals("Segundo"))
    	{
    	  crearpdf= new CrearPDF(datosMostrar);	
    	}
    	else
    	{
    	  crearpdf= new CrearPDF(datos);		
    	}
		 Toast toast = Toast.makeText(getApplicationContext(), "Descargando...", Toast.LENGTH_SHORT);
		 toast.show();
		 crearpdf.descargarPDFNotas();
		 String ns = Context.NOTIFICATION_SERVICE;
		 NotificationManager notManager =  (NotificationManager) getSystemService(ns);
		 int icono = android.R.drawable.stat_sys_download;		 
		 
		 CharSequence textoEstado = "Descargado!";
		 long hora = System.currentTimeMillis();				  
		 Notification notif =  new Notification(icono, textoEstado, hora);
		 Context contexto = getApplicationContext();
		 CharSequence titulo = "Carga completa";
		 CharSequence descripcion = "Archivo descargado correctamente";
		  
		 Intent notIntent = new Intent(contexto, VerPDFNotasActivity.class);
		 notIntent.putExtra("fichero","Notas.pdf");
		 PendingIntent contIntent = PendingIntent.getActivity(contexto, 0, notIntent, 0);
		  
		 notif.setLatestEventInfo(contexto, titulo, descripcion, contIntent);
		 notif.flags |= Notification.FLAG_AUTO_CANCEL;				 
		 notManager.notify(5, notif);
    }
    
    public void onStart()
    {
    	super.onStart();
    }
    
    public void crearDatos()
    {
    	Nota n1=new Nota(1,"Taller Transversal II",6,8.5,true,"desp 350 12/05/2013");
    	Nota n2=new Nota(2,"Profesión del ingeniero informático",6,8.5,true,"desp 350 12/05/2013");
    	Nota n3=new Nota(2,"Seguridad",6,8.5,true,"desp 350 12/05/2013");
    	Nota n4=new Nota(1,"Practicas Externas I",6,8.5,true,"desp 350 12/05/2013");
    	Nota n5=new Nota(1,"Practicas Externas II",6,8.5,true,"desp 350 12/05/2013");
        datos.add(n1);
        datos.add(n2);
        datos.add(n3);
        datos.add(n4);
        datos.add(n5);
    }
    
    class miAdapter extends ArrayAdapter<Nota>  {

  		private final ArrayList<Nota> datos;

  		public miAdapter (Context context,int textViewResourceId, ArrayList<Nota> items)
  		{
  			   super(context,textViewResourceId, items);
  			   this.datos=items;
  		}
  		
  		public View getView(final int position, View convertView, final ViewGroup parent) {
  			   View row = null;
  			   
  			   if (convertView != null) 
  				   row = convertView;
  			   LayoutInflater inflater = getLayoutInflater();
  			   final Nota listDato = datos.get(position);
  			 
  			   if (row == null || row.getId() != R.layout.cuatrimestres_item)
  				   row = inflater.inflate(R.layout.cuatrimestres_item, parent, false);
  			
  			  TextView data1 = (TextView)row.findViewById(R.id.asignatura);
 			  TextView data2 = (TextView)row.findViewById(R.id.creditos);
 			  TextView data3 = (TextView)row.findViewById(R.id.nota);
 			  TextView data4 = (TextView)row.findViewById(R.id.definitiva);
 			  TextView data5 = (TextView)row.findViewById(R.id.revision);
 			 
 			  data1.setText(listDato.getAsignatura());
 			  data2.setText(String.valueOf(listDato.getCreditos()));
 			  data3.setText(String.valueOf(listDato.getNota()));
 			 if(listDato.isDefinitiva())
 				  data4.setText("Si");
 			  else
 				data4.setText("No");
 			  data4.setText(listDato.getRevision());

 			  return row;
  		 
  		}
  	}

    
}
