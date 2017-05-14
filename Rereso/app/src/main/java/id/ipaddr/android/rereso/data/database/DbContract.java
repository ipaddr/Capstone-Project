package id.ipaddr.android.rereso.data.database;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by iip on 3/19/17.
 *
 * The contract used for the db to save the model locally.
 */

public final class DbContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private DbContract(){}

    /* Inner class that defines the table contents */
    public static abstract class TableEntry implements BaseColumns{
        public static final String TABLE_NAME = DbSettings.TABLE_NAME;
        public static final String COLUMN_NAME_ENTRY_ID = DbSettings.COLUM_NAME_ENTRY_ID;
        public static final String COLUMN_NAME_ENTITY_JSON = DbSettings.COLUM_NAME_ENTITY_JSON;
        public static final String COLUMN_NAME_LAST_MODIFIED_DATE = DbSettings.COLUM_NAME_LAST_MODIFIED_DATE;
        public static final String COLUMN_NAME_SYNC_STATE = DbSettings.COLUM_NAME_SYNC_STATE;

        // adding content provider here
        public static final Uri CONTENT_TASK_URI = DbSettings.BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
        public static String[] TASKS_COLUMNS = new String[]{
                DbContract.TableEntry._ID,
                DbContract.TableEntry.COLUMN_NAME_ENTRY_ID,
                DbContract.TableEntry.COLUMN_NAME_ENTITY_JSON,
                DbContract.TableEntry.COLUMN_NAME_LAST_MODIFIED_DATE,
                DbContract.TableEntry.COLUMN_NAME_SYNC_STATE};

        public static Uri buildTasksUriWith(long id) {
            return ContentUris.withAppendedId(CONTENT_TASK_URI, id);
        }

        public static Uri buildTasksUriWith(String id) {
            Uri uri = CONTENT_TASK_URI.buildUpon().appendPath(id).build();
            return uri;
        }

        public static Uri buildTasksUri() {
            return CONTENT_TASK_URI.buildUpon().build();
        }

        public static String [] PROJECTION = {TABLE_NAME, COLUMN_NAME_ENTRY_ID,
                COLUMN_NAME_ENTITY_JSON, COLUMN_NAME_LAST_MODIFIED_DATE,
                COLUMN_NAME_SYNC_STATE};
    }
}
