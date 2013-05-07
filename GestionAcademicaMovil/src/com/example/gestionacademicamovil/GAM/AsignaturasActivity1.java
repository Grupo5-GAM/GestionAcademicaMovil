package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;
import java.util.List;

import com.example.gestionacademicamovil.GAM.managers.CrearPDF;
import com.example.gestionacademicamovil.GAM.model.Asignatura;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
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
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AsignaturasActivity1 extends Activity {
	
	private ListView list;
	
	private Bundle bundle;
	private String grado;
	private TextView usuario;
	
	private Resources mResources;
	
	private miAdapter adapter;
	private Button btDescargar;
	
	private ArrayList<Asignatura> datos=new ArrayList<Asignatura>();
	private ArrayList<Asignatura> datosMostrar=new ArrayList<Asignatura>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.asignaturas);
        
        mResources = getResources();
        
        bundle=getIntent().getExtras();
        //grado=bundle.getString("grado");
        grado=GAMApplication.getInstance().getPreferencesManager().getGrado();
        crearDatos();
        
        for(int i=0;i<datos.size();i++)
        {
        	//GAMApplication.getInstance().showToast(datos.get(i).getGrado() + datos.get(i).getCuatrimestre());
        	if(datos.get(i).getGrado().equals(grado) && datos.get(i).getCuatrimestre()==1)
        		datosMostrar.add(datos.get(i));
        }
        //GAMApplication.getInstance().showToast(datos.size()+"");
        

        list= (ListView)findViewById(R.id.list);
        adapter=new miAdapter(this,R.layout.asignaturas_item,datosMostrar);
        list.setAdapter(adapter);
        btDescargar=(Button)findViewById(R.id.btDescargar);
	    btDescargar.setOnClickListener(new OnClickListener()
	    {
			  public void onClick(View view)
			  {
				  seleccion();	         
			  }
		  });
        
    }
    
    private void descargarPDF(String opcion)
    {
    	CrearPDF crearpdf;
   	    if(opcion.equals(mResources.getString(R.string.primero)))
   	    {
   	    	crearpdf= new CrearPDF(datosMostrar);	
   	    }
   	    else
   	    {
   	    	crearpdf= new CrearPDF(datos);		
   	    }
			 
		 GAMApplication.getInstance().showToast(mResources.getString(R.string.descargando));
		 crearpdf.descargarPDFAsignaturas();
		 String ns = Context.NOTIFICATION_SERVICE;
		 NotificationManager notManager =  (NotificationManager) getSystemService(ns);
		 int icono = android.R.drawable.stat_sys_download;		 
		 
		 CharSequence textoEstado =mResources.getString(R.string.descargado);
		 long hora = System.currentTimeMillis();				  
		 Notification notif =  new Notification(icono, textoEstado, hora);
		 Context contexto = getApplicationContext();
		 CharSequence titulo = mResources.getString(R.string.cargacompleta);
		 CharSequence descripcion = mResources.getString(R.string.archdescargado);
		  
		 Intent notIntent = new Intent(contexto, VerPDFAsignaturasActivity.class);
		 notIntent.putExtra("fichero","Asignaturas.pdf");
		 PendingIntent contIntent = PendingIntent.getActivity(contexto, 0, notIntent, 0);
		  
		 notif.setLatestEventInfo(contexto, titulo, descripcion, contIntent);
		 notif.flags |= Notification.FLAG_AUTO_CANCEL;				 
		 notManager.notify(3, notif);	
    }
    
    private void seleccion()
    {
    	
       final CharSequence[] items = {mResources.getString(R.string.primero), mResources.getString(R.string.todas)};
       
    	 
       AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	 
            builder.setTitle(mResources.getString(R.string.descargasig));
    	    builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() 
    	    {
    	        public void onClick(DialogInterface dialog, int item) 
    	        {
    	        	Intent i = new Intent();
    	        	if(item==0)
            		{
            			descargarPDF(mResources.getString(R.string.primero));
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
    
    public void onStart()
    {
    	super.onStart();
    	crearDatos();
    }
    
    public void crearDatos()
    {
    	Asignatura a1=new Asignatura("Grado en Ingeniería agricola","Electrotecnia, máquinas y motores",6,"Juan José Barrios","http://EMM",1);
    	Asignatura a2=new Asignatura("Grado en Ingeniería agricola","Producción vegetal",6,"Vicente Marco","http://PV",1);
    	Asignatura a3=new Asignatura("Grado en Ingeniería agricola","Espresión gráfica",6,"Félix Sanz","http://EG",1);
    	Asignatura a4=new Asignatura("Grado en Ingeniería agricola","Hidráulica",6,"Jose Miguel Peña","http://I",1);
    	Asignatura a5=new Asignatura("Grado en Ingeniería agricola","Tecnología de alimentos",6,"Maria Elena González","http://TA",1);
    	Asignatura a6=new Asignatura("Grado en Ingeniería agricola","Informática",6,"Jesus Aransay","http://I",2);
    	Asignatura a7=new Asignatura("Grado en Ingeniería agricola","Botánica",6,"Javier Marínez","http://B",2);
    	Asignatura a8=new Asignatura("Grado en Ingeniería agricola","Topografía, cartografía y SIG",6,"Jacinto Santa María","http://TC",2);
    	Asignatura a9=new Asignatura("Grado en Ingeniería agricola","Cultivos",6,"Maria Elena Matínez","http://C",2);
    	Asignatura a10=new Asignatura("Grado en Ingeniería agricola","Paisajismo I",6,"Eduardo Prado","http://P",2);
    	
    	Asignatura b1=new Asignatura("Grado en Ingeniería Informática","Tecnología orientada a objetos",6,"Maria Vico Pascual","http://TOO",1);
    	Asignatura b2=new Asignatura("Grado en Ingeniería Informática","Sistemas distribuidos",6,"Francisco Izquierdo","http://SD",1);
    	Asignatura b3=new Asignatura("Grado en Ingeniería Informática","Administración de redes y servidores",6,"Carlos Elvira","http://ARYS",1);
    	Asignatura b4=new Asignatura("Grado en Ingeniería Informática","Arquitectura de computadores",6,"Ivan Pérez","http://AC",1);
    	Asignatura b5=new Asignatura("Grado en Ingeniería Informática","Diseño tecnológico de sistemas de información",6,"Angel Luis Rubio","http://DTSI",1);
    	Asignatura b6=new Asignatura("Grado en Ingeniería Informática","Procesadores de lenguajes",6,"Laureano Lamban","http://PL",2);
    	Asignatura b7=new Asignatura("Grado en Ingeniería Informática","Proyectos de informática",6,"Arturo Elizondo","http://PI",2);
    	Asignatura b8=new Asignatura("Grado en Ingeniería Informática","Programación de aplicaciones Web",6,"Francisco Izquierdo","http://PAW",2);
    	Asignatura b9=new Asignatura("Grado en Ingeniería Informática","Inteligencia artificial",6,"Julio Rubio","http://IA",2);
    	Asignatura b10=new Asignatura("Grado en Ingeniería Informática","Taller transversal I",6,"Juan Felix San Juan","http://TT",2);
    	
    	Asignatura c1=new Asignatura("Grado en Matematicas","Estructuras algebraicas",6,"Jose Maria Pérez","http://EA",1);
    	Asignatura c2=new Asignatura("Grado en Matematicas","Modelos de regresión",6,"Juan Carlos Fillat","http://MR",1);
    	Asignatura c3=new Asignatura("Grado en Matematicas","Métodos numéricos",6,"Miguel Ángel Hernández","http://MN",1);
    	Asignatura c4=new Asignatura("Grado en Matematicas","Ecuaciones diferenciales",6,"Oscar Ciaurri","http://ED",1);
    	Asignatura c5=new Asignatura("Grado en Matematicas","Modelización y optimización I",6,"Francisco Javier Pérez","http://MOI",1);
    	Asignatura c6=new Asignatura("Grado en Matematicas","Teoría de Galois",6,"Jesus Laliena","http://TG",2);
    	Asignatura c7=new Asignatura("Grado en Matematicas","Modelización y optimización II",6,"Jose Manuel Gutierrez","http://MOII",2);
    	Asignatura c8=new Asignatura("Grado en Matematicas","Métodos numéricos en ecuaciones diferenciales",6,"Victor Lanchares","http://MN",2);
    	Asignatura c9=new Asignatura("Grado en Matematicas","Topología general",6,"Maria Teresa Rivas","http://TG",2);
    	Asignatura c10=new Asignatura("Grado en Matematicas","Análisis complejo",6,"Jose Luis Arregui","http://AC",2);
        
    	datos.add(a1);
        datos.add(a2);
        datos.add(a3);
        datos.add(a4);
        datos.add(a5);
        datos.add(a6);
        datos.add(a7);
        datos.add(a8);
        datos.add(a9);
        datos.add(a10);
        datos.add(b1);
        datos.add(b2);
        datos.add(b3);
        datos.add(b4);
        datos.add(b5);
        datos.add(b6);
        datos.add(b7);
        datos.add(b8);
        datos.add(b9);
        datos.add(b10);
        datos.add(c1);
        datos.add(c2);
        datos.add(c3);
        datos.add(c4);
        datos.add(c5);
        datos.add(c6);
        datos.add(c7);
        datos.add(c8);
        datos.add(c9);
        datos.add(c10);
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
  			  //TextView data4 = (TextView)row.findViewById(R.id.grado);
  			 
  			  data1.setText(listDato.getNombre());
  			  data2.setText(String.valueOf(listDato.getCreditos()));
  			  data3.setText(listDato.getProfesor());
  			  //data4.setText(listDato.getGrado());

  			 return row;
  		 
  		}
  	}
    
}
