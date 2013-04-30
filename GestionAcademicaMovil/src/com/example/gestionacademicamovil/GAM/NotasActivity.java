package com.example.gestionacademicamovil.GAM;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.Menu;
import android.view.Window;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class NotasActivity extends TabActivity 
{
	
	private  Bundle bundle;
	private TextView usuario;
	private static TabHost mTabHost;

	private Resources mResources;
 
	@Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.notas);
        
        mResources = getResources();
        
        usuario=(TextView)findViewById(R.id.usuario);
        usuario.setText(GAMApplication.getInstance().getPreferencesManager().getName());
        
        mTabHost = getTabHost();
        
        addTabPrimero();
        addTabSegundo();
        
        mTabHost.getTabWidget().getChildAt(0).setBackgroundDrawable(mResources.getDrawable(R.drawable.selector_filas));
        mTabHost.getTabWidget().getChildAt(1).setBackgroundDrawable(mResources.getDrawable(R.drawable.selector_filas));
        
    }
    
    private void addTabPrimero() 
    {
	      Intent intent = new Intent().setClass(this, Primero.class);
	      TabSpec spec = mTabHost.newTabSpec("Tab1");
	      spec.setIndicator("Primer cuatrimentre");
	      spec.setContent(intent);
	      mTabHost.addTab(spec);
	}
	private void addTabSegundo() 
	{
	      Intent intent = new Intent(this, Segundo.class);
	      TabSpec spec = mTabHost.newTabSpec("Tab2");
	      spec.setIndicator("Segundo cuatrimestre");
	      spec.setContent(intent);
	      mTabHost.addTab(spec);
	}

}
