package com.dkotama.udayanaojsreader.data.model.issue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dkotama on 19/09/18.
 */

public class AllIssueModel {
    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("data")
    @Expose
    private List<IssueData> data;

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public List<IssueData> getData() {
        return data;
    }
}
