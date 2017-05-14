package id.ipaddr.android.rereso.data.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;
import id.ipaddr.android.rereso.data.repository.datasource.CertificateOfBirthDataDataStore;
import io.reactivex.Observable;

/**
 * Created by iip on 4/29/17.
 */

public interface CertificateOfBirthDataDatabase {
    /**
     *  Get an {@link Observable} which will emit a List of {@link CertificateOfBirthDataEntity}.
     *
     *  @return
     */
    Observable<List<CertificateOfBirthDataEntity>> getCertificateOfBirthDataEntityList();

    /**
     * Get an {@link Observable} which will emit a {@link CertificateOfBirthDataEntity} by its id.
     *
     * @param id
     * @return
     */
    Observable<CertificateOfBirthDataEntity> getCertificateOfBirthDataEntity(String id);

    /**
     * Set an {@link Observable} which will emit a {@link CertificateOfBirthDataEntity} by its id.
     *
     * @param certificateOfBirthDataEntity
     * @return
     */
    Observable<CertificateOfBirthDataEntity> setCertificateOfBirthDataEntity(@NonNull CertificateOfBirthDataEntity certificateOfBirthDataEntity);
}
