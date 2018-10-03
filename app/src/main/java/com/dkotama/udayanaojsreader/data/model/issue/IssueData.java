package com.dkotama.udayanaojsreader.data.model.issue;

import com.dkotama.udayanaojsreader.data.model.paper.PaperData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dkotama on 19/09/18.
 */

public class IssueData {
    @Expose
    @SerializedName("id")
    int id;

    @Expose
    @SerializedName("volume")
    int volume;

    @Expose
    @SerializedName("number")
    int number;

    @Expose
    @SerializedName("year")
    int year;

    @Expose
    @SerializedName("startMonth")
    String startMonth;

    @Expose
    @SerializedName("endMonth")
    String endMonth;

    @Expose
    @SerializedName("publishedDate")
    String publishedDate;

    @Expose
    @SerializedName("papers")
    List<PaperData> papers;

    public int getId() {
        return id;
    }

    public int getVolume() {
        return volume;
    }

    public int getNumber() {
        return number;
    }

    public int getYear() {
        return year;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public List<PaperData> getPapers() {
        return papers;
    }
}
