package com.example.gestionacademicamovil.GAM;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class HorarioActivity extends TabActivity {
	
	private  Bundle bundle;
	private String user;
	private TextView usuario;
	private static TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horarios);
        
        bundle=getIntent().getExtras();
        user=bundle.getString("user");
        
        //usuario=(TextView)findViewById(R.id.usuario);
        //usuario.setText(user);
        
        mTabHost = getTabHost();
        addTabPrimero();
        addTabSegundo();
       
        
    }
    
    private void addTabPrimero() {
	      Intent intent = new Intent().setClass(this, Primero.class);
	      intent.putExtra("data",bundle.getString("data"));
	      intent.putExtra("user",bundle.getString("user"));
	      TabSpec spec = mTabHost.newTabSpec("Tab1");
	      spec.setIndicator("Primer cuatrimentre");
	      spec.setContent(intent);
	      mTabHost.addTab(spec);
	}
	private void addTabSegundo() {
	      Intent intent = new Intent(this, Segundo.class);
	      intent.putExtra("data",bundle.getString("data"));
	      intent.putExtra("user",bundle.getString("user"));
	      TabSpec spec = mTabHost.newTabSpec("Tab2");
	      spec.setIndicator("Segundo cuatrimestre");
	      spec.setContent(intent);
	      mTabHost.addTab(spec);
	}

    public void onBackPressed() 
	{
		Intent i = new Intent();
		i.setClass(HorarioActivity.this, ListaActivity.class);
  		i.putExtra("user",bundle.getString("user"));
  		startActivity(i);
  		HorarioActivity.this.finish();
	 }
    
}
