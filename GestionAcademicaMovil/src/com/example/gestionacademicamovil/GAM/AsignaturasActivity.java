package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;
import java.util.List;

import com.example.gestionacademicamovil.GAM.model.Asignatura;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AsignaturasActivity extends Activity {
	
	private ListView list;
	
	private Bundle bundle;
	private String user,grado;
	private TextView usuario;
	
	private miAdapter adapter;
	
	private ArrayList<Asignatura> datos=new ArrayList<Asignatura>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asignaturas);
        
        bundle=getIntent().getExtras();
        user=bundle.getString("user");
        grado=bundle.getString("grado");
        
        usuario=(TextView)findViewById(R.id.usuario);
        usuario.setText(user);
        
        list= (ListView)findViewById(R.id.list);
        adapter=new miAdapter(this,R.layout.asignaturas_item,datos);
        list.setAdapter(adapter);
        
    }
    
    public void onStart()
    {
    	super.onStart();
    	
    	Asignatura a1=new Asignatura();
    	Asignatura a2=new Asignatura();
        datos.add(a1);
        datos.add(a2);
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
  			  TextView data4 = (TextView)row.findViewById(R.id.guia);
  			 
  			  data1.setText(listDato.getNombre());
  			  data2.setText(String.valueOf(listDato.getCreditos()));
  			  data3.setText(listDato.getProfesor());
  			  data4.setText(listDato.getGuia());

  			 return row;
  		 
  		}
  	}

    public void onBackPressed() 
	{
		Intent i = new Intent();
		i.setClass(AsignaturasActivity.this, ListaActivity.class);
  		i.putExtra("user",bundle.getString("user"));
  		AsignaturasActivity.this.finish();
  		startActivity(i);
  		
	 }
    
}
