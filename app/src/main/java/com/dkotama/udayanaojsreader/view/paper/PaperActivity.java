package com.dkotama.udayanaojsreader.view.paper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.dkotama.udayanaojsreader.R;
import com.github.barteksc.pdfviewer.PDFView;

public class PaperActivity extends AppCompatActivity {

    PDFView pdfView;
    String pdfUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper);

        pdfView = findViewById(R.id.pdf_viewer);

        pdfUrl = getIntent().getStringExtra("pdfUrl");

        Toast.makeText(this, pdfUrl, Toast.LENGTH_SHORT).show();
    }
}
