package id.ipaddr.android.rereso.presentation.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

import javax.inject.Inject;

import id.ipaddr.android.rereso.R;
import id.ipaddr.android.rereso.presentation.presenter.CertificateOfBirthDataSetDetailPresenter;
import id.ipaddr.android.rereso.presentation.view.fragment.CertificateOfBirthDataGetDetailFragment;
import id.ipaddr.android.rereso.presentation.view.fragment.PhotoDetailFragment;
import id.ipaddr.android.rereso.presentation.view.fragment.StepDetailFragment;

/**
 * Created by iip on 3/28/17.
 */

public class CertificateOfBirthDataStepperAdapter extends AbstractFragmentStepAdapter {

    private Resources resources;
    private CertificateOfBirthDataSetDetailPresenter mCertificateOfBirthDataSetDetailPresenter;

    public CertificateOfBirthDataStepperAdapter(FragmentManager fm, Context ctx, CertificateOfBirthDataSetDetailPresenter certificateOfBirthDataSetDetailPresenter){
        super(fm, ctx);
        resources = context.getResources();
        mCertificateOfBirthDataSetDetailPresenter = certificateOfBirthDataSetDetailPresenter;
    }

    public void setCurrentPosition(int position){
        createStep(position);
    }

    @Override
    public Step createStep(@IntRange(from = 0, to = 8) int position) {
        if (position == 8){
            PhotoDetailFragment f = PhotoDetailFragment.newInstance( );
            f.setCertificateOfBirthDataSetDetailPresenter(mCertificateOfBirthDataSetDetailPresenter);
            return f;
        }
        StepDetailFragment f = StepDetailFragment.newInstance(position);
        f.setCertificateOfBirthDataSetDetailPresenter(mCertificateOfBirthDataSetDetailPresenter);
        return f;
    }

    @Override
    public int getCount() {
        return 9;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0, to = 8) int position) {
        switch (position){
            case 0: return new StepViewModel.Builder(context).setTitle(resources.getString(R.string.patriarch_data)).create();
            case 1: return new StepViewModel.Builder(context).setTitle(resources.getString(R.string.baby_data)).create();
            case 2: return new StepViewModel.Builder(context).setTitle(resources.getString(R.string.father_data)).create();
            case 3: return new StepViewModel.Builder(context).setTitle(resources.getString(R.string.mother_data)).create();
            case 4: return new StepViewModel.Builder(context).setTitle(resources.getString(R.string.rapporteur_data)).create();
            case 5: return new StepViewModel.Builder(context).setTitle(resources.getString(R.string.first_spectator_data)).create();
            case 6: return new StepViewModel.Builder(context).setTitle(resources.getString(R.string.second_spectator_data)).create();
            case 7: return new StepViewModel.Builder(context).setTitle(resources.getString(R.string.signature_data)).create();
            case 8: return new StepViewModel.Builder(context).setTitle(resources.getString(R.string.photo_data)).create();
            default:return super.getViewModel(position);
        }
    }
}
