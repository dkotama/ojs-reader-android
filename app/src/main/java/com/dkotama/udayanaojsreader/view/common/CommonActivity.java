package com.dkotama.udayanaojsreader.view.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.presenter.login.LoginContract;
import com.dkotama.udayanaojsreader.view.register.RegisterActivity;


public class CommonActivity extends AppCompatActivity {
//    protected AlertDialog errorDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected AlertDialog makeError(String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setCancelable(false);
        dialog.setTitle("Error");
        dialog.setMessage(message);
        dialog.setPositiveButton("OK", null);

        return dialog.create();
    }

}
