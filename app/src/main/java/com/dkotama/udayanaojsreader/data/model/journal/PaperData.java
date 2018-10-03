package com.dkotama.udayanaojsreader.data.model.journal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dkotama on 19/09/18.
 */

public class PaperData {
    @Expose
    @SerializedName("id")
    int id;

    @Expose
    @SerializedName("issue_id")
    int issueId;

    @Expose
    @SerializedName("title")
    String title;

    @Expose
    @SerializedName("authors")
    String authors;

    @Expose
    @SerializedName("abstract")
    String abstracts;

    @Expose
    @SerializedName("page")
    String page;

    @Expose
    @SerializedName("url")
    String url;

    public int getId() {
        return id;
    }

    public int getIssueId() {
        return issueId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public String getPage() {
        return page;
    }

    public String getUrl() {
        return url;
    }
}
