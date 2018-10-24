package com.dkotama.udayanaojsreader.data.model.journal;

import com.dkotama.udayanaojsreader.data.model.common.ElsevierJournalLinkData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dkotama on 12/10/18.
 */

public class ElsevierJournalItemData {
    @Expose
    @SerializedName("prism:issn")
    String issn;

    @Expose
    @SerializedName("dc:title")
    String title;

    @Expose
    @SerializedName("dc:publisher")
    String publisher;

    @Expose
    @SerializedName("link")
    List<ElsevierJournalLinkData> links;


    public String getIssn() {
        return issn;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public List<ElsevierJournalLinkData> getLinks() {
        return links;
    }

    public String toString()  {
        return "{ " +
                "issn: " + issn +
                ",title: " + title+
                ",publisher: " + publisher + "}";
    }
}


