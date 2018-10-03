package com.dkotama.udayanaojsreader.data.model.journal;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dkotama on 19/09/18.
 */

public class JournalItemData implements Parcelable {
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

    protected JournalItemData(Parcel in) {
        id = in.readInt();
        name = in.readString();
        desc = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<JournalItemData> CREATOR = new Creator<JournalItemData>() {
        @Override
        public JournalItemData createFromParcel(Parcel in) {
            return new JournalItemData(in);
        }

        @Override
        public JournalItemData[] newArray(int size) {
            return new JournalItemData[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeString(imageUrl);
    }
}
