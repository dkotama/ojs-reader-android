package com.dkotama.udayanaojsreader.data.model.issue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dkotama on 19/09/18.
 */

public class LatestIssueModel {
    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("data")
    @Expose
    private IssueData data;

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public IssueData getData() {
        return data;
    }
}
