package com.dkotama.udayanaojsreader.data.scidir;

import com.dkotama.udayanaojsreader.common.Constant;

import io.realm.RealmModel;

/**
 * Created by dkotama on 23/10/18.
 */

public class HomeEntryItemData extends ArticleItemData implements RealmModel {
    private Boolean favorited = false;
    private int id = 0;

    public String getCoverImageUrl() {
        return "https://api.elsevier.com/content/serial/title/issn/" + this.getIssn()
                + "?view=coverimage&httpAccept=image%2Fgif&apiKey=" + Constant.API_STRING;
    }

    public String getPdfUrl() {
       return  "http://api.elsevier.com/content/article/doi/" + this.getDoi() +
               "?httpAccept=application%2Fpdf&apiKey=" + Constant.API_STRING;
    }

    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




}
