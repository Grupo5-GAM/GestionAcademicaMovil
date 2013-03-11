package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;

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
import android.widget.AdapterView.OnItemClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaActivity extends Activity {
	
	private ListView list1,list2,list3,list4;
	private TextView usuario;
	private ArrayAdapter adapter1,adapter2,adapter3,adapter4;
	private String user;
	private Dialog dialog;
	private Resources mResources;
	
	private  Bundle bundle;
	
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState); 
      setContentView(R.layout.list);
     
      mResources = getResources();
      
      bundle=getIntent().getExtras();
      user=bundle.getString("user");

      usuario=(TextView)findViewById(R.id.usuario);
      usuario.setText(user);
      
      list1= (ListView)findViewById(R.id.list1);
      //list2= (ListView)findViewById(R.id.list2);
     // list3= (ListView)findViewById(R.id.list3);
     // list4= (ListView)findViewById(R.id.list4);
     
      adapter1=ArrayAdapter.createFromResource(this,R.array.todo, android.R.layout.simple_list_item_1);
      //adapter2=ArrayAdapter.createFromResource(this,R.array.expediente, android.R.layout.simple_list_item_1);
     // adapter3=ArrayAdapter.createFromResource(this,R.array.solicitudes, android.R.layout.simple_list_item_1);
     // adapter4 =ArrayAdapter.createFromResource(this,R.array.Accesos, android.R.layout.simple_list_item_1);
     
      list1.setAdapter(adapter1);
     // list2.setAdapter(adapter2);
     // list3.setAdapter(adapter3);
     // list4.setAdapter(adapter4);
      
      list1.setOnItemClickListener(new OnItemClickListener() {
    	  	   @Override
			   public void onItemClick(AdapterView<?> parent,View view,int position,long id){
				   Intent i = new Intent();
			    	if(position==0)
			    	{
			    		i.setClass(ListaActivity.this, MatriculaActivity.class);
			    		i.putExtra("user",user);
			    		startActivity(i);
			    	}
			    	else if(position==1)
			    	{
			    		crearDialogoSeleccionGrado();
			    	}
			    	else if(position==2)
			    	{
			    		i.setClass(ListaActivity.this, HorariosActivity.class);
			    		i.putExtra("user",user);
			    		startActivity(i);
			    	}
			    	else if(position==3)
			    	{
			    		crearDialogoSeleccionMes();
			    	}
			    	else if(position==4)
			    	{
			    		i.setClass(ListaActivity.this,NotasActivity.class);
			    		i.putExtra("user",user);
			    		startActivity(i);
			    	}
			    	else if(position==5)
			    	{
			    		i.setClass(ListaActivity.this,ConvalidacionesActivity.class);
			    		i.putExtra("user",user);
			    		startActivity(i);
			    	}
			    	else if(position==6)
			    	{
			    		i.setClass(ListaActivity.this,TrasladosActivity.class);
			    		i.putExtra("user",user);
			    		startActivity(i);
			    	}
			    	else if(position==7)
			    	{
			    		i.setClass(ListaActivity.this,BecasActivity.class);
			    		i.putExtra("user",user);
			    		startActivity(i);
			    	}
			    	else
			    	{
			    		i = new Intent("android.intent.action.VIEW", Uri.parse("https://unirioja.blackboard.com/webapps/login/"));
			    	    startActivity(i);
			    	}
			    	
			    	
			    	
			   }
	  });
      /*list2.setOnItemClickListener(new OnItemClickListener() {
	  	  
		   public void onItemClick(AdapterView<?> parent,View view,int position,long id){
			   Intent i = new Intent();
		    	if(position==0)
		    	{
		    		i.setClass(ListaActivity.this, NotasActivity.class);
		    		i.putExtra("user",user);
		    		startActivity(i);
		    	}
		    	else if(position==1)
		    	{
		    		i.setClass(ListaActivity.this, AjustesActivity.class);//CovalidacionesActivity
		    		i.putExtra("user",user);
		    		startActivity(i);
		    	}
		    	else 
		    	{
		    		i.setClass(ListaActivity.this, AjustesActivity.class);//TrasladosActivity
		    		i.putExtra("user",user);
		    		startActivity(i);
		    	}
		   }
      });
      
      list3.setOnItemClickListener(new OnItemClickListener() {
	  	   @Override
		   public void onItemClick(AdapterView<?> parent,View view,int position,long id){
			   Intent i = new Intent();
		    	if(position==0)
		    	{
		    		i.setClass(ListaActivity.this, BecasActivity.class);
		    		i.putExtra("user",user);
		    		startActivity(i);
		    	}
		   }
      });
      
      list4.setOnItemClickListener(new OnItemClickListener() {
	  	   @Override
		   public void onItemClick(AdapterView<?> parent,View view,int position,long id){
			   Intent i = new Intent();
		    	if(position==0)
		    	{
		    		i = new Intent("android.intent.action.VIEW", Uri.parse("https://unirioja.blackboard.com/webapps/login/"));
		    	    startActivity(i);
		    	}
		   }
     });*/

    }
    
    public void onStart()
    {
    	super.onStart();
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
	        	i.putExtra("user",user);
	        	startActivity(i);
	        	
                return true;
            case R.id.cambiarUsuario:
            	i=new Intent(ListaActivity.this, Login.class);
	        	i.putExtra("user",user);
	        	startActivity(i);
    
                return true;
            case R.id.salir:
    			
            	new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Salir")
                .setMessage("¿Esta seguro?")
                .setPositiveButton("si", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                    finish();
                             }
                })
                .setNegativeButton("no", null)
                .show();
				
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
  	
    private void crearDialogoSeleccionGrado()
    {
    	final CharSequence[] items = {"Grado1","Grado2","Grado3"};
    	 
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle("Seleccione una titulacion");
    	builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
    	    public void onClick(DialogInterface dialog, int item) {
    	       // Toast toast = Toast.makeText(getApplicationContext(), "Has elegido la opcion: " + items[item] , Toast.LENGTH_SHORT);
    	       // toast.show();
    	        
    	        Intent i = new Intent();
    	        
    	        if(item==0)
        		{
        			i.setClass(ListaActivity.this, AsignaturasActivity.class);
            		i.putExtra("grado","grado1");
        		}
        		else if(item==1)
        		{
        			i.setClass(ListaActivity.this,  AsignaturasActivity.class);
        			i.putExtra("grado","grado2");
        		}
        		else
        		{
        			i.setClass(ListaActivity.this,  AsignaturasActivity.class);
        			i.putExtra("grado","grado3");
        		}
    	        
    	        i.putExtra("user",user);
    			startActivity(i);
    	        
    	        dialog.cancel();
    	    }
    	});
    	AlertDialog alert = builder.create();
    	alert.show();
    }
    
    private void crearDialogoSeleccionMes()
    {
    	final CharSequence[] items = {"Enero","Mayo","Junio"};
    	 
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle("Seleccione el mes");
    	builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
    	    public void onClick(DialogInterface dialog, int item) {
    	       // Toast toast = Toast.makeText(getApplicationContext(), "Has elegido la opcion: " + items[item] , Toast.LENGTH_SHORT);
    	       // toast.show();
    	        
    	        Intent i = new Intent();
    	        
    	        if(item==0)
        		{
    	        	i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_enero_801.pdf"));
		    	    startActivity(i);
        		}
        		else if(item==1)
        		{
        			i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_mayo_801.pdf"));
		    	    startActivity(i);
        		}
        		else
        		{
        			i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/examenes/2012-13_junio_801.pdf"));
		    	    startActivity(i);
        		}
    	        
    	        i.putExtra("user",user);
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
        .setTitle("Salir")
        .setMessage("¿Esta seguro?")
        .setPositiveButton("si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                            finish();
                     }
        })
        .setNegativeButton("no", null)
        .show();
	}
}
 

