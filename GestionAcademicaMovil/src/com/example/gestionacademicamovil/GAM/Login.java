package com.example.gestionacademicamovil.GAM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.gestionacademicamovil.GAM.model.Asignatura;
import com.example.gestionacademicamovil.GAM.model.Usuario;

//import es.unirioja.ae.academico.api.jws.PersonasService;
//import es.unirioja.ae.academico.api.jws.SecurityToken;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Login extends Activity{
	
	static final String DATA_TITLE = "T";
	static final String DATA_LINK  = "L";
	
	static LinkedList<HashMap<String, String>> data;

	static String feedUrl = "https://belenus.unirioja.es/~caponce/GAM/prueba2.xml";	
	
	private ProgressDialog progressDialog;

	/*Httppostaux post;
    // String URL_connect="http://www.scandroidtest.site90.com/acces.php";
    String IP_Server="10.0.2.2:80";//IP DE NUESTRO PC
    String URL_connect="http://"+IP_Server+"/acces.php";//ruta en donde estan nuestros archivos
	*/
    boolean result_back;
    private ProgressDialog pDialog;
    boolean prueba;
	
	public static final String LOGIN_INTENT = "com.example.uniadministration.LOGIN_INTENT";
	
	private ArrayList<Usuario> datos=new ArrayList<Usuario>();
	private Usuario u;
	
	private EditText txtPass;
	private EditText txtUser;
	private CheckBox rememberLogin;
	private Button btLogin;
	
	private String user,pass;
	
	private Resources mResources;
	private Vibrator vibrator;
	
	private int registered=-2;
	private int error_registro=-1;
	private Bundle bundle;
	private String opcion;
	
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);   
      requestWindowFeature(Window.FEATURE_NO_TITLE);
      setContentView(R.layout.login); 
      
      mResources = getResources();
      bundle=getIntent().getExtras();
      opcion="";
		 if(bundle!=null)
			 opcion=bundle.getString("opcion");
      vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
      
      txtUser=(EditText)findViewById(R.id.intUser);
      txtPass=(EditText)findViewById(R.id.intPassword);
      btLogin=(Button)findViewById(R.id.btLogin);
      rememberLogin = (CheckBox)findViewById(R.id.remember_login);

      btLogin.setOnClickListener(new OnClickListener(){
		  public void onClick(View view){
			 validar();		  
		  }
	  });
      
      rememberLogin.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			 if (rememberLogin.isChecked())
           	  GAMApplication.getInstance().getPreferencesManager().setRememberLogin(true);
             else
           	  GAMApplication.getInstance().getPreferencesManager().setRememberLogin(false);
		}

      });
			
	  if (GAMApplication.getInstance().getPreferencesManager().getRememberLogin()) {
			txtUser.setText(GAMApplication.getInstance().getPreferencesManager().getUser());
			txtPass.setText(GAMApplication.getInstance().getPreferencesManager().getPassword());
			
			rememberLogin.setChecked(true);
	  } else {
			rememberLogin.setChecked(false);
	  }  
      
      ListView lv = (ListView) findViewById(R.id.lstData);
   
      lv.setOnItemClickListener(new OnItemClickListener() 
      {

  		@Override
  		public void onItemClick(AdapterView<?> av, View v, int position,long id) 
  		{
  			HashMap<String, String> entry = data.get(position);
		       
  			Intent browserAction = new Intent(Intent.ACTION_VIEW, 
  					Uri.parse(entry.get(DATA_LINK)));
  			startActivity(browserAction);				
  		}
  	});        
		
    }
	
    /*
	 * (non-Javadoc)
	 * @see android.app.Activity#onStart()
	 */
	public void onStart()
	{
		super.onStart();
		
		if(GAMApplication.getInstance().internetAvailable())
		{
			u=new Usuario();
			crearUsuarios();
			loadData();
		}
		else
		{
			Dialog d=crearDialogoInformacion();
			d.show();
		}
		
	}
	
	private Dialog crearDialogoInformacion()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		 
	    builder.setTitle(mResources.getString(R.string.informacion));
	    builder.setMessage(mResources.getString(R.string.comprobacion));
	    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            	dialog.cancel();
            	finish();
              }
            });
	 
	    return builder.create();
	}
	
	private void validar()
	{
		pass = txtPass.getText().toString();
		user = txtUser.getText().toString();
		
		//verificamos si estan en blanco
       if( checklogindata(user , pass )==true){
        	//si pasamos esa validacion ejecutamos el asynctask pasando el usuario y clave como parametros
        	//new asynclogin().execute(user,pass);
    	   
    	   /*SecurityToken token=new SecurityToken();
   		   token.setUsername(GAMApplication.getInstance().getPreferencesManager().getUser());
   		   token.setPasswd(GAMApplication.getInstance().getPreferencesManager().getPassword());*/
    	   
    	   //if(!GAMApplication.getInstance().getUsuarioManager().getUsuario(token).getNombre().equals(""))
    	   if(existeUsuario(user,pass))
   		   {
    		   GAMApplication.getInstance().getPreferencesManager().setUser(user);
    		   GAMApplication.getInstance().getPreferencesManager().setPassword(pass);
    		   GAMApplication.getInstance().getPreferencesManager().setGrado(u.getGrado());
    		   GAMApplication.getInstance().getPreferencesManager().setName(u.getNombre());
        	   
        	   Intent i=new Intent(Login.this, ListaActivity.class);
        	   Login.this.finish();
        	   startActivity(i);
    	   }
    	   else
    	   {
    		   err_login();
    	   }
    	 
        }else{
        //si detecto un error en la primera validacion vibrar y mostrar un Toast con un mensaje de error.
        	err_login();
        }
		
	}
	
	//vibra y muestra un Toast
    public void err_login()
    {
    	if(GAMApplication.getInstance().getPreferencesManager().getVibracion())
    			vibrator.vibrate(200);
    	GAMApplication.getInstance().showToast(mResources.getString(R.string.errorlogin));
    }
  
    //validamos si no hay ningun campo en blanco
    public boolean checklogindata(String username ,String password )
    {
    	if (username.equals("") || password.equals(""))
    	{
    		Log.e("Login ui", "checklogindata user or pass error");
    		return false;   
    	}else{
    		return true;
    	}
    
    } 
	    
	  private final Handler progressHandler = new Handler() 
	  {
			@SuppressWarnings("unchecked")
			public void handleMessage(Message msg) {
				if (msg.obj != null) {
					data = (LinkedList<HashMap<String, String>>)msg.obj;
					setData(data);					
				}
				progressDialog.dismiss();
		    }
		};
		
		private void setData(LinkedList<HashMap<String, String>> data)
	    {
	    	SimpleAdapter sAdapter = new SimpleAdapter(getApplicationContext(), data, 
	    			R.layout.list_item, 
	    			new String[] { DATA_TITLE, DATA_LINK }, 
	    			new int[] { R.id.text1, R.id.text2 });
	    	ListView lv = (ListView) findViewById(R.id.lstData);
	    	lv.setAdapter(sAdapter);
	    } 
	    
	   
	    private void loadData()
	    {
	    	progressDialog = ProgressDialog.show(
	    			Login.this,"",mResources.getString(R.string.carga),true);
	    	
	    	new Thread(new Runnable()
	    	{
	    		@Override
	    		public void run() 
	    		{
	    			XMLParser parser = new XMLParser(feedUrl); 
	                Message msg = progressHandler.obtainMessage();
	                msg.obj = parser.parse();
	    			progressHandler.sendMessage(msg);
	    		}}).start();
	    }    
	    
	    public void onBackPressed() 
		{
	  		finish();
		}
	    
	    public void crearUsuarios()
	    {
	    	Usuario u1=new Usuario("carol","1234","Carol","12345678","ponce marin","941225689","carol@gmail.com","Grado en Ingeniería Informática","2012/2013","3","18/08/2012","Domiciliacion","985.54");
	    	Usuario u2=new Usuario("elena","4321","Elena","987654321","garcia fernandez","941362154","elena@gmail.com","Grado en Ingeniería Informática","2012/2013","3","20/08/2012","Domiciliacion","1200");
	    	Usuario u3=new Usuario("oscar","1423","Oscar","192837465","mezquita gonzalez","941325541","oscar@gmail.com","Grado en Matematicas","2012/2013","3","22/08/2012","Domiciliacion","1145.50");
	    	Usuario u4=new Usuario("eloy","1234","Eloy","12345678","mata","941225689","eloy@gmail.com","Grado en Ingeniería agricola","2012/2013","2","25/08/2012","Domiciliacion","840.79");
	    
	    	datos.add(u1);
	    	datos.add(u2);
	    	datos.add(u3);
	    	datos.add(u4);
	    }
	    
	    public boolean existeUsuario(String user,String pass)
	    {
	    	boolean esta=false;
	    	for(int i=0;i<datos.size();i++)
	    	{
	    		if(datos.get(i).getCuasi().equals(user) && datos.get(i).getPassword().equals(pass))
	    		{
	    			esta=true;
	    			u=datos.get(i);
	    		}
	    	}
			return esta;
	    }
}
