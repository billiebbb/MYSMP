package com.hsu.smp_android;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.PackageInfo;
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
	
	private ArrayList<PInfo> getPackages() {
	    ArrayList<PInfo> apps = getInstalledApps(false); /* false = no system packages */
	    final int max = apps.size();
	    for (int i=0; i<max; i++) {
	        apps.get(i).prettyPrint();
	    }
	    return apps;
	}

	private ArrayList<PInfo> getInstalledApps(boolean getSysPackages) {
	    ArrayList<PInfo> res = new ArrayList<PInfo>();        
	    List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);
	    for(int i=0;i<packs.size();i++) {
	        PackageInfo p = packs.get(i);
	        if ((!getSysPackages) && (p.versionName == null)) {
	            continue ;
	        }
	        PInfo newInfo = new PInfo();
	        newInfo.appname = p.applicationInfo.loadLabel(getPackageManager()).toString();
	        newInfo.pname = p.packageName;
	        newInfo.versionName = p.versionName;
	        newInfo.versionCode = p.versionCode;
	        newInfo.icon = p.applicationInfo.loadIcon(getPackageManager());
	        res.add(newInfo);
	    }
	    return res; 
	}

}
