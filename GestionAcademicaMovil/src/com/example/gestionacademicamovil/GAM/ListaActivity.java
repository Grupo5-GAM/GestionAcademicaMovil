package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaActivity extends ListActivity {
	
	private TextView usuario;
	
	private  ArrayAdapter adapter;
	
	private String user;
	
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
     
      adapter=ArrayAdapter.createFromResource(this,R.array.menu, android.R.layout.simple_list_item_1);
      //adapter.setDropDownViewResource(android.R.layout.);
     
      setListAdapter(adapter);

    }
    
    public void onStart()
    {
    	super.onStart();
    }
    
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
    	Intent i = new Intent();
    	if(position==0)
    		i.setClass(ListaActivity.this, MatriculaActivity.class);
    	else if(position==1)
    		i.setClass(ListaActivity.this, ExpedienteActivity.class);
    	else if(position==2)
    		i.setClass(ListaActivity.this, HorarioActivity.class);
    	else if(position==3)
    		i.setClass(ListaActivity.this, AsignaturasActivity.class);
    	else
    		i.setClass(ListaActivity.this, BecasActivity.class);
    	
		i.putExtra("user",user);
		startActivity(i);
    }
  	
  	public void onBackPressed() 
	{
		Intent i = new Intent();
		i.setClass(ListaActivity.this, Login.class);
  		i.putExtra("user",bundle.getString("user"));
  		startActivity(i);
  		ListaActivity.this.finish();
	 }
}
 

