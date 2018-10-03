package com.dkotama.udayanaojsreader.view.register;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.presenter.register.RegisterContract;
import com.dkotama.udayanaojsreader.presenter.register.RegisterPresenter;
import com.dkotama.udayanaojsreader.view.common.BaseActivity;
import com.dkotama.udayanaojsreader.view.login.LoginActivity;

public class RegisterActivity extends BaseActivity implements RegisterContract.View {

    RegisterContract.Presenter presenter;
    Button registerBtn;
    EditText username, password;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        presenter = new RegisterPresenter(this);

        setTitle("");

        registerBtn = findViewById(R.id.btn_register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressbar);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableInput();
                presenter.doRegister(username.getText().toString(), password.getText().toString());
            }
        });

    }

    private void enableInput() {
        username.setVisibility(View.VISIBLE);
        password.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        registerBtn.setEnabled(true);
    }

    private void disableInput() {
        username.setVisibility(View.INVISIBLE);
        password.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        registerBtn.setEnabled(false);
    }

    @Override
    public void onRegisterSuccess() {
        enableInput();

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        };

        AlertDialog.Builder builder = makeDialogBuilder("Anda akan diarahkan ke halaman login",
                "Registrasi Sukses", listener);

        builder.create().show();
    }

    @Override
    public void onRegisterFailed(String message) {
        enableInput();
        makeError(message, "Error").show();
    }
}
