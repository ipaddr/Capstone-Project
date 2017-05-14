package id.ipaddr.android.rereso.presentation.presenter;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import javax.inject.Inject;

import id.ipaddr.android.rereso.domain.interactor.GetCertificateOfBirthDataList;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.presentation.mapper.CertificateOfBirthDataModelDataMapper;
import id.ipaddr.android.rereso.presentation.view.CertificateOfBirthDataSetDetailView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by iip on 3/27/17.
 */

public class CertificateOfBirthDataSetDetailPresenter implements Presenter {

    private static final String TAG = CertificateOfBirthDataSetDetailPresenter.class.getSimpleName();

    public void save(){
        Log.d(TAG, "save");
    }

    private CertificateOfBirthDataSetDetailView mCertificateOfBirthDataListView;

    private Observer mySubscriber = new Observer() {

        @Override
        public void onSubscribe(Disposable d) {
            Log.d(TAG, "onSubscribe");
        }

        @Override
        public void onNext(Object o) {
            Log.d(TAG, "onNext");
        }

        @Override
        public void onError(Throwable e) {
            Log.d(TAG, "onError");
        }

        @Override
        public void onComplete() {
            Log.d(TAG, "onComplete");
        }
    };

    private final GetCertificateOfBirthDataList mGetCertificateOfBirthDataList;
    private final CertificateOfBirthDataModelDataMapper mCertificateOfBirthDataModelDataMapper;
    private CertificateOfBirthData mCertificateOfBirthData;
    public CertificateOfBirthData getCertificateOfBirthData() {
        if (mCertificateOfBirthData == null)
            mCertificateOfBirthData = new CertificateOfBirthData();
        return mCertificateOfBirthData;
    }

    public void setCertificateOfBirthData(CertificateOfBirthData certificateOfBirthData) {
        this.mCertificateOfBirthData = certificateOfBirthData;
    }

    @Inject
    public CertificateOfBirthDataSetDetailPresenter(GetCertificateOfBirthDataList certificateOfBirthDataList,
                                                  CertificateOfBirthDataModelDataMapper certificateOfBirthDataModelDataMapper){
        mGetCertificateOfBirthDataList = certificateOfBirthDataList;
        mCertificateOfBirthDataModelDataMapper = certificateOfBirthDataModelDataMapper;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    public Observer getObserver(){
        return mySubscriber;
    }

}
