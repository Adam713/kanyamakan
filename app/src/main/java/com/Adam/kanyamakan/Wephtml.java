package com.Adam.kanyamakan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class Wephtml extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wephtml);

        WebView webView = (WebView)findViewById(R.id.web_view);

        Intent Data = getIntent();

        int page = Data.getExtras().getInt("page");
        page++;
        webView.loadUrl("file:///android_asset/html/" + page +".html" );
    }
}