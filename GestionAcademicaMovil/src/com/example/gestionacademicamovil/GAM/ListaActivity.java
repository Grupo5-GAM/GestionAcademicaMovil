package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
	private ArrayAdapter adapter;
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
    	{
    		i.setClass(ListaActivity.this, MatriculaActivity.class);
    		i.putExtra("user",user);
    		startActivity(i);
    	}
    	else if(position==1)
    	{
    		i.setClass(ListaActivity.this, ExpedienteActivity.class);
    		i.putExtra("user",user);
    		startActivity(i);
    	}
    	else if(position==2)
    	{
    		i.setClass(ListaActivity.this, HorarioActivity.class);
    		i.putExtra("user",user);
    		startActivity(i);
    	}
    	else if(position==3)
    		crearDialogoSeleccion();
    	else
    	{
    		i.setClass(ListaActivity.this, BecasActivity.class);
    		i.putExtra("user",user);
    		startActivity(i);
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
	        	i.putExtra("user",user);
	        	startActivity(i);
	        	
                return true;
            case R.id.cambiarUsuario:
            	i=new Intent(ListaActivity.this, Login.class);
	        	i.putExtra("user",user);
	        	startActivity(i);
    
                return true;
            case R.id.salir:
            	ListaActivity.this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
  	
    private Dialog crearDialogoSeleccion()
    {
        final String[] items = {"Grado 1", "Grado 2", "Grado 3"};
        final Intent i = new Intent();
     
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
     
        builder.setTitle("Selección");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                Log.i("Dialogos", "Opción elegida: " + items[item]);
                
                
            }
        });
     
        return builder.create();
    }
    
  	/*public void onBackPressed() 
	{
		Intent i = new Intent();
		i.setClass(ListaActivity.this, Login.class);
  		i.putExtra("user",bundle.getString("user"));
  		startActivity(i);
  		ListaActivity.this.finish();
	 }*/
}
 

