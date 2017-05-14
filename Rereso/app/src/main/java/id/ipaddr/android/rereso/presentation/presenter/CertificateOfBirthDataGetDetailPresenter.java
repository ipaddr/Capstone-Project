package id.ipaddr.android.rereso.presentation.presenter;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import id.ipaddr.android.rereso.domain.exception.DefaultErrorBundle;
import id.ipaddr.android.rereso.domain.exception.ErrorBundle;
import id.ipaddr.android.rereso.domain.interactor.DefaultObserver;
import id.ipaddr.android.rereso.domain.interactor.GetCertificateOfBirthDataDetail;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.presentation.exception.ErrorMessageFactory;
import id.ipaddr.android.rereso.presentation.mapper.CertificateOfBirthDataModelDataMapper;
import id.ipaddr.android.rereso.presentation.model.CertificateOfBirthDataModel;
import id.ipaddr.android.rereso.presentation.view.CertificateOfBirthDataDetailView;

/**
 * Created by iip on 3/23/17.
 */

public class CertificateOfBirthDataGetDetailPresenter implements Presenter {

    private CertificateOfBirthDataDetailView mCertificateOfBirthDataDetailView;

    private final GetCertificateOfBirthDataDetail mGetCertificateOfBirthDataDetail;
    private final CertificateOfBirthDataModelDataMapper mCertificateOfBirthDataModelDataMapper;

    @Inject public CertificateOfBirthDataGetDetailPresenter(GetCertificateOfBirthDataDetail getCertificateOfBirthDataDetail
            , CertificateOfBirthDataModelDataMapper certificateOfBirthDataModelDataMapper){
        mGetCertificateOfBirthDataDetail = getCertificateOfBirthDataDetail;
        mCertificateOfBirthDataModelDataMapper = certificateOfBirthDataModelDataMapper;
    }

    public void setView(@NonNull CertificateOfBirthDataDetailView view){
        mCertificateOfBirthDataDetailView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mGetCertificateOfBirthDataDetail.dispose();
        mCertificateOfBirthDataDetailView = null;
    }

    /**
     * Initializes the presenter by showing/hiding proper views
     * and retrieving certificate of data details.
     */
    public void initialize(String id){
        this.hideViewRetry();
        this.showViewLoading();
        this.getCertificateOfBirthDataDetail(id);
    }

    private void getCertificateOfBirthDataDetail(String id){
        mGetCertificateOfBirthDataDetail.execute(new CertificateOfBirthDataDetailObserver(), GetCertificateOfBirthDataDetail.Params.fromCertificateOfBirthData(id));
    }

    private void showViewLoading(){
        mCertificateOfBirthDataDetailView.showLoading();
    }

    private void hideViewLoading(){
        mCertificateOfBirthDataDetailView.hideLoading();
    }

    private void showViewRetry(){
        mCertificateOfBirthDataDetailView.showRetry();
    }

    private void hideViewRetry(){
        mCertificateOfBirthDataDetailView.hideRetry();
    }

    private void showErrorMessage(ErrorBundle errorBundle){
        String errorMessage = ErrorMessageFactory.create(mCertificateOfBirthDataDetailView.context(), errorBundle.getException());
        mCertificateOfBirthDataDetailView.showError(errorMessage);
    }

    private void showCertificateOfBirthDataDetailInView(CertificateOfBirthData certificateOfBirthData){
        final CertificateOfBirthDataModel certificateOfBirthDataModel = mCertificateOfBirthDataModelDataMapper.transform(certificateOfBirthData);
        mCertificateOfBirthDataDetailView.renderCertificateOfBirthData(certificateOfBirthDataModel);
    }

    private final class CertificateOfBirthDataDetailObserver extends DefaultObserver<CertificateOfBirthData>{
        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
            hideViewLoading();
            showErrorMessage(new DefaultErrorBundle((Exception)exception));
            showViewRetry();
        }

        @Override
        public void onNext(CertificateOfBirthData certificateOfBirthData) {
            super.onNext(certificateOfBirthData);
            showCertificateOfBirthDataDetailInView(certificateOfBirthData);
        }

        @Override
        public void onComplete() {
            super.onComplete();
            hideViewLoading();
        }
    }
}
