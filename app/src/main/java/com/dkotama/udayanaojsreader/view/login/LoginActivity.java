package com.dkotama.udayanaojsreader.view.login;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.presenter.login.LoginContract;
import com.dkotama.udayanaojsreader.presenter.login.LoginPresenter;
import com.dkotama.udayanaojsreader.view.common.CommonActivity;
import com.dkotama.udayanaojsreader.view.register.RegisterActivity;


public class LoginActivity extends CommonActivity implements LoginContract.View {

    Button loginBtn;
    TextView registerBtn;
    EditText username, password;
    ProgressBar progressBar;
    LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);
        registerBtn = findViewById(R.id.register_text);
        loginBtn = findViewById(R.id.btn_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressbar);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoRegister();
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableInput();
                presenter.doLogin(username.getText().toString(),
                        password.getText().toString());
            }
        });
    }

    @Override
    public void onLoginSuccess() {
        enableInput();

        // temporary demo for login success
        android.support.v7.app.AlertDialog.Builder builder = makeDialogBuilder("Selamat Datang", "Login Sukses", null);
        builder.create().show();
    }

    @Override
    public void onLoginFailed(String message) {
        enableInput();
        makeError(message, "error").show();
    }

    // Private Function
    private void gotoRegister() {
        Intent intent = new Intent(getBaseContext(), RegisterActivity.class);
        startActivity(intent);
    }

    private void gotoHome() {
        Intent intent = new Intent(getBaseContext(), RegisterActivity.class);
        startActivity(intent);
    }

    private void disableInput () {
        username.setVisibility(View.INVISIBLE);
        password.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        loginBtn.setEnabled(false);
    }

    private void enableInput() {
        username.setVisibility(View.VISIBLE);
        password.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        loginBtn.setEnabled(true);
    }
}
