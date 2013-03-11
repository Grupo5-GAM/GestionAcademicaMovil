package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;

import com.example.gestionacademicamovil.GAM.model.Asignatura;
import com.example.gestionacademicamovil.GAM.model.Traslado;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TrasladosActivity extends Activity 
{
	private ListView list;
	
	private Bundle bundle;
	private String user,grado;
	private TextView usuario;
	
	private miAdapter adapter;
	
	private ArrayList<Traslado> datos=new ArrayList<Traslado>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
         setContentView(R.layout.traslados);
        
		 bundle=getIntent().getExtras();
	     user=bundle.getString("user");
	     grado=bundle.getString("grado");
	        
	     usuario=(TextView)findViewById(R.id.usuario);
	     usuario.setText(user);
	        
	     list= (ListView)findViewById(R.id.list);
	     adapter=new miAdapter(this,R.layout.traslados_item,datos);
	     list.setAdapter(adapter);
	}
	
	public void onStart()
    {
    	super.onStart();
    	
    	Traslado a1=new Traslado();
    	Traslado a2=new Traslado();
        datos.add(a1);
        datos.add(a2);
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
	
	public void onBackPressed() 
	{
		Intent i = new Intent();
		i.setClass(TrasladosActivity.this, ListaActivity.class);
  		i.putExtra("user",bundle.getString("user"));
  		startActivity(i);
  		TrasladosActivity.this.finish();
	 }
	
	
}

