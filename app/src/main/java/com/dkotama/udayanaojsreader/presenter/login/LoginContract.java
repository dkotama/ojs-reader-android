package com.dkotama.udayanaojsreader.presenter.login;

import com.dkotama.udayanaojsreader.common.Constant;
import com.dkotama.udayanaojsreader.data.model.login.LoginData;
import com.dkotama.udayanaojsreader.data.model.login.LoginModel;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 *
 *  Created by dkotama on 16/09/18.
 */

public interface LoginContract {
    interface View {
        void onLoginSuccess();
        void onLoginFailed(String message);
    }

    interface Presenter{
        void doLogin(String username, String password);
        void loginSuccess(LoginData loginData);
        void loginFailed(String message);
    }

    interface API {
        @FormUrlEncoded
        @POST(Constant.ACTION_LOGIN)
        Single<LoginModel> postLogin(
                @Field("username") String username,
                @Field("password") String password);
    }
}
