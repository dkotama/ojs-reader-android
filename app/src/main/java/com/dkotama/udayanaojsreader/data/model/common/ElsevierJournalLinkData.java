package com.dkotama.udayanaojsreader.data.model.common;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dkotama on 19/09/18.
 */

public class ElsevierJournalLinkData {
    // coverimage, homepage, scopus-source

    @Expose
    @SerializedName("@ref")
    String reference;

    @Expose
    @SerializedName("@href")
    String url;
}
