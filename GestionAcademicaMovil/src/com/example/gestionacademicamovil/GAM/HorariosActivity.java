package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;
import java.util.List;

import com.example.gestionacademicamovil.GAM.ListaActivity.myAdapter;
import com.example.gestionacademicamovil.GAM.model.Asignatura;
import com.example.gestionacademicamovil.GAM.model.MenuPpal;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class HorariosActivity extends Activity {
	
	private ListView list1,list2;
	
	private Bundle bundle;
	private TextView usuario;
	private ArrayList<String> datos= new ArrayList<String>();
	private myAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.horarios);
        
        usuario=(TextView)findViewById(R.id.usuario);
        usuario.setText(GAMApplication.getInstance().getPreferencesManager().getName());
        
        list1= (ListView)findViewById(R.id.list1);
        list2= (ListView)findViewById(R.id.list2);
        adapter=new myAdapter(this,R.layout.list_item_horarios,datos);
        list1.setAdapter(adapter);
        list2.setAdapter(adapter);
        
        list1.setOnItemClickListener(new OnItemClickListener() {
 	  	   @Override
			   public void onItemClick(AdapterView<?> parent,View view,int position,long id){
				   Intent i = new Intent();
			    	if(position==0)
			    	{
			    		i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/horarios/horarios_12_13/GII1.1_12_13.pdf"));
			    	    startActivity(i);
			    	}
			    	else if(position==1)
			    	{
			    		i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/horarios/horarios_12_13/horarios_2012-13_801_2.1.pdf"));
			    	    startActivity(i);
			    	}
			    	else if(position==2)
			    	{
			    		i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/horarios/horarios_12_13/horarios_2012-13_801_3.1.pdf"));
			    	    startActivity(i);
			    	}
			    	else
			    	{
			    		i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/horarios/horarios_12_13/GII4.1_12_13.pdf"));
			    	    startActivity(i);
			    	}
 	  	  }
  	  });
        
        list2.setOnItemClickListener(new OnItemClickListener() {
  	  	   @Override
 			   public void onItemClick(AdapterView<?> parent,View view,int position,long id){
 				   Intent i = new Intent();
 			    	if(position==0)
 			    	{
 			    		i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/horarios/horarios_12_13/GII1.2_12_13.pdf"));
			    	    startActivity(i);
 			    	}
 			    	else if(position==1)
 			    	{
 			    		i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/horarios/horarios_12_13/horarios_2012-13_801_2.2.pdf"));
			    	    startActivity(i);
 			    	}
 			    	else if(position==2)
 			    	{
 			    		i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/horarios/horarios_12_13/GII3.2_12_13.pdf"));
			    	    startActivity(i);
 			    	}
 			    	else
 			    	{
 			    		i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.unirioja.es/facultades_escuelas/fceai/horarios/horarios_12_13/GII4.2_12_13.pdf"));
			    	    startActivity(i);
 			    	}
  	  	  }
   	  });
    }
    
    class myAdapter extends ArrayAdapter<String>  {

  		private final ArrayList<String> datos;

  		public myAdapter(Context context,int textViewResourceId, ArrayList<String> items)
  		{
  			   super(context,textViewResourceId, items);
  			   this.datos=items;
  		}
  		
  		public View getView(final int position, View convertView, ViewGroup parent) {
  			   View row = null;
  			   
  			   if (convertView != null) 
  				   row = convertView;
  			   LayoutInflater inflater = getLayoutInflater();
  			   final String listDato = datos.get(position);
  			 
  			   if (row == null || row.getId() != R.layout.list_item)
  				   row = inflater.inflate(R.layout.list_item, parent, false);
  			
  			 /*row.setOnClickListener(new OnClickListener() {
				   public void onClick(View v) {
  				   
  			        }
  			   });*/
  			
  			 TextView data1 = (TextView)row.findViewById(R.id.text1);
  			 
 			 data1.setText(listDato);

  			 return row;
  		}
  	}
    
    public void onStart()
    {
    	super.onStart();
    	datos.add("Primero");
    	datos.add("Segundo");
    	datos.add("Tercero");
    	datos.add("Cuarto");
    }   
  
    
}
