package id.ipaddr.android.rereso.presentation.presenter;

import android.support.annotation.NonNull;

import com.google.firebase.database.FirebaseDatabase;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import id.ipaddr.android.rereso.domain.exception.DefaultErrorBundle;
import id.ipaddr.android.rereso.domain.exception.ErrorBundle;
import id.ipaddr.android.rereso.domain.interactor.DefaultObserver;
import id.ipaddr.android.rereso.domain.interactor.GetCertificateOfBirthDataList;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.presentation.exception.ErrorMessageFactory;
import id.ipaddr.android.rereso.presentation.mapper.CertificateOfBirthDataModelDataMapper;
import id.ipaddr.android.rereso.presentation.model.CertificateOfBirthDataModel;
import id.ipaddr.android.rereso.presentation.view.CertificateOfBirthDataListView;

/**
 * Created by iip on 3/19/17.
 *
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */

public class CertificateOfBirthDataGetListPresenter implements Presenter {

    private CertificateOfBirthDataListView mCertificateOfBirthDataListView;

    private final GetCertificateOfBirthDataList mGetCertificateOfBirthDataList;
    private final CertificateOfBirthDataModelDataMapper mCertificateOfBirthDataModelDataMapper;

    @Inject
    public CertificateOfBirthDataGetListPresenter(GetCertificateOfBirthDataList certificateOfBirthDataList,
                                                  CertificateOfBirthDataModelDataMapper certificateOfBirthDataModelDataMapper){
        mGetCertificateOfBirthDataList = certificateOfBirthDataList;
        mCertificateOfBirthDataModelDataMapper = certificateOfBirthDataModelDataMapper;
    }

    public void setView(@NonNull CertificateOfBirthDataListView certificateOfBirthDataListView){
        mCertificateOfBirthDataListView = certificateOfBirthDataListView;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mGetCertificateOfBirthDataList.dispose();
        mCertificateOfBirthDataListView = null;
    }

    public void initialize(){
        this.loadCertificateOfBirthDataList();
    }

    private void loadCertificateOfBirthDataList() {
        hideViewRetry();
        showViewLoading();
        getCertificateOfBirthDataList();
    }

    private void getCertificateOfBirthDataList() {
        mGetCertificateOfBirthDataList.execute(new CertificateOfBirthListObserver(), null);
    }

    public void onCertificateOfBirthDataClicked(CertificateOfBirthDataModel model){
        mCertificateOfBirthDataListView.viewCertificateOfBirth(model);
    }

    private void showViewLoading() {
        mCertificateOfBirthDataListView.showLoading();
    }

    private void hideViewLoading(){
        mCertificateOfBirthDataListView.hideLoading();
    }

    private void showViewRetry(){
        mCertificateOfBirthDataListView.showRetry();
    }

    private void hideViewRetry() {
        mCertificateOfBirthDataListView.hideLoading();
    }

    private void showErrorMessage(ErrorBundle errorBundle){
        String errorMessage = ErrorMessageFactory.create(mCertificateOfBirthDataListView.context(), errorBundle.getException());
        mCertificateOfBirthDataListView.showError(errorMessage);
    }

    private void showUserCollectionInView(Collection<CertificateOfBirthData> certificateOfBirthDatas){
        final Collection<CertificateOfBirthDataModel> finalCertificateOfBirthDatas =
                mCertificateOfBirthDataModelDataMapper.transform(certificateOfBirthDatas);
        mCertificateOfBirthDataListView.renderCertificateOfBirthList(finalCertificateOfBirthDatas);
    }

    public final class CertificateOfBirthListObserver extends DefaultObserver<List<CertificateOfBirthData>>{
        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
            hideViewLoading();
            showErrorMessage(new DefaultErrorBundle((Exception )exception));
            showViewRetry();
        }

        @Override
        public void onNext(List<CertificateOfBirthData> certificateOfBirthDatas) {
            super.onNext(certificateOfBirthDatas);
            showUserCollectionInView(certificateOfBirthDatas);
        }

        @Override
        public void onComplete() {
            super.onComplete();
            hideViewLoading();
        }
    }


}
