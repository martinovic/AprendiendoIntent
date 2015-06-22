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
import android.widget.TextView;

public class SobreMainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sobre_main);
		
		final TextView tv1 = (TextView) findViewById(R.id.tv1);
		final Button btn1 = (Button) findViewById(R.id.buttonSobre);
		
		Bundle bundle = getIntent().getExtras();
		String nombre = bundle.getString("nombre");
		Log.i("info", nombre);
		tv1.setText("Hola " + nombre);

		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				/** 
				 * Esto crea una intent con los valores a retornar a la Main Activity
				 * cargo todos los valores a regresar por medio de putExtras y despues seteo
				 * la condicion de resultado retornando el intent.
				 * Por ultimo hago finish de la activity
				 */
				Intent intent = new Intent();
				intent.putExtra("regreso", "okis");
				setResult(RESULT_OK, intent);
				finish();
				
			}
		});
		
		Intent intent = new Intent();
		intent.putExtra("regreso", "okis");
		//finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sobre_main, menu);
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
