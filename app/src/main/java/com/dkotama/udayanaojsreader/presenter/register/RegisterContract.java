package com.dkotama.udayanaojsreader.presenter.register;

import com.dkotama.udayanaojsreader.common.Constant;
import com.dkotama.udayanaojsreader.data.model.register.RegisterData;
import com.dkotama.udayanaojsreader.data.model.register.RegisterModel;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 *
 *  Created by dkotama on 16/09/18.
 */

public interface RegisterContract {
    interface View {
        void onRegisterSuccess();
        void onRegisterFailed(String message);
    }

    interface Presenter{
        void doRegister(String username, String password);
        void registerSuccess(RegisterData registerData);
        void registerFailed(String message);
    }

    interface API {
        @FormUrlEncoded
        @POST(Constant.ACTION_REGISTER)
        Single<RegisterModel> postRegister(
                @Field("username") String username,
                @Field("password") String password);
    }
}
