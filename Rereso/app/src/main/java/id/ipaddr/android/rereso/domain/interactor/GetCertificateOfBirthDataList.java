package id.ipaddr.android.rereso.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import id.ipaddr.android.rereso.domain.executor.PostExecutionThread;
import id.ipaddr.android.rereso.domain.executor.ThreadExecutor;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.domain.repository.CertificateOfBirthDataRepository;
import io.reactivex.Observable;

/**
 * Created by iip on 3/19/17.
 */

public class GetCertificateOfBirthDataList extends UseCase<List<CertificateOfBirthData>, Void> {

    private final CertificateOfBirthDataRepository mRepository;

    @Inject
    GetCertificateOfBirthDataList(CertificateOfBirthDataRepository repository
            , ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        mRepository = repository;
    }

    @Override
    Observable<List<CertificateOfBirthData>> buildUseCaseObservable(Void aVoid) {
        return mRepository.getCertificateOfBirthData();
    }
}
