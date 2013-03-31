package com.example.testtouchevent;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TestActivity extends Activity{

	Button bt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainlayout);
		
		bt=(Button) findViewById(R.id.mainview);
		bt.setOnClickListener(new OnClickListener(){
		
		@Override
			public void onClick(View arg0) {
			Intent intent = new Intent(TestActivity.this,TestTouch.class);
			startService(intent);
			}
			
		});
		
	}
}
