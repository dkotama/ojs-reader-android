package com.dkotama.udayanaojsreader.data.model.favorite;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dkotama on 23/10/18.
 */

public class FavouriteData {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("dc:identifier")
    @Expose
    private String identifier;

    @SerializedName("dc:title")
    @Expose
    private String title;

    @SerializedName("dc:creator")
    @Expose
    private String creator;

    @SerializedName("prism:publicationName")
    @Expose
    private String publicationName;

    @SerializedName("prism:issn")
    @Expose
    private String issn;

    @SerializedName("prism:doi")
    @Expose
    private String doi;

    @SerializedName("prism:teaser")
    @Expose
    private String teaser;

    public String getIdentifier() {
        return identifier;
    }

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    public String getPublicationName() {
        return publicationName;
    }

    public String getIssn() {
        return issn;
    }

    public String getDoi() {
        return doi;
    }

    public String getTeaser() {
        return teaser;
    }

    public int getId() {
        return id;
    }
}
