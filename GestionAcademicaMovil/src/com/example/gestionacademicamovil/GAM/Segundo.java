package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;

import com.example.gestionacademicamovil.GAM.AsignaturasActivity1.miAdapter;
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
import android.content.res.Resources;
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
	private String grado;
	private TextView usuario,texto;
	private  Bundle bundle;
	private Button btDescargar;
	private Resources mResources;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuatrimestres);
        
        mResources = getResources();
        
        bundle=getIntent().getExtras();
        
        grado=GAMApplication.getInstance().getPreferencesManager().getGrado();
        
        crearDatos();
        for(int i=0;i<datos.size();i++)
        {
        	if(datos.get(i).getCuatrimestre()==2 && datos.get(i).getGrado().equals(grado))
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
    	
    	final CharSequence[] items = {mResources.getString(R.string.segundo), mResources.getString(R.string.todas)};
        
    	 
       AlertDialog.Builder builder = new AlertDialog.Builder(this);
       builder.setTitle(mResources.getString(R.string.descarganot));
	    builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() 
	    {
	        public void onClick(DialogInterface dialog, int item) 
	        {
	        	Intent i = new Intent();
	        	if(item==0)
	        	{
	        		descargarPDF(mResources.getString(R.string.segundo));
	        	}
	        	else
	        	{
	        		descargarPDF(mResources.getString(R.string.todas));
	        	}
    	        dialog.cancel();
	        }
    	    });
    	 
    	   builder.create().show();    	
    }
    public void descargarPDF(String opcion)
    {
    	 CrearPDF crearpdf;
    	 if(opcion.equals(mResources.getString(R.string.segundo)))
    	 {
    	   crearpdf= new CrearPDF(datosMostrar);	
    	 }
    	 else
    	 {
    	   crearpdf= new CrearPDF(datos);		
    	 }
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
        	Nota n1=new Nota(1,"Electrotecnia, m�quinas y motores","Grado en Ingenier�a agricola",6,7,"Si","");
        	Nota n2=new Nota(1,"Producci�n vegetal","Grado en Ingenier�a agricola",6,8.5,"Si","");
        	Nota n3=new Nota(1,"Espresi�n gr�fica","Grado en Ingenier�a agricola",6,6,"Si","");
        	Nota n4=new Nota(1,"Hidr�ulica","Grado en Ingenier�a agricola",6,7.5,"Si","");
        	Nota n5=new Nota(1,"Tecnolog�a de alimentos","Grado en Ingenier�a agricola",6,5.2,"No","desp 350 06/05/2013");
        	Nota n6=new Nota(2,"Inform�tica","Grado en Ingenier�a agricola",6,7,"Si","");
        	Nota n7=new Nota(2,"Bot�nica","Grado en Ingenier�a agricola",6,6.3,"Si","");
        	Nota n8=new Nota(2,"Topograf�a, cartograf�a y SIG","Grado en Ingenier�a agricola",6,8.5,"Si","");
        	Nota n9=new Nota(2,"Cultivos","Grado en Ingenier�a agricola",6,5.5,"Si","");
        	Nota n10=new Nota(2,"Paisajismo","Grado en Ingenier�a agricola",6,9,"No","desp 350 16/05/2013");
        	
        	Nota i1=new Nota(1,"Tecnolog�a orientada a objetos","Grado en Ingenier�a Inform�tica",6,7,"Si","");
        	Nota i2=new Nota(1,"Sistemas distribuidos","Grado en Ingenier�a Inform�tica",6,8.5,"Si","");
        	Nota i3=new Nota(1,"Administracion de redes y servidores","Grado en Ingenier�a Inform�tica",6,6,"Si","");
        	Nota i4=new Nota(1,"Arquitectura de computadores","Grado en Ingenier�a Inform�tica",6,7.5,"Si","");
        	Nota i5=new Nota(1,"Dise�o tecnol�gico de sistemas de informaci�n","Grado en Ingenier�a Inform�tica",6,5.2,"No","desp 205 12/06/2013");
        	Nota i6=new Nota(2,"Procesadores de lenguajes","Grado en Ingenier�a Inform�tica",6,7,"Si","");
        	Nota i7=new Nota(2,"Proyectos de inform�tica","Grado en Ingenier�a Inform�tica",6,6.3,"Si","");
        	Nota i8=new Nota(2,"Programaci�n de aplicaciones Web","Grado en Ingenier�a Inform�tica",6,8.5,"Si","");
        	Nota i9=new Nota(2,"Inteligencia artificial","Grado en Ingenier�a Inform�tica",6,5.5,"Si","");
        	Nota i10=new Nota(2,"Taller transversal I","Grado en Ingenier�a Inform�tica",6,9,"No","desp 310 13/05/2013");
        	
        	Nota m1=new Nota(1,"Estructuras algebraicas","Grado en Matematicas",6,0,"","");
        	Nota m2=new Nota(1,"Modelos de regresi�n","Grado en Matematicas",6,0,"","");
        	Nota m3=new Nota(1,"M�todos num�ricos","Grado en Matematicas",6,6,"","");
        	Nota m4=new Nota(1,"Ecuaciones diferenciales","Grado en Matematicas",6,0,"","");
        	Nota m5=new Nota(1,"Modelizaci�n y optimizaci�n I","Grado en Matematicas",6,0,"","");
        	Nota m6=new Nota(2,"Teoria de Galois","Grado en Matematicas",6,0,"","");
        	Nota m7=new Nota(2,"Modelizaci�n y optimizaci�n II","Grado en Matematicas",6,0,"","");
        	Nota m8=new Nota(2,"M�todos num�ricos en ecuaciones diferenciales","Grado en Matematicas",6,0,"","");
        	Nota m9=new Nota(2,"Topolog�a general","Grado en Matematicas",6,0,"","");
        	Nota m10=new Nota(2,"An�lisis complejo","Grado en Matematicas",6,0,"","");
        	
        	
            datos.add(n1);
            datos.add(n2);
            datos.add(n3);
            datos.add(n4);
            datos.add(n5);
            datos.add(n6);
            datos.add(n7);
            datos.add(n8);
            datos.add(n9);
            datos.add(n10);
            
            datos.add(i1);
            datos.add(i2);
            datos.add(i3);
            datos.add(i4);
            datos.add(i5);
            datos.add(i6);
            datos.add(i7);
            datos.add(i8);
            datos.add(i9);
            datos.add(i10);
            
            datos.add(m1);
            datos.add(m2);
            datos.add(m3);
            datos.add(m4);
            datos.add(m5);
            datos.add(m6);
            datos.add(m7);
            datos.add(m8);
            datos.add(m9);
            datos.add(m10);
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
 			  data4.setText(listDato.isDefinitiva());
 			  data5.setText(listDato.getRevision());

 			  return row;
  		 
  		}
  	}

    
}
