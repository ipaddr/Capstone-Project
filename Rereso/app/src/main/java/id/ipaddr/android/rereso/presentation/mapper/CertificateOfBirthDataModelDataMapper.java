package id.ipaddr.android.rereso.presentation.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.presentation.internal.di.PerActivity;
import id.ipaddr.android.rereso.presentation.model.CertificateOfBirthDataModel;

/**
 * Created by iip on 3/21/17.
 */

@PerActivity
public class CertificateOfBirthDataModelDataMapper {

    @Inject
    public CertificateOfBirthDataModelDataMapper(){}

    /**
     * Transform a {@link CertificateOfBirthData} into an {@link CertificateOfBirthDataModel}
     *
     * @param certificateOfBirthData
     * @return
     */
    public CertificateOfBirthDataModel transform(CertificateOfBirthData certificateOfBirthData){
        return new CertificateOfBirthDataModel(certificateOfBirthData);
    }

    /**
     * Transform a collection {@link CertificateOfBirthData} into a collection of {@link CertificateOfBirthDataModel}
     *
     * @param dataCollections
     * @return
     */
    public Collection<CertificateOfBirthDataModel> transform(Collection<CertificateOfBirthData> dataCollections){
        Collection<CertificateOfBirthDataModel> dataModelCollections;

        if (dataCollections != null && !dataCollections.isEmpty()) {
            dataModelCollections = new ArrayList<>();
            for (CertificateOfBirthData data : dataCollections) {
                dataModelCollections.add(transform(data));
            }
        } else {
            dataModelCollections = Collections.emptyList();
        }

        return dataModelCollections;
    }
}
