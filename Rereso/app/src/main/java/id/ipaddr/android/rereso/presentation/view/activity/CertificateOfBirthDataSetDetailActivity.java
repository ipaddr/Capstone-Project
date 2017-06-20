package id.ipaddr.android.rereso.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.stepstone.stepper.StepperLayout;

import javax.inject.Inject;

import butterknife.BindView;
import id.ipaddr.android.rereso.R;
import id.ipaddr.android.rereso.presentation.internal.di.HasComponent;
import id.ipaddr.android.rereso.presentation.internal.di.components.CertificateOfBirthDataComponent;
import id.ipaddr.android.rereso.presentation.internal.di.components.DaggerCertificateOfBirthDataComponent;
import id.ipaddr.android.rereso.presentation.presenter.CertificateOfBirthDataSetDetailPresenter;
import id.ipaddr.android.rereso.presentation.view.adapter.CertificateOfBirthDataStepperAdapter;

/**
 * Created by iip on 3/27/17.
 */

public class CertificateOfBirthDataSetDetailActivity extends BaseActivity
        implements HasComponent<CertificateOfBirthDataComponent>{

    private static final String TAG = CertificateOfBirthDataSetDetailActivity.class.getSimpleName();

    private static final String INTENT_EXTRA_PARAM_ID = "id.ipaddr.android.rereso.presentation.view.activity.CertificateOfBirthDataSetDetailActivity.INTENT_EXTRA_PARAM_ID";
    private static final String INSTANCE_STATE_PARAM_ID = "id.ipaddr.android.rereso.presentation.view.activity.CertificateOfBirthDataSetDetailActivity.INSTANCE_STATE_PARAM_ID";

    private final String FRAGMENT_TAG = "CertificateOfBirthDataSetDetailActivity.FRAGMENT_TAG";

    private String mId;
    private Fragment f;
    private CertificateOfBirthDataComponent mCertificateOfBirthDataComponent;

    public static Intent getCallingIntent(Context context) {
        Intent callingIntent = new Intent(context, CertificateOfBirthDataSetDetailActivity.class);
        return callingIntent;
    }

    @BindView(R.id.stepperLayout)
    StepperLayout mStepperLayout;

    @Inject
    CertificateOfBirthDataSetDetailPresenter mCertificateOfBirthDataSetDetailPresenter;

    private void setupStepper(){
        CertificateOfBirthDataStepperAdapter cbsa = new CertificateOfBirthDataStepperAdapter(getSupportFragmentManager(), this, mCertificateOfBirthDataSetDetailPresenter);
        mStepperLayout.setAdapter(cbsa);
    }

    @Override
    public int getContentViewCurrentActivity() {
        return R.layout.activity_certificateofbirthdatasetdetail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fab.setVisibility(View.GONE);
    }

    @Override
    public void onAuth(Bundle savedInstanceState) {
        super.onAuth(savedInstanceState);
        this.initializeInjector();
        setupStepper();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fab.setVisibility(View.VISIBLE);
    }

    private void initializeInjector() {
        mCertificateOfBirthDataComponent = DaggerCertificateOfBirthDataComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public CertificateOfBirthDataComponent getComponent() {
        return mCertificateOfBirthDataComponent;
    }
}
