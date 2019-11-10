package com.example.ngdngcbovirss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class NewsActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        webView = (WebView) findViewById(R.id.WedViewTinTuc);
        Intent intent = getIntent();
        String s = intent.getStringExtra("linktintuc");
        //Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        webView.loadUrl(s);
        webView.setWebViewClient(new WebViewClient());   // giu lai o lai app khi click vao link khac
        WebSettings webSettings =webView.getSettings();
        webSettings.setBuiltInZoomControls(true);     // zoom han hinh
        webSettings.setDisplayZoomControls(false);    // k hien thi thanh zoom cua trang web
        webSettings.setJavaScriptEnabled(true);       // mo chu cnag de mo trang wed co javascript, vd: neu k co dong nay thi se k mo dc youtobe
    }
}
