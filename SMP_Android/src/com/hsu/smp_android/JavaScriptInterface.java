package com.hsu.smp_android;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class JavaScriptInterface {
    private Activity activity;

    public JavaScriptInterface(Activity activiy) {
        this.activity = activiy;
    }

    public void get_html_value(String value){
    Log.e("my",value);//LOG¦¬¨ìªº­È
    }
}