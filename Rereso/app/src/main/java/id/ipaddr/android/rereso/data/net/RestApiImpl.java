package id.ipaddr.android.rereso.data.net;

/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;
import id.ipaddr.android.rereso.data.entity.mapper.CertificateOfBirthDataEntityJsonMapper;
import id.ipaddr.android.rereso.data.exception.NetworkConnectionException;
import id.ipaddr.android.rereso.domain.model.Address;
import id.ipaddr.android.rereso.domain.model.Baby;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthForm;
import id.ipaddr.android.rereso.domain.model.Citizen;
import id.ipaddr.android.rereso.domain.model.EBirthHelper;
import id.ipaddr.android.rereso.domain.model.ECertificateOfBirthState;
import id.ipaddr.android.rereso.domain.model.ECitizenship;
import id.ipaddr.android.rereso.domain.model.EPlaceOfBirth;
import id.ipaddr.android.rereso.domain.model.ESex;
import id.ipaddr.android.rereso.domain.model.ETypeOfBirth;
import id.ipaddr.android.rereso.util.NetworkUtil;
import id.ipaddr.android.rereso.util.TestClass;
import io.reactivex.Observable;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * {@link RestApi} implementation for retrieving data from the network.
 */
public class RestApiImpl implements RestApi {

    private final Context context;
    private final CertificateOfBirthDataEntityJsonMapper mJsonMapper;

    /**
     * Constructor of the class
     *
     * @param context {@link android.content.Context}.
     * @param jsonMapper {@link CertificateOfBirthDataEntityJsonMapper}.
     */
    public RestApiImpl(Context context, CertificateOfBirthDataEntityJsonMapper jsonMapper) {
        if (context == null || jsonMapper == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        this.context = context.getApplicationContext();
        this.mJsonMapper = jsonMapper;
    }

    @Override
    public Observable<List<CertificateOfBirthDataEntity>> certificateOfBirthDataEntityList() {
        return Observable.create(emitter -> {
            if (NetworkUtil.isThereInternetConnection(context)) {
                try {
                    String responseUserEntities = getUserEntitiesFromApi();
                    if (responseUserEntities != null) {
                        emitter.onNext(mJsonMapper.transformJsonToCertificateOfBirthDataEntityCollection(
                                responseUserEntities));
                        emitter.onComplete();
                    } else {
                        emitter.onError(new NetworkConnectionException());
                    }
                } catch (Exception e) {
                    emitter.onError(new NetworkConnectionException(e.getCause()));
                }
            } else {
                emitter.onError(new NetworkConnectionException());
            }
        });
    }

    @Override public Observable<CertificateOfBirthDataEntity> CertificateOfBirthDataEntityById(final String userId) {
        return Observable.create(emitter -> {
            if (NetworkUtil.isThereInternetConnection(context)) {
                try {
                    String responseUserDetails = getUserDetailsFromApi(userId);
                    if (responseUserDetails != null) {
                        emitter.onNext(mJsonMapper.transformJsonToCertificateOfBirthDataEntity(responseUserDetails));
                        emitter.onComplete();
                    } else {
                        emitter.onError(new NetworkConnectionException());
                    }
                } catch (Exception e) {
                    emitter.onError(new NetworkConnectionException(e.getCause()));
                }
            } else {
                emitter.onError(new NetworkConnectionException());
            }
        });
    }

    private String getUserEntitiesFromApi() throws MalformedURLException {
        return ApiConnection.createGET(API_URL_GET_USER_LIST).requestSyncCall();
    }

    private String getUserDetailsFromApi(String userId) throws MalformedURLException {
        String apiUrl = API_URL_GET_USER_DETAILS + userId + ".json";
        return ApiConnection.createGET(apiUrl).requestSyncCall();
    }

}
