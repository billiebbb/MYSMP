package com.hsu.smp_android;

import android.graphics.drawable.Drawable;
import android.util.Log;

public class PInfo {
	    public String appname = "";
	    public String pname = "";
	    public String versionName = "";
	    public int versionCode = 0;
	    public Drawable icon;
	    public void prettyPrint() {
	        Log.v("PInfo",appname + "\t" + pname + "\t" + versionName + "\t" + versionCode);
	    }
}
