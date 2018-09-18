package com.dkotama.udayanaojsreader.data.model.login;

/**
 * Created by dkotama on 16/09/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginModel {
    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("data")
    @Expose
    private LoginData data;

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public LoginData getData() {
        return data;
    }
}
