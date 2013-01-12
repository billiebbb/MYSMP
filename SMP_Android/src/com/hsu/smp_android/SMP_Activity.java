package com.hsu.smp_android;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class SMP_Activity extends Activity {
	WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_smp_);
		webView = (WebView)findViewById(R.id.webView1);
		JavaScriptInterface jsInterface = new JavaScriptInterface(this);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.addJavascriptInterface(jsInterface, "JSInterface");
		webView.loadUrl("file:///android_asset/test.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_smp_, menu);
		return true;
	}

}
