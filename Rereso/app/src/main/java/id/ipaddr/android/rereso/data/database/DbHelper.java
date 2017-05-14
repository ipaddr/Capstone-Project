package id.ipaddr.android.rereso.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by iip on 3/19/17.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DbContract.TableEntry.TABLE_NAME + " (" +
                    DbContract.TableEntry._ID + DbSettings.TEXT_TYPE + " PRIMARY KEY," +
                    DbContract.TableEntry.COLUMN_NAME_ENTRY_ID + DbSettings.TEXT_TYPE + DbSettings.COMMA_SEP +
                    DbContract.TableEntry.COLUMN_NAME_ENTITY_JSON + DbSettings.TEXT_TYPE + DbSettings.COMMA_SEP +
                    DbContract.TableEntry.COLUMN_NAME_LAST_MODIFIED_DATE + DbSettings.TEXT_TYPE + DbSettings.COMMA_SEP +
                    DbContract.TableEntry.COLUMN_NAME_SYNC_STATE + DbSettings.TEXT_TYPE +
                    " )";

    public DbHelper(Context context) {
        super(context, DbSettings.DB_NAME, null, DbSettings.DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not required as at version 1
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not required as at version 1
    }

}
