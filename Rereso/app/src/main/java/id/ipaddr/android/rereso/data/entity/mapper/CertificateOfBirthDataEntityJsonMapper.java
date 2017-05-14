package id.ipaddr.android.rereso.data.entity.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;

/**
 * Created by iip on 3/19/17.
 *
 * Class used to transform from Strings representing json to valid objects.
 */

public class CertificateOfBirthDataEntityJsonMapper {

    private final Gson mGson;

    @Inject
    public CertificateOfBirthDataEntityJsonMapper(){
        mGson = new Gson();
    }

    /**
     * Transform from valid json string to List of {@link CertificateOfBirthDataEntity}.
     *
     * @param userListJsonResponse A json representing a collection of users.
     * @return List of {@link CertificateOfBirthDataEntity}.
     * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
     */
    public List<CertificateOfBirthDataEntity> transformJsonToCertificateOfBirthDataEntityCollection(String userListJsonResponse)
            throws JsonSyntaxException {
        final Type listOfCertificateOfBirthDataEntityType = new TypeToken<List<CertificateOfBirthDataEntity>>() {}.getType();
        return mGson.fromJson(userListJsonResponse, listOfCertificateOfBirthDataEntityType);
    }

    /**
     * Transform from List of {@link CertificateOfBirthDataEntity} to valid json string.
     *
     * @param certificateOfBirthDataEntities
     * @return
     * @throws JsonSyntaxException
     */
    public String transformCertificateOfBirthDataEntityToJson(List<CertificateOfBirthDataEntity> certificateOfBirthDataEntities) throws JsonSyntaxException{
        final Type listOfCertificateOfBirthDataEntityType = new TypeToken<List<CertificateOfBirthDataEntity>>() {}.getType();
        return mGson.toJson(certificateOfBirthDataEntities, listOfCertificateOfBirthDataEntityType);
    }

    /**
     * Transform from valid json string to {@link CertificateOfBirthDataEntity}.
     *
     * @param userJsonResponse A json representing a user profile.
     * @return {@link CertificateOfBirthDataEntity}.
     * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
     */
    public CertificateOfBirthDataEntity transformJsonToCertificateOfBirthDataEntity(String userJsonResponse) throws JsonSyntaxException {
        final Type certificateOfBirthDataEntityType = new TypeToken<CertificateOfBirthDataEntity>() {}.getType();
        return mGson.fromJson(userJsonResponse, certificateOfBirthDataEntityType);
    }

    /**
     * Transform from {@link CertificateOfBirthDataEntity} to valid json string.
     *
     * @param certificateOfBirthDataEntity
     * @return
     * @throws JsonSyntaxException
     */
    public String transformCertificateOfBirthDataEntityToJson(CertificateOfBirthDataEntity certificateOfBirthDataEntity) throws JsonSyntaxException{
        final Type certificateOfBirthDataEntityType = new TypeToken<CertificateOfBirthDataEntity>() {}.getType();
        return mGson.toJson(certificateOfBirthDataEntity, certificateOfBirthDataEntityType);
    }

}
