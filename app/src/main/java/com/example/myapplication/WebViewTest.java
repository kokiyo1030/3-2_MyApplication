package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewTest extends AppCompatActivity {
    WebView mWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewtest);

        mWeb = (WebView)findViewById(R.id.web);
        mWeb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                super.shouldOverrideUrlLoading(view, url);
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings setting = mWeb.getSettings();
        setting.setJavaScriptEnabled(true);
        setting.setBuiltInZoomControls(true);
        mWeb.loadUrl("https://www.google.com");
    }
    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.btngo:
                String url;
                EditText addr = (EditText)findViewById(R.id.address);
                url = addr.getText().toString();
                mWeb.loadUrl(url);
                break;
            case R.id.btnback:
                if (mWeb.canGoBack()) {
                    mWeb.goBack();
                }
                break;
            case R.id.btnforward:
                if (mWeb.canGoForward()) {
                    mWeb.goForward();
                }
                break;
            case R.id.btnlocal:
                mWeb.loadUrl("file:///android_asset/test.html");
                break;
        }
    }
}