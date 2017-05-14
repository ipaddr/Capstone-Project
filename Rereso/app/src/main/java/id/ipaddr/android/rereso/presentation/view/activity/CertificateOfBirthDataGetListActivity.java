package id.ipaddr.android.rereso.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

import id.ipaddr.android.rereso.R;
import id.ipaddr.android.rereso.presentation.internal.di.HasComponent;
import id.ipaddr.android.rereso.presentation.internal.di.components.CertificateOfBirthDataComponent;
import id.ipaddr.android.rereso.presentation.internal.di.components.DaggerCertificateOfBirthDataComponent;
import id.ipaddr.android.rereso.presentation.model.CertificateOfBirthDataModel;
import id.ipaddr.android.rereso.presentation.view.fragment.CertificateOfBirthDataGetListFragment;

public class CertificateOfBirthDataGetListActivity extends BaseActivity implements
        HasComponent<CertificateOfBirthDataComponent>
        , CertificateOfBirthDataGetListFragment.CertificateOfBirthDataListListener{

    void test(){
        List<String> list = new ArrayList<String>();
    }

    // logging variable purpose
    private final String TAG = CertificateOfBirthDataGetListActivity.class.getSimpleName();

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, CertificateOfBirthDataGetListActivity.class);
    }

    private CertificateOfBirthDataComponent mCertificateOfBirthDataComponent;

    @Override
    public int getContentViewCurrentActivity() {
        return R.layout.activity_certificateofbirthdata;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAuth(Bundle savedInstanceState) {
        super.onAuth(savedInstanceState);
        this.initializeInjector();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new CertificateOfBirthDataGetListFragment());
        }
    }

    private void initializeInjector() {
        this.mCertificateOfBirthDataComponent = DaggerCertificateOfBirthDataComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {
                            // user is now signed out
                            onNotAuth();
                        }
                    });
            ;
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // region

    @Override
    public CertificateOfBirthDataComponent getComponent() {
        return mCertificateOfBirthDataComponent;
    }

    @Override
    public void onCertificateOfBirthDataClicked(CertificateOfBirthDataModel certificateOfBirthDataModel) {
        navigator.navigateToCertificateOfBirthDataDetails(this, certificateOfBirthDataModel.id);
    }

    // endregion
}
