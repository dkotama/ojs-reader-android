package com.dkotama.udayanaojsreader.view.paper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import com.dkotama.udayanaojsreader.R;


public class PaperActivity extends AppCompatActivity {

    private WebView webView;
    public  String pdfUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper);
        pdfUrl = getIntent().getStringExtra("pdfUrl");

        String baseUrl = "https://docs.google.com/gview?";
        baseUrl += "url=" + pdfUrl + "&embedded=true";

        webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(baseUrl);

        Log.d("PaperActivity", "onCreate: " + baseUrl);
    }
}
