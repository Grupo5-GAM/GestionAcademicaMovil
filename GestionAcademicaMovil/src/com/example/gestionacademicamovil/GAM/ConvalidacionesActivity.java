package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;

import com.example.gestionacademicamovil.GAM.model.Asignatura;
import com.example.gestionacademicamovil.GAM.model.Convalidacion;

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

public class ConvalidacionesActivity  extends Activity 
{
private ListView list;
	
	private Bundle bundle;
	private String grado;
	private TextView usuario;
	
	private miAdapter adapter;
	
	private ArrayList<Convalidacion> datos=new ArrayList<Convalidacion>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.convalidaciones);
		
        bundle=getIntent().getExtras();
	    //grado=bundle.getString("grado");
	        
	     usuario=(TextView)findViewById(R.id.usuario);
	     usuario.setText(GAMApplication.getInstance().getPreferencesManager().getName());
	        
	     list= (ListView)findViewById(R.id.list);
	     adapter=new miAdapter(this,R.layout.convalidacion_item,datos);
	     list.setAdapter(adapter);
	}
	
	public void onStart()
    {
    	super.onStart();
    	
    	Convalidacion a1=new Convalidacion();
    	Convalidacion a2=new Convalidacion();
        datos.add(a1);
        datos.add(a2);
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
			  data3.setText(String.valueOf(listDato.getNota()));

			 return row;
		 
		}
	}
	
	public void onBackPressed() 
	{
		Intent i = new Intent();
		i.setClass(ConvalidacionesActivity.this, ListaActivity.class);
  		ConvalidacionesActivity.this.finish();
  		startActivity(i);
  		
	 }
}
	