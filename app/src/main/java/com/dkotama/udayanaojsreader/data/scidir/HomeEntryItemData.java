package com.dkotama.udayanaojsreader.data.scidir;

import com.dkotama.udayanaojsreader.common.Constant;

/**
 * Created by dkotama on 23/10/18.
 */

public class HomeEntryItemData extends SearchEntryItemData {

    public String getCoverImageUrl() {
        return "https://api.elsevier.com/content/serial/title/issn/" + this.getIssn()
                + "?view=coverimage&httpAccept=image%2Fgif&apiKey=" + Constant.API_STRING;
    }

    public String getPdfUrl() {
       return  "http://api.elsevier.com/content/article/doi/" + this.getDoi() +
               "?httpAccept=application%2Fpdf&apiKey=" + Constant.API_STRING;
    }
}
