package com.example.listviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * 
 * @author xuelang www.gaotenglife.com
 *
 */
public class MainActivity extends ActionBarActivity implements OnClickListener{

	private Button btnFirst = null;
	private Button btnSecond = null;
	private Button btnThird = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnFirst = (Button)this.findViewById(R.id.btfirst);
		btnSecond = (Button)this.findViewById(R.id.btsecond);
		btnThird = (Button)this.findViewById(R.id.btthird);
		
		btnFirst.setOnClickListener(this);
		btnSecond.setOnClickListener(this);
		btnThird.setOnClickListener(this);
		
	}

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

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch (arg0.getId()) {
		case R.id.btfirst:
			Intent intentfirst = new Intent(this,FirstActivity.class);
			this.startActivity(intentfirst);
			break;
		case R.id.btsecond:
			Intent intentsecond = new Intent(this,SecondActivity.class);
			this.startActivity(intentsecond);
			break;
		case R.id.btthird:
			Intent intentthird = new Intent(this,ThirdActivity.class);
			this.startActivity(intentthird);
			break;

		default:
			break;
		}
		
	}
}
