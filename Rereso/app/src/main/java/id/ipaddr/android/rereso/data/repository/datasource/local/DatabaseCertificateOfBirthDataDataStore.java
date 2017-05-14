package id.ipaddr.android.rereso.data.repository.datasource.local;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import id.ipaddr.android.rereso.data.database.CertificateOfBirthDataDatabase;
import id.ipaddr.android.rereso.data.database.DbContract;
import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;
import id.ipaddr.android.rereso.data.repository.datasource.CertificateOfBirthDataDataStore;
import io.reactivex.Observable;

/**
 * Created by iip on 4/29/17.
 */

public class DatabaseCertificateOfBirthDataDataStore implements CertificateOfBirthDataDataStore {

    private CertificateOfBirthDataDatabase mCertificateOfBirthDataDatabase;

    public DatabaseCertificateOfBirthDataDataStore(@NonNull CertificateOfBirthDataDatabase certificateOfBirthDataDatabase){
        this.mCertificateOfBirthDataDatabase = certificateOfBirthDataDatabase;
    }

    @Override
    public Observable<List<CertificateOfBirthDataEntity>> getCertificateOfBirthDataEntityList() {
        return this.mCertificateOfBirthDataDatabase.getCertificateOfBirthDataEntityList();
    }

    @Override
    public Observable<CertificateOfBirthDataEntity> getCertificateOfBirthDataEntity(String id) {
        return this.mCertificateOfBirthDataDatabase.getCertificateOfBirthDataEntity(id);
    }

    @Override
    public Observable<CertificateOfBirthDataEntity> setCertificateOfBirthDataEntity(@NonNull CertificateOfBirthDataEntity certificateOfBirthDataEntity) {
        return this.mCertificateOfBirthDataDatabase.setCertificateOfBirthDataEntity(certificateOfBirthDataEntity);
    }
}
