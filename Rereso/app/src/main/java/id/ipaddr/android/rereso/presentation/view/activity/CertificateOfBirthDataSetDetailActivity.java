package id.ipaddr.android.rereso.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import javax.inject.Inject;

import id.ipaddr.android.rereso.R;
import id.ipaddr.android.rereso.presentation.internal.di.HasComponent;
import id.ipaddr.android.rereso.presentation.internal.di.components.CertificateOfBirthDataComponent;
import id.ipaddr.android.rereso.presentation.internal.di.components.DaggerCertificateOfBirthDataComponent;
import id.ipaddr.android.rereso.presentation.model.CertificateOfBirthDataModel;
import id.ipaddr.android.rereso.presentation.presenter.CertificateOfBirthDataSetDetailPresenter;
import id.ipaddr.android.rereso.presentation.view.CertificateOfBirthDataSetDetailView;
import id.ipaddr.android.rereso.presentation.view.adapter.CertificateOfBirthDataStepperAdapter;
import id.ipaddr.android.rereso.presentation.view.fragment.CertificateOfBirthDataGetDetailFragment;
import id.ipaddr.android.rereso.presentation.view.fragment.CertificateOfBirthDataSetDetailFragment;

/**
 * Created by iip on 3/27/17.
 */

public class CertificateOfBirthDataSetDetailActivity extends BaseActivity
        implements HasComponent<CertificateOfBirthDataComponent>{

    private static final String TAG = CertificateOfBirthDataSetDetailActivity.class.getSimpleName();

    private static final String INTENT_EXTRA_PARAM_ID = "id.ipaddr.android.rereso.presentation.view.activity.CertificateOfBirthDataSetDetailActivity.INTENT_EXTRA_PARAM_ID";
    private static final String INSTANCE_STATE_PARAM_ID = "id.ipaddr.android.rereso.presentation.view.activity.CertificateOfBirthDataSetDetailActivity.INSTANCE_STATE_PARAM_ID";

    private String mId;
    private CertificateOfBirthDataComponent mCertificateOfBirthDataComponent;

    public static Intent getCallingIntent(Context context) {
        Intent callingIntent = new Intent(context, CertificateOfBirthDataSetDetailActivity.class);
        return callingIntent;
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
        this.initializeActivity(savedInstanceState);
        this.initializeInjector();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fab.setVisibility(View.VISIBLE);
    }

    /**
     * Initializes this activity.
     */
    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            mId = getIntent().getStringExtra(INTENT_EXTRA_PARAM_ID);
            addFragment(R.id.fragmentContainer, CertificateOfBirthDataSetDetailFragment.forCer(mId));
        } else {
            mId = savedInstanceState.getString(INSTANCE_STATE_PARAM_ID);
        }
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
