package com.dkotama.udayanaojsreader.data.model.favorite;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by dkotama on 23/10/18.
 */

public class FavouriteRealmData extends RealmObject {
    @PrimaryKey
    private int id;

    private String identifier;
    private String title;
    private String creator;
    private String publicationName;
    private String issn;
    private String doi;
    private String teaser;

    public FavouriteRealmData() {}

    public FavouriteRealmData(FavouriteData data) {
        this.id = data.getId();
        this.title = data.getTitle();
        this.creator = data.getCreator();
        this.publicationName = data.getPublicationName();
        this.issn = data.getIssn();
        this.doi = data.getIdentifier();
        this.identifier = data.getIdentifier();
        this.teaser = data.getTeaser();
    }

    public int getId() {
        return id;
    }

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
}
