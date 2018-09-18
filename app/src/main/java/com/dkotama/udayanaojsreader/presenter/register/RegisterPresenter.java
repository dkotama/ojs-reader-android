package com.dkotama.udayanaojsreader.presenter.register;

import android.util.Log;

import com.dkotama.udayanaojsreader.data.handler.login.LoginHandler;
import com.dkotama.udayanaojsreader.data.model.login.LoginData;
import com.dkotama.udayanaojsreader.presenter.login.LoginContract;

/**
 * Created by dkotama on 16/09/18.
 */

public class RegisterPresenter implements LoginContract.Presenter {
    private LoginContract.View view;

    public RegisterPresenter(LoginContract.View v) {
        this.view = v;
    }

    @Override
    public void doLogin(String username, String password) {
        LoginHandler handler = new LoginHandler(this);

        handler.doService(username, password);
    }

    @Override
    public void loginSuccess(LoginData loginData) {
        // save to preference
        Log.d("LoginPresenter", "loginSuccess: " + loginData.getUsername() + ", " + loginData.getPassword());
        view.onLoginSuccess();
    }

    @Override
    public void loginFailed(String message) {
        view.onLoginFailed(message);
    }
}
