package com.dkotama.udayanaojsreader.data.handler.login;

import android.util.Log;

import com.dkotama.udayanaojsreader.data.handler.common.BaseHandler;
import com.dkotama.udayanaojsreader.data.model.login.LoginModel;
import com.dkotama.udayanaojsreader.presenter.login.LoginContract;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dkotama on 18/09/18.
 */

public class LoginHandler extends BaseHandler {
    private LoginContract.Presenter presenter;
    private String TAG = "LoginHandler";

    public LoginHandler(LoginContract.Presenter presenter) {
        super();
        this.presenter = presenter;
    }

    public void doService(String username, String password) {
        LoginContract.API api = createRetrofit().build().create(LoginContract.API.class);
        Single<LoginModel> data = api.postLogin(username, password);

        try {
            data.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleObserver<LoginModel>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            Log.d(TAG, "onSubscribe: ");
                        }

                        @Override
                        public void onSuccess(LoginModel model) {
                            Log.d(TAG, "onSuccess: ");
                            String errMessage = model.getError();

                            if (errMessage != null) {
                                presenter.loginFailed("Something Error");
                            } else {
                                presenter.loginSuccess(model.getData());
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            presenter.loginFailed("Unregistered or Wrong Password");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
