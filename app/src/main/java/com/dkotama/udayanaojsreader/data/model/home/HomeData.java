package com.dkotama.udayanaojsreader.data.model.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dkotama on 19/09/18.
 */

public class HomeData {
    @Expose
    @SerializedName("page")
    int page;

    @Expose
    @SerializedName("journals")
    List<JournalItemData> journals;

    public int getPage() {
        return page;
    }

    public List<JournalItemData> getJournals() {
        return journals;
    }
}
