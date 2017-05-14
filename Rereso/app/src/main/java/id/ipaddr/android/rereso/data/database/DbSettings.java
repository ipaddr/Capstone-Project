package id.ipaddr.android.rereso.data.database;

import android.net.Uri;

import id.ipaddr.android.rereso.BuildConfig;

/**
 * Created by iip on 3/19/17.
 */

public class DbSettings {

    // Db Helper
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "certificateofbirth.db";
    public static final String TEXT_TYPE = " TEXT";
    public static final String BOOLEAN_TYPE = " INTEGER";
    public static final String COMMA_SEP = ",";

    // Contract
    public static final String TABLE_NAME = "certificateofbirth";
    public static final String COLUM_NAME_ENTRY_ID = "entryid";
    public static final String COLUM_NAME_ENTITY_JSON = "jsonofcertificateofbirth";
    public static final String COLUM_NAME_LAST_MODIFIED_DATE = "last_mod_date";
    public static final String COLUM_NAME_SYNC_STATE = "sync_state";

    // content provider
    // Adding content provider variable here
    public static final String CONTENT_AUTHORITY = BuildConfig.APPLICATION_ID;
    public static final String CONTENT_TASK_TYPE = "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
    public static final String CONTENT_TASK_ITEM_TYPE = "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
    public static final String VND_ANDROID_CURSOR_ITEM_VND = "vnd.android.cursor.item/vnd." + CONTENT_AUTHORITY + ".";
    private static final String CONTENT_SCHEME = "content://";
    public static final Uri BASE_CONTENT_URI = Uri.parse(CONTENT_SCHEME + CONTENT_AUTHORITY);
    private static final String VND_ANDROID_CURSOR_DIR_VND = "vnd.android.cursor.dir/vnd." + CONTENT_AUTHORITY + ".";
    private static final String SEPARATOR = "/";

}
