package com.dkotama.udayanaojsreader.data.handler.common;

/**
 * Created by dkotama on 18/09/18.
 */

import com.dkotama.udayanaojsreader.common.Constant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by KOTEMON on 2/12/2018.
 */

public class ScidirBaseHandler extends BaseHandler {
    protected Retrofit.Builder createRetrofit() {
        // intercept

        return new Retrofit.Builder()
                .baseUrl(Constant.ELSEVIER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient.build());
    }
}
