package id.ipaddr.android.rereso.presentation.navigation;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.ipaddr.android.rereso.R;
import id.ipaddr.android.rereso.presentation.view.activity.CertificateOfBirthDataSetDetailActivity;
import id.ipaddr.android.rereso.presentation.view.activity.CertificateOfBirthDataGetDetailActivity;
import id.ipaddr.android.rereso.presentation.view.activity.CertificateOfBirthDataGetListActivity;

/**
 * Class used to navigate through the application.
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator() {
        //empty
    }

    /**
     * Goes to the CertificateOfBirthData list screen.
     *
     * @param context A Context needed to open the destiny activity.
     */
    public void navigateToCertificateOfBirthDataList(Context context) {
        if (context != null) {
            Intent intentToLaunch = CertificateOfBirthDataGetListActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
            ((AppCompatActivity)context).overridePendingTransition(R.anim.right_in, R.anim.left_out);
        }
    }

    /**
     * Goes to the CertificateOfBirthData details screen.
     *
     * @param context A Context needed to open the destiny activity.
     */
    public void navigateToCertificateOfBirthDataDetails(Context context, String id) {
        if (context != null) {
            Intent intentToLaunch = CertificateOfBirthDataGetDetailActivity.getCallingIntent(context, id);
            context.startActivity(intentToLaunch);
            ((AppCompatActivity)context).overridePendingTransition(R.anim.right_in, R.anim.left_out);
        }
    }

    /**
     * Goes to the add CertificateOfBirthData details screen.
     *
     * @param context A Context needed to open the destiny activity.
     */
    public void navigateToAddCertificateOfBirthDataDetails(Context context) {
        if (context != null) {
            Intent intentToLaunch = CertificateOfBirthDataSetDetailActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
            ((AppCompatActivity)context).overridePendingTransition(R.anim.right_in, R.anim.left_out);
        }
    }
}
