package com.suza.appi;

import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.StartAppSDK;

import vn.suza.utils.BaseActivity;
import android.os.Bundle;

/**
 * 
 * @author Ricky Doo
 * 
 */
public class MainActivity extends BaseActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StartAppSDK.init(this, "112157033", "212432830", true);
		setContentView(R.layout.activity_main);
		startAppAd.showAd();
		startAppAd.loadAd();
	}

	private StartAppAd startAppAd = new StartAppAd(this);

	@Override
	protected void findViews() {

	}

	@Override
	public void onResume() {
		super.onResume();
		startAppAd.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
		startAppAd.onPause();
	}
}