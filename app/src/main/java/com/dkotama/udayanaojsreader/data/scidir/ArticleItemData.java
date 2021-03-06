package com.dkotama.udayanaojsreader.data.scidir;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by dkotama on 23/10/18.
 */

public class ArticleItemData {
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

    public String toString() {
        return "{ " +
//                "issn: " + issn +
//                ", doi: " + doi +
                ", identifier: " + identifier +

//                ", title: " + title +
//                ", creator: " + creator +
//                ", publicationName: " + publicationName + " }";
         "};";
    }
}
