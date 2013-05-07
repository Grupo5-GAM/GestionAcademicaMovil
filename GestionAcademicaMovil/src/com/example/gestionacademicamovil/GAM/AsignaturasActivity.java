package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;
import java.util.List;

import com.example.gestionacademicamovil.GAM.managers.CrearPDF;
import com.example.gestionacademicamovil.GAM.model.Asignatura;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;

public class AsignaturasActivity extends TabActivity 
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
	      Intent intent = new Intent().setClass(this, AsignaturasActivity1.class);
	      TabSpec spec = mTabHost.newTabSpec("Tab1");
	      spec.setIndicator(mResources.getString(R.string.primercuat));
	      spec.setContent(intent);
	      mTabHost.addTab(spec);
	}
	private void addTabSegundo() 
	{
	      Intent intent = new Intent(this, AsignaturasActivity2.class);
	      TabSpec spec = mTabHost.newTabSpec("Tab2");
	      spec.setIndicator(mResources.getString(R.string.segundocuat));
	      spec.setContent(intent);
	      mTabHost.addTab(spec);
	}

}
