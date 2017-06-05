package id.ipaddr.android.rereso.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ipaddr.android.rereso.R;
import id.ipaddr.android.rereso.presentation.internal.di.components.CertificateOfBirthDataComponent;
import id.ipaddr.android.rereso.presentation.model.CertificateOfBirthDataModel;
import id.ipaddr.android.rereso.presentation.presenter.CertificateOfBirthDataSetDetailPresenter;
import id.ipaddr.android.rereso.presentation.view.CertificateOfBirthDataSetDetailView;
import id.ipaddr.android.rereso.presentation.view.adapter.CertificateOfBirthDataStepperAdapter;

/**
 * Created by iip on 3/27/17.
 */

public class CertificateOfBirthDataSetDetailFragment extends BaseFragment
        implements CertificateOfBirthDataSetDetailView, StepperLayout.StepperListener{

    private static final String TAG = CertificateOfBirthDataSetDetailFragment.class.getSimpleName();

    private static final String ID = "id.ipaddr.android.rereso.presentation.view.fragment.CertificateOfBirthDataSetDetailFragment.ID";
    private static final String POSITION = "id.ipaddr.android.rereso.presentation.view.fragment.CertificateOfBirthDataSetDetailFragment.POSITION";

    @Inject
    CertificateOfBirthDataSetDetailPresenter mCertificateOfBirthDataSetDetailPresenter;

    @BindView(R.id.stepperLayout)
    StepperLayout mStepperLayout;

    public CertificateOfBirthDataSetDetailFragment(){
        setRetainInstance(true);
    }

    public static CertificateOfBirthDataSetDetailFragment newFragment(){
        CertificateOfBirthDataSetDetailFragment f = new CertificateOfBirthDataSetDetailFragment();
        return f;
    }

    public static CertificateOfBirthDataSetDetailFragment forCer(String id){
        final CertificateOfBirthDataSetDetailFragment fragment = new CertificateOfBirthDataSetDetailFragment();
        final Bundle bundle = new Bundle();
        bundle.putString(ID, id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(CertificateOfBirthDataComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_stepper, container, false);
        ButterKnife.bind(this, view);
        setupStepper(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mCertificateOfBirthDataSetDetailPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mCertificateOfBirthDataSetDetailPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.bind(this, getView()).unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCertificateOfBirthDataSetDetailPresenter.destroy();
    }

    private void setupStepper(View view){
        mStepperLayout = (StepperLayout) view.findViewById(R.id.stepperLayout);
        CertificateOfBirthDataStepperAdapter cbsa = new CertificateOfBirthDataStepperAdapter(getFragmentManager(), getActivity(), mCertificateOfBirthDataSetDetailPresenter);
        mStepperLayout.setAdapter(cbsa);
        mStepperLayout.setListener(this);
    }

    @Override
    public void renderCertificateOfBirthData(CertificateOfBirthDataModel model){
        Log.d(TAG, "renderCertificateOfBirthData");
    }

    @Override
    public void onCompleted(View completeButton) {
        Log.d(TAG, "onCompleted");
    }

    @Override
    public void onError(VerificationError verificationError) {
        Log.d(TAG, "onError");
    }

    @Override
    public void onStepSelected(int newStepPosition) {
        Log.d(TAG, "onStepSelected");
    }

    @Override
    public void onReturn() {
        Log.d(TAG, "onReturn");
    }

}
