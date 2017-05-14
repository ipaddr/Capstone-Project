package id.ipaddr.android.rereso.presentation.view;

import android.content.Context;

import java.util.Collection;

import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.presentation.model.CertificateOfBirthDataModel;

/**
 * Created by iip on 3/19/17.
 */

public interface CertificateOfBirthDataListView extends LoadDataView {

    /**
     * Render a certificate of birth list in the UI.
     *
     * @param dataModels The collection of {@link CertificateOfBirthDataModel} that will be shown.
     */
    void renderCertificateOfBirthList(Collection<CertificateOfBirthDataModel> dataModels);

    /**
     * View a {@link CertificateOfBirthDataModel} profile/details.
     *
     * @param model The user that will be shown.
     */
    void viewCertificateOfBirth(CertificateOfBirthDataModel model);

}
