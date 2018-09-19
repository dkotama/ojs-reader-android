package com.dkotama.udayanaojsreader.presenter.login;

import android.util.Log;

import com.dkotama.udayanaojsreader.common.UserPreference;
import com.dkotama.udayanaojsreader.data.handler.login.LoginHandler;
import com.dkotama.udayanaojsreader.data.model.login.LoginData;

/**
 * Created by dkotama on 16/09/18.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View view;

    public LoginPresenter(LoginContract.View v) {
        this.view = v;
    }

    @Override
    public void doLogin(String username, String password) {
        LoginHandler handler = new LoginHandler(this);

        handler.doService(username, password);
    }

    @Override
    public void loginSuccess(LoginData loginData) {
        UserPreference preference  = new UserPreference();

        preference.write(UserPreference.USER_ID, loginData.getId());
        preference.write(UserPreference.USERNAME, loginData.getUsername());

        view.onLoginSuccess();
    }

    @Override
    public void loginFailed(String message) {
        view.onLoginFailed(message);
    }
}
