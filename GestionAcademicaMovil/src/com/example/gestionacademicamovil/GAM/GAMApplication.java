package com.example.gestionacademicamovil.GAM;

import com.example.gestionacademicamovil.GAM.managers.PreferencesManager;
import com.example.gestionacademicamovil.GAM.managers.UsuarioManager;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class GAMApplication extends Application {
	
	// Constants
	public static final String UNI_TARGET = "uni_administration";
	public static final String UNI_TARGET_ANSWER = "Message received";
	public static final String UNI_TARGET_ERROR_ANSWER = "Invalid message";
	
	private static final String MESSAGE_TAG = "message";
	
	private static final int ACTION_SHOW_TOAST = 0;
	private static final int ACTION_GET_RUNNING = 1;
	
	// Variables
	private PreferencesManager preferencesManager;
	private UsuarioManager usuarioManager;
	
	
	private static GAMApplication instance;
	
	/**
	 * Default handler to take care of UI actions called from other threads.
	 */
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case ACTION_SHOW_TOAST:
				Toast.makeText(GAMApplication.this, msg.getData().getString(MESSAGE_TAG), Toast.LENGTH_LONG).show();
				break;
			case ACTION_GET_RUNNING:
			     /*if (!isiDigiConnectorRunning())
			     {
			         showToast(getResources().getString(R.string.error_connector_run));
			         return;
			     }*/
			      break;
			}
		}
	};

	public void onCreate() {
		super.onCreate();
		instance = this;
		// Initialize managers.
		preferencesManager = new PreferencesManager(this);
		usuarioManager = new UsuarioManager(this);
	}
	
	public static GAMApplication getInstance() {
		return instance;
	}
	
	public PreferencesManager getPreferencesManager() {
		return preferencesManager;
	}
	
	public UsuarioManager getUsuarioManager() {
		return usuarioManager;
	}

	public void showToast(String message) {
		Bundle bundle = new Bundle();
		bundle.putString(MESSAGE_TAG, message);
		Message msg = handler.obtainMessage(ACTION_SHOW_TOAST);
		msg.setData(bundle);
		handler.sendMessage(msg);
	}
	
	public boolean internetAvailable() {
		ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = manager.getActiveNetworkInfo();
		if (info == null || info.getState().equals(State.DISCONNECTED))
			return false;
		return true;
	}
	
}

