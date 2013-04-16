package com.example.gestionacademicamovil.GAM.managers;

import java.io.IOException;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;

import com.example.gestionacademicamovil.GAM.GAMApplication;
import com.example.gestionacademicamovil.GAM.model.Usuario;
import com.google.gson.Gson;

import es.unirioja.ae.academico.api.jws.*;

public class UsuarioManager {
	
	private static final String NAMESPACE = "http://jws.api.academico.ae.unirioja.es/";
	private static String URL="http://localhost:8380/academicoWS/PersonasService";
	private static final String METHOD_NAME = "getDatosPersonales";
	private static final String SOAP_ACTION ="http://jws.api.academico.ae.unirioja.es/getDatosPersonales";
	 
	private static SoapObject request=null;
	private static SoapSerializationEnvelope envelope=null;
	private static SoapObject  resultsRequestSOAP=null;
	 
	private Gson gson;
	
	private static Usuario user=new Usuario();
	private Boolean existe;
	
	private Context context;
	
	public UsuarioManager(Context context)
	{
		this.context = context;
	}
	
	public static Usuario getUsuario(SecurityToken token)
	{			
		GAMApplication.getInstance().showToast(token.getUsername()+token.getPasswd());
		
		 request = new SoapObject(NAMESPACE, METHOD_NAME);
		 PropertyInfo parametro = new PropertyInfo ();
		 parametro.setName ("token");
		 parametro.setValue (token);
		 request.addProperty (parametro);
		 
		 envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		 envelope.dotNet = false;
		 envelope.setOutputSoapObject(request);
		 HttpTransportSE transporte = new HttpTransportSE(URL);
		 
		 try {
				transporte.call(SOAP_ACTION, envelope);
				
				List<DatoAlumno> datoAlumnoCollection =(List<DatoAlumno>) envelope.getResponse();

				/*resultsRequestSOAP = (SoapObject)envelope.getResponse();
				SoapObject u=(SoapObject) resultsRequestSOAP.getProperty(0);
				
				String nombre=u.getProperty(0).toString();
				String nif=u.getProperty(1).toString();
				String apellidos=u.getProperty(2).toString();
				String telefono=u.getProperty(3).toString();
				String email=u.getProperty(4).toString();*/
				
				//user=new Usuario();
				user.setNombre(datoAlumnoCollection.get(0).getNombre());
				user.setNIF(datoAlumnoCollection.get(0).getDni());
				user.setApellidos(datoAlumnoCollection.get(0).getApellido1()+" "+datoAlumnoCollection.get(0).getApellido2());
				user.setTelefono(datoAlumnoCollection.get(0).getTelefono());
				user.setEmail(datoAlumnoCollection.get(0).getEmail());
				//user=new Usuario(nombre,nif,apellidos,telefono,email);

			} catch (IOException e) {
				e.printStackTrace();
			} catch (XmlPullParserException e) {
				e.printStackTrace();
			}
		 
		return user;
	 }
	
	
	
}