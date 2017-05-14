package id.ipaddr.android.rereso.data.database;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;
import io.reactivex.Observable;

/**
 * Created by iip on 4/29/17.
 */

public class CertificateOfBirthDataDatabaseImpl implements CertificateOfBirthDataDatabase {

    private final Context mContext;
    private final ContentResolver mContentResolver;
    private final Gson mGson;

    @Inject
    public CertificateOfBirthDataDatabaseImpl(@NonNull Context context, @NonNull ContentResolver contentResolver, @NonNull Gson gson){
        this.mContext = context;
        this.mContentResolver = contentResolver;
        this.mGson = gson;
    }

    @Override
    public Observable<List<CertificateOfBirthDataEntity>> getCertificateOfBirthDataEntityList() {
        return Observable.create(emitter -> {
            Cursor cursor = null;
            try {
                cursor = mContentResolver.query(DbContract.TableEntry.CONTENT_TASK_URI, DbContract.TableEntry.PROJECTION, null, null, null);
                List<CertificateOfBirthDataEntity> entities = new ArrayList<CertificateOfBirthDataEntity>();
                while (cursor.moveToNext()){
                    String id = cursor.getString(cursor.getColumnIndex(DbContract.TableEntry.COLUMN_NAME_ENTRY_ID));
                    String jsonData = cursor.getString(cursor.getColumnIndex(DbContract.TableEntry.COLUMN_NAME_ENTITY_JSON));
                    CertificateOfBirthDataEntity entity = mGson.fromJson(jsonData, CertificateOfBirthDataEntity.class);
                    entity.setId(id);
                    entities.add(entity);
                }
                cursor.setNotificationUri(mContentResolver, DbContract.TableEntry.CONTENT_TASK_URI);
                emitter.onNext(entities);
                emitter.onComplete();
            } catch (Exception e){
                emitter.onError(e);
            } finally {
                cursor.close();
            }
        });
    }

    @Override
    public Observable<CertificateOfBirthDataEntity> getCertificateOfBirthDataEntity(String id) {
        return Observable.create(emitter -> {
            Cursor cursor = null;
            try {
                cursor = mContentResolver.query(DbContract.TableEntry.CONTENT_TASK_URI, DbContract.TableEntry.PROJECTION, null, null, null);
                while (cursor.moveToNext()){
                    String theId = cursor.getString(cursor.getColumnIndex(DbContract.TableEntry.COLUMN_NAME_ENTRY_ID));
                    String jsonData = cursor.getString(cursor.getColumnIndex(DbContract.TableEntry.COLUMN_NAME_ENTITY_JSON));
                    CertificateOfBirthDataEntity entity = mGson.fromJson(jsonData, CertificateOfBirthDataEntity.class);
                    entity.setId(id);
                    cursor.setNotificationUri(mContentResolver, DbContract.TableEntry.CONTENT_TASK_URI);
                    emitter.onNext(entity);
                    emitter.onComplete();
                }
            } catch (Exception e){
                emitter.onError(e);
            } finally {
                cursor.close();
            }
        });
    }

    @Override
    public Observable<CertificateOfBirthDataEntity> setCertificateOfBirthDataEntity(@NonNull CertificateOfBirthDataEntity certificateOfBirthDataEntity) {
        return Observable.create(emitter -> {
            String id  = certificateOfBirthDataEntity.getId();
            String jsonData = mGson.toJson(certificateOfBirthDataEntity, CertificateOfBirthDataEntity.class);
            ContentValues contentValues = new ContentValues();
            contentValues.put(DbContract.TableEntry.COLUMN_NAME_ENTRY_ID, id);
            contentValues.put(DbContract.TableEntry.COLUMN_NAME_ENTITY_JSON, jsonData);
            Uri uri = mContentResolver.insert(DbContract.TableEntry.CONTENT_TASK_URI, contentValues);
            mContentResolver.notifyChange(uri, null);
            emitter.onNext(certificateOfBirthDataEntity);
            emitter.onComplete();
        });
    }
}
