package com.dkotama.udayanaojsreader.data.model.register;

/**
 * Created by dkotama on 16/09/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterModel {
    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("data")
    @Expose
    private RegisterData data;

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public RegisterData getData() {
        return data;
    }
}
