package com.dkotama.udayanaojsreader.data.model.favorite;

import com.dkotama.udayanaojsreader.data.model.journal.JournalItemData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dkotama on 19/09/18.
 */

public class FavouriteListModel {
    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("data")
    @Expose
    private List<FavouriteData> data;

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public List<FavouriteData> getData() {
        return data;
    }
}
