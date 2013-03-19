package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;

import com.example.gestionacademicamovil.GAM.AsignaturasActivity.miAdapter;
import com.example.gestionacademicamovil.GAM.model.Asignatura;
import com.example.gestionacademicamovil.GAM.model.Nota;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Primero extends Activity {
	
	private ListView list;
	private miAdapter adapter;
	
	private ArrayList<Nota> datos=new ArrayList<Nota>();
	
	private TextView usuario,texto;
	private  Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuatrimestres);
        
        bundle=getIntent().getExtras();
        
        list= (ListView)findViewById(R.id.list);
        adapter=new miAdapter(this,R.layout.cuatrimestres_item,datos);
        list.setAdapter(adapter);
        
    }
    
    public void onStart()
    {
    	super.onStart();
    	
    	Nota a=new Nota();
        datos.add(a);
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

    public void onBackPressed() 
	{
		Intent i = new Intent();
		i.setClass(Primero.this, ListaActivity.class);
		Primero.this.finish();
  		startActivity(i);
  		
	 }
    
}
