package vn.suza.utils;

import android.app.Activity;
import android.widget.Toast;

/**
 * 
 * @author Ricky Doo
 *
 */
public abstract class BaseActivity extends Activity {
	public void showToast(String text) {
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
	
	protected abstract void findViews();
}
