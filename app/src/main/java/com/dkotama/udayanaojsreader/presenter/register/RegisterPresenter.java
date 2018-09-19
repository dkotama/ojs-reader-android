package com.dkotama.udayanaojsreader.presenter.register;

import android.util.Log;

import com.dkotama.udayanaojsreader.data.handler.login.LoginHandler;
import com.dkotama.udayanaojsreader.data.handler.register.RegisterHandler;
import com.dkotama.udayanaojsreader.data.model.login.LoginData;
import com.dkotama.udayanaojsreader.data.model.register.RegisterData;
import com.dkotama.udayanaojsreader.presenter.login.LoginContract;

/**
 * Created by dkotama on 16/09/18.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View view;

    public RegisterPresenter(RegisterContract.View v) {
        this.view = v;
    }

    @Override
    public void doRegister(String username, String password) {
        RegisterHandler handler = new RegisterHandler(this);

        handler.doService(username, password);
    }

    @Override
    public void registerSuccess(RegisterData registerData) {
        view.onRegisterSuccess();
    }

    @Override
    public void registerFailed(String message) {
        view.onRegisterFailed(message);
    }

}
