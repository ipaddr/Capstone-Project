package id.ipaddr.android.rereso.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import id.ipaddr.android.rereso.R;
import id.ipaddr.android.rereso.presentation.internal.di.HasComponent;
import id.ipaddr.android.rereso.presentation.internal.di.components.CertificateOfBirthDataComponent;
import id.ipaddr.android.rereso.presentation.internal.di.components.DaggerCertificateOfBirthDataComponent;
import id.ipaddr.android.rereso.presentation.view.fragment.CertificateOfBirthDataGetDetailFragment;

/**
 * Created by iip on 3/20/17.
 */

public class CertificateOfBirthDataGetDetailActivity extends BaseActivity
        implements HasComponent<CertificateOfBirthDataComponent>{

    private static final String INTENT_EXTRA_PARAM_ID = "id.ipaddr.android.rereso.presentation.view.activity.CertificateOfBirthDataGetDetailActivity.INTENT_EXTRA_PARAM_ID";
    private static final String INSTANCE_STATE_PARAM_ID = "id.ipaddr.android.rereso.presentation.view.activity.CertificateOfBirthDataGetDetailActivity.INSTANCE_STATE_PARAM_ID";

    public static Intent getCallingIntent(Context context, String id) {
        Intent callingIntent = new Intent(context, CertificateOfBirthDataGetDetailActivity.class);
        callingIntent.putExtra(INTENT_EXTRA_PARAM_ID, id);
        return callingIntent;
    }

    private String mId;
    private CertificateOfBirthDataComponent mCertificateOfBirthDataComponent;

    @Override
    public int getContentViewCurrentActivity() {
        return R.layout.activity_certificateofbirthdata;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAuth(Bundle savedInstanceState) {
        super.onAuth(savedInstanceState);
        this.initializeActivity(savedInstanceState);
        this.initializeInjector();
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.putString(INSTANCE_STATE_PARAM_ID, mId);
        }
        super.onSaveInstanceState(outState);
    }

    /**
     * Initializes this activity.
     */
    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            mId = getIntent().getStringExtra(INTENT_EXTRA_PARAM_ID);
            addFragment(R.id.fragmentContainer, CertificateOfBirthDataGetDetailFragment.forCer(mId));
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
