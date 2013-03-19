package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;

import com.example.gestionacademicamovil.GAM.model.Asignatura;
import com.example.gestionacademicamovil.GAM.model.Beca;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class BecasActivity extends Activity 
{
	private ListView list;
	
	private Bundle bundle;
	private String grado;
	private TextView usuario;
	
	private miAdapter adapter;
	
	private ArrayList<Beca> datos=new ArrayList<Beca>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
         setContentView(R.layout.becas);
        
		 bundle=getIntent().getExtras();
	     grado=bundle.getString("grado");
	        
	     usuario=(TextView)findViewById(R.id.usuario);
	     usuario.setText(GAMApplication.getInstance().getPreferencesManager().getName());
	        
	     list= (ListView)findViewById(R.id.list);
	     adapter=new miAdapter(this,R.layout.becas_item,datos);
	     list.setAdapter(adapter);
	}
	
	public void onStart()
    {
    	super.onStart();
    	
    	Beca a1=new Beca();
    	Beca a2=new Beca();
        datos.add(a1);
        datos.add(a2);
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
	
	public void onBackPressed() 
	{
		Intent i = new Intent();
		i.setClass(BecasActivity.this, ListaActivity.class);
  		BecasActivity.this.finish();
  		startActivity(i);
  		
	 }
	
	
}
