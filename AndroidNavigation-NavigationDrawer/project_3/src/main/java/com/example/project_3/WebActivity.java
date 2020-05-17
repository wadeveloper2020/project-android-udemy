package com.example.project_3;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    ProgressDialog progress;
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progress = new ProgressDialog(WebActivity.this);
        progress.setMessage("Waiting...");
        progress.show();

        webView = findViewById(R.id.webview);

        webView.loadUrl("https://www.google.com");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progress.dismiss();
                getSupportActionBar().setTitle(webView.getTitle());
            }
        });
    }

    @Override

    public void onBackPressed() {

        if (webView.canGoBack()){
            webView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
