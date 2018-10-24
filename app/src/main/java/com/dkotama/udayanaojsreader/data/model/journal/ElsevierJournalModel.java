package com.dkotama.udayanaojsreader.data.model.journal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dkotama on 19/09/18.
 */

public class ElsevierJournalModel {


    @SerializedName("serial-metadata-response")
    @Expose
    private MetadataResponseData data;


    public class MetadataResponseData {
        @Expose
        @SerializedName("entry")
        List<ElsevierJournalItemData> journals;

        public List<ElsevierJournalItemData> getJournals() {
            return journals;
        }
    }


    public MetadataResponseData getData() {
        return data;
    }
}
