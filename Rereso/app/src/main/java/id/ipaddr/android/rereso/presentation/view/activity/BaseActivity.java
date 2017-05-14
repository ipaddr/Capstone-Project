package id.ipaddr.android.rereso.presentation.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ipaddr.android.rereso.R;
import id.ipaddr.android.rereso.constant.Constant;
import id.ipaddr.android.rereso.presentation.AndroidApplication;
import id.ipaddr.android.rereso.presentation.internal.di.components.ApplicationComponent;
import id.ipaddr.android.rereso.presentation.internal.di.modules.ActivityModule;
import id.ipaddr.android.rereso.presentation.navigation.Navigator;

/**
 * Base {@link android.app.Activity} class for every Activity in this application.
 */
public abstract class BaseActivity extends AppCompatActivity implements OnAuthCallback{

    private static final String TAG = BaseActivity.class.getSimpleName();

    // instant variable of firebase authentication
    private FirebaseAuth mAuth;
    // listerner of firebase authentication status
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Inject
    Navigator navigator;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.fab) FloatingActionButton fab;

    public abstract int getContentViewCurrentActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
        initAndBindFirebaseAuth(savedInstanceState, this);

        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

        setContentView(getContentViewCurrentActivity());
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                navigator.navigateToAddCertificateOfBirthDataDetails(BaseActivity.this);
            }
        });
    }

    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    /**
     * Get the Main Application component for dependency injection.
     *
     * @return {@link ApplicationComponent}
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    /**
     * Get an Activity module for dependency injection.
     *
     * @return {@link ActivityModule}
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.RC_SIGN_IN){
            if (resultCode == RESULT_CANCELED){
                finish();
            } else if (resultCode == RESULT_OK){
                Log.d(TAG, "onActivityResult : RC_SIGN_IN : RESULT_OK");
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    /**
     *
     */
    protected void initAndBindFirebaseAuth(Bundle savedInstanceState, OnAuthCallback onAuthCallback){
        // init firebase authentication
        mAuth = FirebaseAuth.getInstance();
        // bind the firebase auth listener
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    onAuthCallback.onAuth(savedInstanceState);
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    // forward user to sign in activity provide by firebase auth
                    onAuthCallback.onNotAuth();
                }
            }
        };
    }

    @Override
    public void onAuth(Bundle savedInstanceState) {

    }

    /**
     * forward user to sign in activity provide by firebase auth
     */
    @Override
    public void onNotAuth() {
        startActivityForResult(AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setIsSmartLockEnabled(false)
                .setProviders(Arrays.asList(
                        new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build())
                )
                .setAllowNewEmailAccounts(false)
                .build(), Constant.RC_SIGN_IN);
    }


}
