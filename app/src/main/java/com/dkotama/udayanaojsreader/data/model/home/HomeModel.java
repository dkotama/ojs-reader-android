package com.dkotama.udayanaojsreader.data.model.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dkotama on 19/09/18.
 */

public class HomeModel {
    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("data")
    @Expose
    private HomeData data;

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public HomeData getData() {
        return data;
    }
}
