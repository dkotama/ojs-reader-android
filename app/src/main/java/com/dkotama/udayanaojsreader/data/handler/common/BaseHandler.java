package com.dkotama.udayanaojsreader.data.handler.common;

/**
 * Created by dkotama on 18/09/18.
 */

import android.util.Log;

import com.dkotama.udayanaojsreader.common.Constant;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by KOTEMON on 2/12/2018.
 */

public class BaseHandler {
    private final static int CACHE_SIZE = 10*1024*1024;

    protected Map<String, String> postParams = new HashMap<>();
    protected Map<String, String> getParams = new HashMap<>();
    protected Map<String, String> headerParams = new HashMap<>();
    protected OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
    private static Retrofit retrofit;

    private HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

    //Errors Message

    public BaseHandler() {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient.addInterceptor(logging);
    }

    protected Retrofit.Builder createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constant.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient.build());
    }

    public void doService() {}

//    protected void translateThrowable(Throwable e) {
//        if (e instanceof IOException) {
//            pushError(ErrorType.NO_CONNECTION);
//        } else if (e instanceof SocketTimeoutException) {
//            pushError(ErrorType.NO_CONNECTION);
//        } else {
//            pushError(ErrorType.CRITICAL);
//        }
//    }

//    protected MultipartBody.Part createMultipartFile(String type, File file, String formName) {
//        RequestBody reqFile = RequestBody.create(MediaType.parse(type), file);
//        return  MultipartBody.Part.createFormData(formName, file.getName(), reqFile);
//    }

//    protected void pushError(ErrorType errorType) {}

    public OkHttpClient.Builder getOkHttpClient() {
        return okHttpClient;
    }

    public void setOkHttpClient(OkHttpClient.Builder okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public Map<String, String> getPostParams() {
        return postParams;
    }

    public void setPostParams(Map<String, String> postParams) {
        this.postParams = postParams;
    }

    public Map<String, String> getGetParams() {
        return getParams;
    }

    public void setGetParams(Map<String, String> getParams) {
        this.getParams = getParams;
    }

    public Map<String, String> getHeaderParams() {
        return headerParams;
    }

    public void setHeaderParams(Map<String, String> headerParams) {
        Log.d("Handler", "setHeaderParams: " + headerParams.toString());
        this.headerParams = headerParams;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public void setLogLevel(HttpLoggingInterceptor.Level level) {
        logging.setLevel(level);
    }
}
