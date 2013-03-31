package com.example.testtouchevent;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

public class TestTouch extends Service{

	View view1;
	View view2;
	WindowManager wm;
	Button bt1;
	Button bt2;
	
	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
	
		LayoutInflater inf=LayoutInflater.from(this);
		
		
		final WindowManager.LayoutParams params=new WindowManager.LayoutParams(
				WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY|
				WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD,
				WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER,
				PixelFormat.TRANSLUCENT);
		
		final WindowManager.LayoutParams params2=new WindowManager.LayoutParams(
	            WindowManager.LayoutParams.WRAP_CONTENT,
	            WindowManager.LayoutParams.WRAP_CONTENT,
	            WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
	            WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
	            PixelFormat.TRANSLUCENT);

		view1=inf.inflate(R.layout.touchevent,null);
		view2=inf.inflate(R.layout.clickevent, null);

		
		wm=(WindowManager) getSystemService(Context.WINDOW_SERVICE	);
		wm.addView(view1, params);

		bt1=(Button) view1.findViewById(R.id.bt1);
		bt1.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View arg0) {
				wm.addView(view2, params2);
			}
		});
		
		
		bt2=(Button) view2.findViewById(R.id.bt2);
		bt2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				wm.removeView(view1);
				wm.removeView(view2);
			}
		});
		
		
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

}
