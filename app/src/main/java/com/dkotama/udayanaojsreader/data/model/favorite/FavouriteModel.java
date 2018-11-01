package com.dkotama.udayanaojsreader.data.model.favorite;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dkotama on 19/09/18.
 */

public class FavouriteModel {
    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("data")
    @Expose
    private FavouriteData data;

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public FavouriteData getData() {
        return data;
    }
}
