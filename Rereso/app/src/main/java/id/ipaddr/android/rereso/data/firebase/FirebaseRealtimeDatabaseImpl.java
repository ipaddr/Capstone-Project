package id.ipaddr.android.rereso.data.firebase;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.reactivestreams.Subscription;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;
import id.ipaddr.android.rereso.data.exception.NetworkConnectionException;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.domain.model.DocumentRequired;
import id.ipaddr.android.rereso.util.NetworkUtil;
import id.ipaddr.android.rereso.util.TestClass;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by iip on 3/24/17.
 */

public class FirebaseRealtimeDatabaseImpl {

    private static final String TAG = FirebaseRealtimeDatabaseImpl.class.getSimpleName();

    private final Context mContext;
    private final DatabaseReference mDatabaseReference;

    public FirebaseRealtimeDatabaseImpl(@NonNull  Context context
            , @NonNull DatabaseReference databaseReference){
        mContext = context;
        mDatabaseReference = databaseReference;
    }

    public Observable<List<CertificateOfBirthDataEntity>> getCertificateOfBirthDataEntityList() {
        return Observable.create(emitter -> {
            if (NetworkUtil.isThereInternetConnection(mContext)) {
                Log.d(TAG, "if");
                try {
                    Log.d(TAG, "try");
                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Log.d(TAG, "onDataChange");
                            List<CertificateOfBirthDataEntity> entities = new ArrayList<CertificateOfBirthDataEntity>();
                            Iterator<DataSnapshot> iterator = dataSnapshot.getChildren().iterator();
                            while (iterator.hasNext()){
                                DataSnapshot ds = iterator.next();
                                String id = ds.getKey();
                                CertificateOfBirthDataEntity entity = ds.getValue(CertificateOfBirthDataEntity.class);
                                entity.setId(id);
                                entities.add(entity);
                            }
                            emitter.onNext(entities);
                            emitter.onComplete();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.d(TAG, "onCancelled");
                            emitter.onError(new NetworkConnectionException());
                        }
                    });
                } catch (Exception e) {
                    Log.d(TAG, "catch");
                    emitter.onError(new NetworkConnectionException(e.getCause()));
                }
            } else {
                Log.d(TAG, "else");
                emitter.onError(new NetworkConnectionException());
            }
        });
    }

    public Observable<CertificateOfBirthDataEntity> getCertificateOfBirthDataEntity(String id) {
        Log.d(TAG, "I am here");
        return Observable.create(emitter -> {
            if (NetworkUtil.isThereInternetConnection(mContext)) {
                Log.d(TAG, "if");
                try {
                    Log.d(TAG, "try");
                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Log.d(TAG, "onDataChange");
                            CertificateOfBirthDataEntity finalEntity = null;
                            Iterator<DataSnapshot> iterator = dataSnapshot.getChildren().iterator();
                            while (iterator.hasNext()){
                                DataSnapshot ds = iterator.next();
                                if (ds.getKey().equals(id)) {
                                    CertificateOfBirthDataEntity entity = ds.getValue(CertificateOfBirthDataEntity.class);
                                    finalEntity = entity;
                                    break;
                                }
                            }
                            emitter.onNext(finalEntity);
                            emitter.onComplete();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.d(TAG, "onCancelled");
                            emitter.onError(new NetworkConnectionException());
                        }
                    });
                } catch (Exception e) {
                    Log.d(TAG, "catch");
                    emitter.onError(new NetworkConnectionException(e.getCause()));
                }
            } else {
                Log.d(TAG, "else");
                emitter.onError(new NetworkConnectionException());
            }
        });
    }

    public Observable<CertificateOfBirthDataEntity> setCertificateOfBirthDataEntity(@NonNull CertificateOfBirthDataEntity inEntity){
        return Observable.create(emitter -> {
            if (NetworkUtil.isThereInternetConnection(mContext)) {
                Log.d(TAG, "if");
                try {
                    saveImage(inEntity);
//                    emitter.onNext(inEntity);
//                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(new NetworkConnectionException(e.getCause()));
                }
            } else {
                emitter.onError(new NetworkConnectionException());
            }
        });
    }

    public void saveImage(CertificateOfBirthDataEntity cd){

        List<UploadTask> uploadTasks = new ArrayList<>();
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();

        DocumentRequired householdRecommendationLetter = cd.getHouseholdRecommendationLetter();
        uploadDocumentRequired(uploadTasks, storageRef, householdRecommendationLetter);

        DocumentRequired familyIdentityCard = cd.getFamilyIdentityCard();
        uploadDocumentRequired(uploadTasks, storageRef, familyIdentityCard);

        DocumentRequired fatherIdCard = cd.getFatherIdCard();
        uploadDocumentRequired(uploadTasks, storageRef, fatherIdCard);

        DocumentRequired motherIdCard = cd.getMotherIdCard();
        uploadDocumentRequired(uploadTasks, storageRef, motherIdCard);

        DocumentRequired maritalCertificateLetter = cd.getMaritalCertificateLetter();
        uploadDocumentRequired(uploadTasks, storageRef, maritalCertificateLetter);

        DocumentRequired fatherCertificateOfBirth = cd.getFatherCertificateOfBirth();
        uploadDocumentRequired(uploadTasks, storageRef, fatherCertificateOfBirth);

        DocumentRequired motherCertificateOfBirth = cd.getMotherCertificateOfBirth();
        uploadDocumentRequired(uploadTasks, storageRef, motherCertificateOfBirth);

        DocumentRequired fatherPassport = cd.getFatherPassport();
        uploadDocumentRequired(uploadTasks, storageRef, fatherPassport);

        DocumentRequired motherPassport = cd.getMotherPassport();
        uploadDocumentRequired(uploadTasks, storageRef, motherPassport);

        DocumentRequired firstSpectatorIdCard = cd.getFirstSpectatorIdCard();
        uploadDocumentRequired(uploadTasks, storageRef, firstSpectatorIdCard);

        DocumentRequired secondSpectatorIdCard = cd.getSecondSpectatorIdCard();
        uploadDocumentRequired(uploadTasks, storageRef, secondSpectatorIdCard);

        DocumentRequired policeCertificateForUnfamiliyBaby = cd.getPoliceCertificateForUnfamiliyBaby();
        uploadDocumentRequired(uploadTasks, storageRef, policeCertificateForUnfamiliyBaby);

        DocumentRequired socialServicesCertificateForVulnerableResidents = cd.getSocialServicesCertificateForVulnerableResidents();
        uploadDocumentRequired(uploadTasks, storageRef, socialServicesCertificateForVulnerableResidents);

        DocumentRequired imgOfCertificateOfBirthForm = cd.getImgOfCertificateOfBirthForm();
        uploadDocumentRequired(uploadTasks, storageRef, imgOfCertificateOfBirthForm);

        UploadTask[] arrayUploadTasks = new UploadTask[uploadTasks.size()];
        arrayUploadTasks = uploadTasks.toArray(arrayUploadTasks);

        Observable.fromArray(arrayUploadTasks).doOnNext(new Consumer<UploadTask>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull UploadTask uploadTask) throws Exception {
                Log.d(TAG, "onSubscribe");
            }
        }).subscribe(new Observer<UploadTask>() {
            boolean isSaveData = false;
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(UploadTask uploadTask) {
                Log.d(TAG, "onNext");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
                saveData(cd);
            }
        });

    }

    private void uploadDocumentRequired(List<UploadTask> uploadTasks, StorageReference storageRef, DocumentRequired dr){
        if (dr.getDocumentImageURI() != null) {
            uploadTasks.add(upload(storageRef, dr));
        }
    }

    private UploadTask upload(StorageReference storageRef, DocumentRequired dr){
        Uri uri = Uri.fromFile(new File(dr.getDocumentImageURI()));
        StorageReference riversRef = storageRef.child("rereso-img/"+uri.getLastPathSegment());
        UploadTask uploadTask = riversRef.putFile(uri);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "fail");
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Log.d(TAG, "onSuccess");
                Uri downloadUrl = taskSnapshot.getDownloadUrl();
                dr.setDocumentImageURI(downloadUrl.toString());
            }
        });
        return uploadTask;
    }

    private void saveData(CertificateOfBirthDataEntity certificateOfBirthDataEntity){
        DatabaseReference dbr = FirebaseDatabase.getInstance().getReference(CertificateOfBirthData.class.getSimpleName());
        dbr.push().setValue(certificateOfBirthDataEntity);
    }
}
