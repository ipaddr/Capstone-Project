package id.ipaddr.android.rereso.data.database.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import id.ipaddr.android.rereso.data.database.DbContract;
import id.ipaddr.android.rereso.data.database.DbHelper;
import id.ipaddr.android.rereso.data.database.DbSettings;

/**
 * Created by iip on 3/19/17.
 */

public class CertificateOfBirthProvider extends ContentProvider {

    private static final int CERTIFICATEOFBIRTH = 100;
    private static final int CERTIFICATEOFBIRTH_ITEM = 101;
    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private DbHelper mDbHelper;

    private static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = DbSettings.CONTENT_AUTHORITY;

        matcher.addURI(authority, DbContract.TableEntry.TABLE_NAME, CERTIFICATEOFBIRTH);
        matcher.addURI(authority, DbContract.TableEntry.TABLE_NAME + "/*", CERTIFICATEOFBIRTH_ITEM);

        return matcher;
    }

    @Override
    public boolean onCreate() {
        mDbHelper = new DbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case CERTIFICATEOFBIRTH:
                return DbSettings.CONTENT_TASK_TYPE;
            case CERTIFICATEOFBIRTH_ITEM:
                return DbSettings.CONTENT_TASK_ITEM_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor retCursor;
        switch (sUriMatcher.match(uri)) {
            case CERTIFICATEOFBIRTH:
                retCursor = mDbHelper.getReadableDatabase().query(
                        DbContract.TableEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            case CERTIFICATEOFBIRTH_ITEM:
                String[] where = {uri.getLastPathSegment()};
                retCursor = mDbHelper.getReadableDatabase().query(
                        DbContract.TableEntry.TABLE_NAME,
                        projection,
                        DbContract.TableEntry.COLUMN_NAME_ENTRY_ID + " = ?",
                        where,
                        null,
                        null,
                        sortOrder
                );
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        retCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return retCursor;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        final SQLiteDatabase db = mDbHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        Uri returnUri;

        switch (match) {
            case CERTIFICATEOFBIRTH:
                Cursor exists = db.query(
                        DbContract.TableEntry.TABLE_NAME,
                        new String[]{DbContract.TableEntry.COLUMN_NAME_ENTRY_ID},
                        DbContract.TableEntry.COLUMN_NAME_ENTRY_ID + " = ?",
                        new String[]{values.getAsString(DbContract.TableEntry.COLUMN_NAME_ENTRY_ID)},
                        null,
                        null,
                        null
                );
                if (exists.moveToLast()) {
                    long _id = db.update(
                            DbContract.TableEntry.TABLE_NAME, values,
                            DbContract.TableEntry.COLUMN_NAME_ENTRY_ID + " = ?",
                            new String[]{values.getAsString(DbContract.TableEntry.COLUMN_NAME_ENTRY_ID)}
                    );
                    if (_id > 0) {
                        returnUri = DbContract.TableEntry.buildTasksUriWith(_id);
                    } else {
                        throw new android.database.SQLException("Failed to insert row into " + uri);
                    }
                } else {
                    long _id = db.insert(DbContract.TableEntry.TABLE_NAME, null, values);
                    if (_id > 0) {
                        returnUri = DbContract.TableEntry.buildTasksUriWith(_id);
                    } else {
                        throw new android.database.SQLException("Failed to insert row into " + uri);
                    }
                }
                exists.close();
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return returnUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        final SQLiteDatabase db = mDbHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int rowsDeleted;

        switch (match) {
            case CERTIFICATEOFBIRTH:
                rowsDeleted = db.delete(
                        DbContract.TableEntry.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        if (selection == null || rowsDeleted != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsDeleted;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        final SQLiteDatabase db = mDbHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int rowsUpdated;

        switch (match) {
            case CERTIFICATEOFBIRTH:
                rowsUpdated = db.update(DbContract.TableEntry.TABLE_NAME, values, selection,
                        selectionArgs
                );
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        if (rowsUpdated != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsUpdated;
    }
}
