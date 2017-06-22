package id.ipaddr.android.rereso.presentation.presenter;

import javax.inject.Inject;

import id.ipaddr.android.rereso.domain.exception.DefaultErrorBundle;
import id.ipaddr.android.rereso.domain.interactor.DefaultObserver;
import id.ipaddr.android.rereso.domain.interactor.SetCertificateOfBirthDataDetail;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.presentation.mapper.CertificateOfBirthDataModelDataMapper;
import id.ipaddr.android.rereso.presentation.view.CertificateOfBirthDataSetDetailView;

/**
 * Created by iip on 3/27/17.
 */

public class CertificateOfBirthDataSetDetailPresenter implements Presenter {

    private static final String TAG = CertificateOfBirthDataSetDetailPresenter.class.getSimpleName();

    private CertificateOfBirthDataSetDetailView mCertificateOfBirthDataSetDetailView;

    private final SetCertificateOfBirthDataDetail mSetCertificateOfBirthDataDetail;
    private final CertificateOfBirthDataModelDataMapper mCertificateOfBirthDataModelDataMapper;
    private CertificateOfBirthData mCertificateOfBirthData;

    public synchronized CertificateOfBirthData getCertificateOfBirthData() {
        if (mCertificateOfBirthData == null)
            mCertificateOfBirthData = new CertificateOfBirthData();
        return mCertificateOfBirthData;
    }

    public void setCertificateOfBirthData(CertificateOfBirthData certificateOfBirthData) {
        this.mCertificateOfBirthData = certificateOfBirthData;
    }

    @Inject
    public CertificateOfBirthDataSetDetailPresenter(SetCertificateOfBirthDataDetail setCertificateOfBirthDataDetail,
                                                  CertificateOfBirthDataModelDataMapper certificateOfBirthDataModelDataMapper){
        mSetCertificateOfBirthDataDetail = setCertificateOfBirthDataDetail;
        mCertificateOfBirthDataModelDataMapper = certificateOfBirthDataModelDataMapper;
    }

    /**
     * Initializes the presenter by showing/hiding proper views
     * and retrieving certificate of data details.
     */
    public void initialize(){
        this.setCertificateOfBirthDataDetail();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mSetCertificateOfBirthDataDetail.dispose();
        mCertificateOfBirthDataSetDetailView = null;
    }

    private void setCertificateOfBirthDataDetail(){
        mSetCertificateOfBirthDataDetail.execute(new CertificateOfBirthDataDetailObserver(), null);
    }

    private final class CertificateOfBirthDataDetailObserver extends DefaultObserver<CertificateOfBirthData> {
        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
        }

        @Override
        public void onNext(CertificateOfBirthData certificateOfBirthData) {
            super.onNext(certificateOfBirthData);
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }
    }

}
