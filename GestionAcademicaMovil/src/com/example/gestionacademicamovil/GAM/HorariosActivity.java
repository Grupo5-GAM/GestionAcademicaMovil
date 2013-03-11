package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;
import java.util.List;

import com.example.gestionacademicamovil.GAM.model.Asignatura;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class HorariosActivity extends Activity {
	
	private ListView list1,list2;
	
	private Bundle bundle;
	private String user;
	private TextView usuario;
	
	private ArrayAdapter adapter1,adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horarios);
        
        bundle=getIntent().getExtras();
        user=bundle.getString("user");
        
        usuario=(TextView)findViewById(R.id.usuario);
        usuario.setText(user);
        
        list1= (ListView)findViewById(R.id.list1);
        list2= (ListView)findViewById(R.id.list2);
        adapter1=ArrayAdapter.createFromResource(this,R.array.Cursos, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list1.setAdapter(adapter1);
        list2.setAdapter(adapter1);
        
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
    
    public void onStart()
    {
    	super.onStart();
    }
    
    public void onBackPressed() 
	{
		Intent i = new Intent();
		i.setClass(HorariosActivity.this, ListaActivity.class);
  		i.putExtra("user",bundle.getString("user"));
  		HorariosActivity.this.finish();
  		startActivity(i);
	 }
    
}
