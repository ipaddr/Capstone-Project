package id.ipaddr.android.rereso.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import id.ipaddr.android.rereso.domain.executor.PostExecutionThread;
import id.ipaddr.android.rereso.domain.executor.ThreadExecutor;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.domain.repository.CertificateOfBirthDataRepository;
import io.reactivex.Observable;

/**
 * Created by iip on 3/26/17.
 */

public class SetCertificateOfBirthDataDetail extends UseCase<CertificateOfBirthData, CertificateOfBirthData>  {

    private final CertificateOfBirthDataRepository mRepository;

    @Inject
    SetCertificateOfBirthDataDetail(CertificateOfBirthDataRepository repository
            , ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        mRepository = repository;
    }

    @Override
    Observable<CertificateOfBirthData> buildUseCaseObservable(CertificateOfBirthData certificateOfBirthData) {
        return mRepository.setCertificateOfBirthData(certificateOfBirthData);
    }
}
