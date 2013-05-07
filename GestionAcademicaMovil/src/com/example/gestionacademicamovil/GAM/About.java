package com.example.gestionacademicamovil.GAM;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.TextView;

public class About extends Activity {
	
	private TextView about,desarrolladores;
	private  Bundle bundle;
	
	private Resources mResources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        
        mResources = getResources();
        
        about=(TextView)findViewById(R.id.about);
        about.setText(mResources.getString(R.string.textabout));
        
        desarrolladores=(TextView)findViewById(R.id.desarrolladores);
        desarrolladores.setText(mResources.getString(R.string.desarrolladores));
    }

    public void onBackPressed() 
	{
		Intent i = new Intent();
		i.setClass(About.this, ListaActivity.class);
		About.this.finish();
  		startActivity(i);
	 }
    
}
