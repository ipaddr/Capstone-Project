package id.ipaddr.android.rereso.presentation.view;

import id.ipaddr.android.rereso.presentation.model.CertificateOfBirthDataModel;

/**
 * Created by iip on 3/27/17.
 */

public interface CertificateOfBirthDataSetDetailView {
    /**
     * Render a user in the UI.
     *
     * @param model The {@link CertificateOfBirthDataModel} that will be shown.
     */
    void renderCertificateOfBirthData(CertificateOfBirthDataModel model);
}
