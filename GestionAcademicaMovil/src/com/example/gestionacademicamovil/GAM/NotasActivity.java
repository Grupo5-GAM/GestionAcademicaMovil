package com.example.gestionacademicamovil.GAM;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class NotasActivity extends TabActivity {
	
	private  Bundle bundle;
	private TextView usuario;
	private static TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notas);
        
        usuario=(TextView)findViewById(R.id.usuario);
        usuario.setText(GAMApplication.getInstance().getPreferencesManager().getName());
        
        mTabHost = getTabHost();
        addTabPrimero();
        addTabSegundo();
       // addTabTodas();
        
    }
    
    private void addTabPrimero() {
	      Intent intent = new Intent().setClass(this, Primero.class);
	      intent.putExtra("data",bundle.getString("data"));
	      TabSpec spec = mTabHost.newTabSpec("Tab1");
	      spec.setIndicator("Primer cuatrimentre");
	      spec.setContent(intent);
	      mTabHost.addTab(spec);
	}
	private void addTabSegundo() {
	      Intent intent = new Intent(this, Segundo.class);
	      intent.putExtra("data",bundle.getString("data"));
	      TabSpec spec = mTabHost.newTabSpec("Tab2");
	      spec.setIndicator("Segundo cuatrimestre");
	      spec.setContent(intent);
	      mTabHost.addTab(spec);
	}
	
	/*private void addTabTodas() {
	      Intent intent = new Intent(this, Todas.class);
	      intent.putExtra("data",bundle.getString("data"));
	      intent.putExtra("user",bundle.getString("user"));
	      TabSpec spec = mTabHost.newTabSpec("Tab3");
	      spec.setIndicator("Todas");
	      spec.setContent(intent);
	      mTabHost.addTab(spec);
	}*/

    public void onBackPressed() 
	{
		Intent i = new Intent();
		i.setClass(NotasActivity.this, ListaActivity.class);
  		NotasActivity.this.finish();
  		startActivity(i);
  		
	 }
    
}
