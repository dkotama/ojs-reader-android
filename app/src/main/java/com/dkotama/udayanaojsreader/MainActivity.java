package com.dkotama.udayanaojsreader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dkotama.udayanaojsreader.view.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent =  new Intent(getBaseContext(), LoginActivity.class);
        startActivity(intent);
        finishAffinity();
    }
}
