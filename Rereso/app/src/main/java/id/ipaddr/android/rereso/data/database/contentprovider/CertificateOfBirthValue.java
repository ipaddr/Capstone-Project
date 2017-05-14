package id.ipaddr.android.rereso.data.database.contentprovider;

import android.content.ContentValues;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;
import id.ipaddr.android.rereso.data.entity.mapper.CertificateOfBirthDataEntityJsonMapper;
import id.ipaddr.android.rereso.data.database.DbContract;

/**
 * Created by iip on 3/19/17.
 */

public class CertificateOfBirthValue {

    private final CertificateOfBirthDataEntityJsonMapper mCertificateOfBirthDataEntityJsonMapper;

    @Inject CertificateOfBirthValue(@NonNull CertificateOfBirthDataEntityJsonMapper certificateOfBirthDataEntityJsonMapper){
        mCertificateOfBirthDataEntityJsonMapper = certificateOfBirthDataEntityJsonMapper;
    }

    public ContentValues from(CertificateOfBirthDataEntity certificateOfBirthDataEntity) {
        ContentValues values = new ContentValues();
        values.put(DbContract.TableEntry.COLUMN_NAME_ENTRY_ID, certificateOfBirthDataEntity.getId());
        values.put(DbContract.TableEntry.COLUMN_NAME_ENTITY_JSON, mCertificateOfBirthDataEntityJsonMapper.transformCertificateOfBirthDataEntityToJson(certificateOfBirthDataEntity));
        return values;
    }

    public String data(CertificateOfBirthDataEntity certificateOfBirthDataEntity){
        return mCertificateOfBirthDataEntityJsonMapper.transformCertificateOfBirthDataEntityToJson(certificateOfBirthDataEntity);
    }

}
