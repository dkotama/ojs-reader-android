package com.dkotama.udayanaojsreader.data.model.journal;

import com.dkotama.udayanaojsreader.data.model.home.HomeData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dkotama on 19/09/18.
 */

public class JournalModel {
    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("data")
    @Expose
    private JournalItemData data;

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public JournalItemData getData() {
        return data;
    }
}
