package com.dkotama.udayanaojsreader.common;

/**
 * Created by dkotama on 16/09/18.
 */

public class Constant {
//    public static String SERVER_URL = "http://localhost:5001/api/";
//    public static String PICTURE_URL = "http://localhost:5001/covers/";
    final public static String API_STRING = "adaee10e829e9faea5c33cc386525ccc";
    public static String SERVER_URL = "https://young-falls-91410.herokuapp.com/api/";
    public static String PICTURE_URL = "https://young-falls-91410.herokuapp.com/covers/";

    public static String ELSEVIER_URL = "https://api.elsevier.com/";
//    public static String PICTURE_URL = "https://young-falls-91410.herokuapp.com/covers/";


    // Filename
    final public static String REALM_FILENAME = "ojsreader_db.realm";
    final public static String PREFERENCE_FILENAME = "ojsreader_preference";


    // Action
    final public static String ACTION_LOGIN = "login";
    final public static String ACTION_REGISTER = "register";
    final public static String ACTION_SEARCH_SCIDIR = "content/search/scidir";
    final public static String ACTION_ELSEVIER_JOURNALS = "serial/title";
//    final public static String ACTION_JOURNALS = "journals";
    public static final String ACTION_LATEST_ISSUE = "latest" ;
    public static final String ACTION_ALL_ISSUE = "issues" ;
    public static final String ACTION_PAPERS = "papers" ;

    // Static Values
    public static final int HOME_ITEM_AMOUNT = 10 ;
}
