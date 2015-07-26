package vn.suza.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import android.os.AsyncTask;

/**
 * @author Ricky Doo
 */
public class GetHTML extends AsyncTask<String, Void, String> {
	private int code;
	private OnLoadURLListener onLoadURLListener;

	public GetHTML(OnLoadURLListener onLoadURLListener, int code) {
		this.code = code;
		this.onLoadURLListener = onLoadURLListener;
	}

	public String getUrl(String a) {
		String content = null;
		try {
			URL url = new URL(a);

			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));

			String inputLine;

			while ((inputLine = br.readLine()) != null) {
				content += inputLine;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return content;
	}

	@Override
	protected String doInBackground(String... params) {

		if (params == null || params.length == 0) {
			return null;
		}
		return getUrl(params[0]);
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		if (onLoadURLListener != null) {
			onLoadURLListener.onLoadPageFinish(code, result);
		}
	}

	public interface OnLoadURLListener {
		public void onLoadPageFinish(int code, String content);
	}

}
