package id.ipaddr.android.rereso.data.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;
import id.ipaddr.android.rereso.data.exception.NetworkConnectionException;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.util.NetworkUtil;
import id.ipaddr.android.rereso.util.TestClass;
import io.reactivex.Observable;

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
//                TestClass.test();
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
        Log.d(TAG, "I am here");
        return Observable.create(emitter -> {
            if (NetworkUtil.isThereInternetConnection(mContext)) {
                Log.d(TAG, "if");
                try {
                    pushData(inEntity);
                    Log.d(TAG, "try");
                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Log.d(TAG, "onDataChange");
                            CertificateOfBirthDataEntity finalEntity = null;
                            Iterator<DataSnapshot> iterator = dataSnapshot.getChildren().iterator();
                            while (iterator.hasNext()){
                                DataSnapshot ds = iterator.next();
                                CertificateOfBirthDataEntity entity = ds.getValue(CertificateOfBirthDataEntity.class);
                                if (entity.getId().equals(inEntity.getId())){
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

    private void pushData(@NonNull CertificateOfBirthDataEntity entity){
        mDatabaseReference.push().setValue(entity);
    }
}
