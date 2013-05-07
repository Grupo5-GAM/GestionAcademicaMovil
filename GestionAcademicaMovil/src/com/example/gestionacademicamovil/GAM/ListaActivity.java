package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;

import com.example.gestionacademicamovil.GAM.model.MenuPpal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaActivity extends Activity {
	
	private ListView list1;
	private TextView usuario;
	private Dialog dialog;
	private myAdapter myAdapter;
	private static final String googleDocsUrl = "http://docs.google.com/viewer?url=";
	private ArrayList<MenuPpal> datos= new ArrayList<MenuPpal>();
	
	private String grado;

	private Resources mResources;
	
	private  Bundle bundle;
	
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState); 
      requestWindowFeature(Window.FEATURE_NO_TITLE);
      setContentView(R.layout.list);
     
      mResources = getResources();
      
      bundle=getIntent().getExtras();
      
      grado=GAMApplication.getInstance().getPreferencesManager().getGrado();
      //GAMApplication.getInstance().showToast(grado);

      usuario=(TextView)findViewById(R.id.usuario);
      usuario.setText(GAMApplication.getInstance().getPreferencesManager().getName());
      
      list1= (ListView)findViewById(R.id.list1);
      myAdapter=new myAdapter(this,R.layout.list_item_ppal,datos);
      list1.setAdapter(myAdapter);
    
    }
    
    public void onStart()
    {
    	super.onStart();
    	anadirMenu();
    }
    
    public void anadirMenu()
    {
    	MenuPpal m1=new MenuPpal(mResources.getString(R.string.matricula),mResources.getString(R.string.desmatricula));
    	MenuPpal m2=new MenuPpal(mResources.getString(R.string.asignaturas),mResources.getString(R.string.desasignatura));
    	MenuPpal m3=new MenuPpal(mResources.getString(R.string.horarios),mResources.getString(R.string.deshorarios));
    	MenuPpal m4=new MenuPpal(mResources.getString(R.string.examenes),mResources.getString(R.string.desexamenes));
    	MenuPpal m5=new MenuPpal(mResources.getString(R.string.notas),mResources.getString(R.string.desnotas));
    	MenuPpal m6=new MenuPpal(mResources.getString(R.string.convalidaciones),mResources.getString(R.string.desconvalidaciones));
    	MenuPpal m7=new MenuPpal(mResources.getString(R.string.traslados),mResources.getString(R.string.destraslados));
    	MenuPpal m8=new MenuPpal(mResources.getString(R.string.becas),mResources.getString(R.string.desbecas));
    	MenuPpal m9=new MenuPpal(mResources.getString(R.string.aula),mResources.getString(R.string.desvirtual));
    	
    	datos.add(m1);
    	datos.add(m2);
    	datos.add(m3);
    	datos.add(m4);
    	datos.add(m5);
    	datos.add(m6);
    	datos.add(m7);
    	datos.add(m8);
    	datos.add(m9);
    }
    
    class myAdapter extends ArrayAdapter<MenuPpal>  {

  		private final ArrayList<MenuPpal> datos;

  		public myAdapter(Context context,int textViewResourceId, ArrayList<MenuPpal> items)
  		{
  			   super(context,textViewResourceId, items);
  			   this.datos=items;
  		}
  		
  		public View getView(final int position, View convertView, ViewGroup parent) {
  			   View row = null;
  			   
  			   if (convertView != null) 
  				   row = convertView;
  			   LayoutInflater inflater = getLayoutInflater();
  			   final MenuPpal listDato = datos.get(position);
  			 
  			   if (row == null || row.getId() != R.layout.list_item)
  				   row = inflater.inflate(R.layout.list_item, parent, false);
  			
  			   row.setOnClickListener(new OnClickListener() {
  				   public void onClick(View v) {
  					 Intent i = new Intent();
 			    	 if(position==0)
 			    	 {
 			    		i.setClass(ListaActivity.this, MatriculaActivity.class);
 			    		startActivity(i);
 			    	 }
 			    	 else if(position==1)
 			    	 {
 			    		i.setClass(ListaActivity.this, AsignaturasActivity.class);
 			    		startActivity(i);
 			    		//crearDialogoSeleccionGrado();
 			    	 }
 			    	 else if(position==2)
 			    	 {
 			    		i.setClass(ListaActivity.this, HorariosActivity.class);
 			    		startActivity(i);
 			    	 }
 			    	 else if(position==3)
 			    	 {
 			    		crearDialogoSeleccionMes();
 			    	 }
 			    	 else if(position==4)
 			    	 {
 			    		i.setClass(ListaActivity.this,NotasActivity.class);
 			    		startActivity(i);
 			    	 }
 			    	 else if(position==5)
 			    	 {
 			    		i.setClass(ListaActivity.this,ConvalidacionesActivity.class);
 			    		startActivity(i);
 			    	 }
 			    	 else if(position==6)
 			    	 {
 			    		i.setClass(ListaActivity.this,TrasladosActivity.class);
 			    		startActivity(i);
 			    	 }
 			    	 else if(position==7)
 			    	 {
 			    		i.setClass(ListaActivity.this,BecasActivity.class);
 			    		startActivity(i);
 			    	 }
 			    	 else
 			    	 {
 			    		i = new Intent("android.intent.action.VIEW", Uri.parse("https://unirioja.blackboard.com/webapps/login/"));
 			    	    startActivity(i);
 			    	 }
  			        }
  			   });
  			
  			 TextView data1 = (TextView)row.findViewById(R.id.text1);
  			 TextView data2 = (TextView)row.findViewById(R.id.text2);
  			 
 			 data1.setText(listDato.getText1());
 			 data2.setText(listDato.getText2());

  			 return row;
  		}
  	}

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	Intent i;
    	
    	switch (item.getItemId()) {
            case R.id.Ajustes:
            	i=new Intent(ListaActivity.this, AjustesActivity.class);
	        	startActivity(i);
	        	
                return true;
            case R.id.cambiarUsuario:
            	GAMApplication.getInstance().getPreferencesManager().setPassword(null);
            	GAMApplication.getInstance().getPreferencesManager().setUser(null);
            	i=new Intent(ListaActivity.this, Login.class);
	        	startActivity(i);
				finish();
				
                return true;
            case R.id.salir:
    			
            	new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(mResources.getString(R.string.salir))
                .setMessage(mResources.getString(R.string.seguro))
                .setPositiveButton(mResources.getString(R.string.si), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                    finish();
                             }
                })
                .setNegativeButton(mResources.getString(R.string.no), null)
                .show();
				
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
  	
    /*private void crearDialogoSeleccionGrado()
    {
    	final CharSequence[] items = {mResources.getString(R.string.gagr),mResources.getString(R.string.ginf),mResources.getString(R.string.gmat)};
    	 
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle(mResources.getString(R.string.));
    	builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
    	    public void onClick(DialogInterface dialog, int item) {
    	       // Toast toast = Toast.makeText(getApplicationContext(), "Has elegido la opcion: " + items[item] , Toast.LENGTH_SHORT);
    	       // toast.show();
    	        
    	        Intent i = new Intent();
    	        
    	        if(item==0)
        		{
        			i.setClass(ListaActivity.this, AsignaturasActivity1.class);
            		i.putExtra("grado","Grado en Ingeniería agricola");
        		}
        		else if(item==1)
        		{
        			i.setClass(ListaActivity.this,  AsignaturasActivity1.class);
        			i.putExtra("grado","Grado en Ingeniería Informática");
        		}
        		else
        		{
        			i.setClass(ListaActivity.this,  AsignaturasActivity1.class);
        			i.putExtra("grado","Grado en Matematicas");
        		}
    	        
    			startActivity(i);
    	        
    	        dialog.cancel();
    	    }
    	});
    	AlertDialog alert = builder.create();
    	alert.show();
    }*/
    
    private void crearDialogoSeleccionMes()
    {
    	final CharSequence[] items = {mResources.getString(R.string.enero),mResources.getString(R.string.mayo),mResources.getString(R.string.junio)};
    	 
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle(mResources.getString(R.string.selmes));
    	builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
    	    public void onClick(DialogInterface dialog, int item) {
    	       // Toast toast = Toast.makeText(getApplicationContext(), "Has elegido la opcion: " + items[item] , Toast.LENGTH_SHORT);
    	       // toast.show();
    	        
    	        Intent i = new Intent();
    	        
    	        if(item==0)
        		{
    	        	if(grado.equals(mResources.getString(R.string.ginf)))
    	        	{
    	        	
    	        	   i.setAction(android.content.Intent.ACTION_VIEW);
		    	       String url="http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_enero_801.pdf";
		    		   i.setDataAndType(Uri.parse(googleDocsUrl + url), "text/html");	
    	        		
    	        	  //i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_enero_801.pdf"));
    	        	}
		    		else if(grado.equals(mResources.getString(R.string.gagr)))
		    		{
		    			i.setAction(android.content.Intent.ACTION_VIEW);
			    	    String url="http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_enero_802.pdf";
			    		i.setDataAndType(Uri.parse(googleDocsUrl + url), "text/html");
			    		
		    			//i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_enero_802.pdf"));
		    		}
		    		else
		    		{
		    			i.setAction(android.content.Intent.ACTION_VIEW);
			    	    String url="http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_enero_mat.pdf";
			    		i.setDataAndType(Uri.parse(googleDocsUrl + url), "text/html");
		    			
		    			//i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_enero_mat.pdf"));
		    		}
		    		
		    	    startActivity(i);
        		}
        		else if(item==1)
        		{
        			if(grado.equals(mResources.getString(R.string.ginf)))
        			{
        				i.setAction(android.content.Intent.ACTION_VIEW);
			    	    String url="http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_mayo_801.pdf";
			    		i.setDataAndType(Uri.parse(googleDocsUrl + url), "text/html");
			    		
        				//i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_mayo_801.pdf"));
        			}
 		    	   else if(grado.equals(mResources.getString(R.string.gagr)))
 		    	   {
 		    		   i.setAction(android.content.Intent.ACTION_VIEW);
			    	   String url="http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_mayo_802.pdf";
			    	   i.setDataAndType(Uri.parse(googleDocsUrl + url), "text/html");	
 		    		   
 		    		   //i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_mayo_802.pdf"));
 		    	   }
		    	   else
		    	   {
		    		   i.setAction(android.content.Intent.ACTION_VIEW);
			    	   String url="http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_mayo_mat.pdf";
			    	   i.setDataAndType(Uri.parse(googleDocsUrl + url), "text/html");
		    		   
		    		   //i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_mayo_mat.pdf"));
		    	   }
        			
        			 startActivity(i);
        		}
        		else
        		{
        			
        			if(grado.equals(mResources.getString(R.string.ginf)))
        			{
        			   i.setAction(android.content.Intent.ACTION_VIEW);
  			    	   String url="http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_junio_801.pdf";
  			    	   i.setDataAndType(Uri.parse(googleDocsUrl + url), "text/html");
        				
  			    	   //i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_junio_801.pdf"));
        			}
 		    	    else if(grado.equals(mResources.getString(R.string.gagr)))
 		    	    {
 		    	       i.setAction(android.content.Intent.ACTION_VIEW);
   			    	   String url="http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_junio_802.pdf";
   			    	   i.setDataAndType(Uri.parse(googleDocsUrl + url), "text/html");
 		    	    	
   			    	   //i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_junio_802.pdf"));
 		    	    }
		    		else
		    		{
		    			i.setAction(android.content.Intent.ACTION_VIEW);
	   			    	String url="http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_junio_mat.pdf";
	   			    	i.setDataAndType(Uri.parse(googleDocsUrl + url), "text/html");
		    			
		    			//i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_junio_mat.pdf"));
		    		}
		    		
        			 startActivity(i);
        		}
    	        
    			startActivity(i);
    	        
    	        dialog.cancel();
    	    }
    	});
    	AlertDialog alert = builder.create();
    	alert.show();
    }
    
  	public void onBackPressed() 
	{
  		new AlertDialog.Builder(this)
        .setIcon(android.R.drawable.ic_dialog_alert)
        .setTitle(mResources.getString(R.string.salir))
        .setMessage(mResources.getString(R.string.seguro))
        .setPositiveButton(mResources.getString(R.string.si), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                            finish();
                     }
        })
        .setNegativeButton(mResources.getString(R.string.no), null)
        .show();
	}
}
 

