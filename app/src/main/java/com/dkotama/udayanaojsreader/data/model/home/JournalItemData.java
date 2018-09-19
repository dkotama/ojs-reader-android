package com.dkotama.udayanaojsreader.data.model.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dkotama on 19/09/18.
 */

public class JournalItemData {
    @Expose
    @SerializedName("id")
    int id;

    @Expose
    @SerializedName("name")
    String name;

    @Expose
    @SerializedName("description")
    String desc;

    @Expose
    @SerializedName("imageUrl")
    String imageUrl;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
