package com.dotworld.aprendiendointent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	int request_Code = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button boton1 = (Button)findViewById(R.id.buttonSobre);
		      
		boton1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.i("INFORMACION", "Pulsaste el boton y voy a llamar a la otra activity.");
				Intent intent = new Intent();
				// Esto setea el intent dando la clase de origen y la de destino
				intent.setClass(MainActivity.this, SobreMainActivity.class);
				// Seteo los valores a pasar a la otra activity
				intent.putExtra("nombre", "marcelo");
				// Inicio la otra activity esperando un resultado, para eso paso
				// el intent y el request_Code, request_Code puede ser un int cualquiera, es como un ID
				startActivityForResult(intent, 1234);
			}
		});
		
	}

	/**
	 * El onActivityResult es el que atrapa todos los regresos de las activity llamadas
	 * el request code puede ser un integer que ayude a diferenciar la llamada
	 * se espera una condicion de RESULT_OK o RESULT_CANCEL
	 * de ahi en mas se toman las acciones para otro evento que se quiera generar.
	 * De esta manera puedo tener varios activitys con datos viajando de un lado a otro y
	 * esperar resultados diferentes
	 */
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1234){
			if (resultCode == RESULT_OK){
				String regreso = data.getExtras().getString("regreso");
				System.out.println(regreso);
				Log.i("aviso", regreso.toString());
				Toast.makeText(getApplicationContext(), regreso, Toast.LENGTH_SHORT).show();
			}
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
