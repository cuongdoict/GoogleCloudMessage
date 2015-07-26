package com.suza.appi;

import vn.suza.utils.BaseActivity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class SplashActivity extends BaseActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		findViews();
		
		PackageInfo pinfo;
		try {
			pinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
			tvAppVersion.setText(getResources().getString(R.string.text_version) + " " + pinfo.versionName);
			tvAppVersion.setVisibility(View.VISIBLE);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		
		new Handler().postDelayed(new Runnable() {
			
			public void run() {
				Intent i = new Intent(SplashActivity.this, MainActivity.class);
				startActivity(i);
				finish();
			}
		}, 1500);
	}

	private TextView tvAppVersion;
	protected void findViews() {
		tvAppVersion = (TextView) findViewById(R.id.tvAppVersion);
	}
}
