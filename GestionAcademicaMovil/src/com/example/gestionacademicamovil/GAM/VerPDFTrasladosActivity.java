package com.example.gestionacademicamovil.GAM;

import java.io.File;
import java.util.List;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.Toast;

public class VerPDFTrasladosActivity extends Activity 
{

	private Bundle bundle=null;
    private String nomfich;
    private Resources mResources;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		bundle=getIntent().getExtras();
		mResources = getResources();
		loadPDF();
				
	}	
	
	public void loadPDF()
	{		
		Intent intent = new Intent();		
		intent.setType("application/pdf");
		nomfich=null;
		PackageManager pm = getPackageManager();
		List<ResolveInfo> activities = pm.queryIntentActivities(intent, 0);
		if (activities.size() > 0)
		{
			nomfich=bundle.getString("fichero");			
			File file=null;					
			file=new File("/sdcard/download/"+nomfich);	
			bundle.remove("fichero");
			intent.setAction(android.content.Intent.ACTION_VIEW);			
			intent.setDataAndType(Uri.fromFile(file), "application/pdf");			
		    VerPDFTrasladosActivity.this.finish();
		    this.onDestroy();
		    startActivity(intent);		    
		    
		} 
		else 
		{
			Toast toast = Toast.makeText(getApplicationContext(),mResources.getString(R.string.descargapp), Toast.LENGTH_SHORT);
			toast.show();
			VerPDFTrasladosActivity.this.finish();
		}
	}
	

}
