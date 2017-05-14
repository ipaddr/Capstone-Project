package id.ipaddr.android.rereso.domain.interactor;

import com.google.common.base.Preconditions;

import javax.inject.Inject;

import id.ipaddr.android.rereso.domain.executor.PostExecutionThread;
import id.ipaddr.android.rereso.domain.executor.ThreadExecutor;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.domain.repository.CertificateOfBirthDataRepository;
import io.reactivex.Observable;

/**
 * Created by iip on 3/19/17.
 *
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving data related to an specific {@link GetCertificateOfBirthDataList}.
 */

public class GetCertificateOfBirthDataDetail
        extends UseCase<CertificateOfBirthData, GetCertificateOfBirthDataDetail.Params>{


    private final CertificateOfBirthDataRepository mRepository;

    @Inject
    GetCertificateOfBirthDataDetail(CertificateOfBirthDataRepository repository
            , ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread){
        super(threadExecutor, postExecutionThread);
        mRepository = repository;
    }

    @Override
    Observable<CertificateOfBirthData> buildUseCaseObservable(Params params) {
        Preconditions.checkNotNull(params);
        return mRepository.getCertificateOfBirthData(params.mId);
    }

    public static final class Params{
        private final String mId;
        private Params(String id){
            mId = id;
        }
        public static Params fromCertificateOfBirthData(String id){
            return new Params(id);
        }

    }

}
