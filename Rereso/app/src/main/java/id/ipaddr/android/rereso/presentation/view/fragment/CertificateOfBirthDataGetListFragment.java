package id.ipaddr.android.rereso.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.ipaddr.android.rereso.R;
import id.ipaddr.android.rereso.presentation.internal.di.components.CertificateOfBirthDataComponent;
import id.ipaddr.android.rereso.presentation.model.CertificateOfBirthDataModel;
import id.ipaddr.android.rereso.presentation.presenter.CertificateOfBirthDataGetListPresenter;
import id.ipaddr.android.rereso.presentation.view.CertificateOfBirthDataListView;
import id.ipaddr.android.rereso.presentation.view.adapter.CertificateOfBirthDataAdapter;
import id.ipaddr.android.rereso.presentation.view.adapter.CertificateOfBirthDataLayoutManager;

/**
 * Created by iip on 3/21/17.
 */

public class CertificateOfBirthDataGetListFragment extends BaseFragment implements CertificateOfBirthDataListView{

    private static final String TAG = CertificateOfBirthDataGetListFragment.class.getSimpleName();

    /**
     * Interface for listening certificate of birth list events.
     */
    public interface CertificateOfBirthDataListListener{
        void onCertificateOfBirthDataClicked(final CertificateOfBirthDataModel certificateOfBirthDataModel);
    }

    private CertificateOfBirthDataAdapter.OnItemClickListener onItemClickListener =
            new CertificateOfBirthDataAdapter.OnItemClickListener() {
                @Override public void onCertificateOfBirthDataItemClicked(CertificateOfBirthDataModel model) {
                    if (mCertificateOfBirthDataGetListPresenter != null && model != null) {
                        mCertificateOfBirthDataGetListPresenter.onCertificateOfBirthDataClicked(model);
                    }
                }
            };

    @Inject
    CertificateOfBirthDataGetListPresenter mCertificateOfBirthDataGetListPresenter;
    @Inject
    CertificateOfBirthDataAdapter mCertificateOfBirthDataAdapter;

    @BindView(R.id.list_of_certificateOfBirthData)RecyclerView rv_certificateOfBirthData;
    @BindView(R.id.rl_progress) RelativeLayout rl_progress;
    @BindView(R.id.rl_retry) RelativeLayout rl_retry;
    @BindView(R.id.bt_retry) Button bt_retry;

    private CertificateOfBirthDataListListener mCertificateOfBirthDataListListener;

    public CertificateOfBirthDataGetListFragment(){ setRetainInstance(true);}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (((AppCompatActivity)context) instanceof CertificateOfBirthDataListListener){
            mCertificateOfBirthDataListListener = (CertificateOfBirthDataListListener) (AppCompatActivity)context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent(CertificateOfBirthDataComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_certificateofbirthdatalist, container, false);
        ButterKnife.bind(this, view);
        setupRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCertificateOfBirthDataGetListPresenter.setView(this);
        if (savedInstanceState == null) {
            this.loadCertificateOfBirthDataList();
        }
    }

    @Override public void onResume() {
        super.onResume();
        this.mCertificateOfBirthDataGetListPresenter.resume();
    }

    @Override public void onPause() {
        super.onPause();
        this.mCertificateOfBirthDataGetListPresenter.pause();
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        rv_certificateOfBirthData.setAdapter(null);
        ButterKnife.bind(this, this.getView()).unbind();
    }

    @Override public void onDestroy() {
        super.onDestroy();
        this.mCertificateOfBirthDataGetListPresenter.destroy();
    }

    @Override public void onDetach() {
        super.onDetach();
        this.mCertificateOfBirthDataListListener = null;
    }

    @Override
    public void showLoading() {
        rl_progress.setVisibility(View.VISIBLE);
        getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override
    public void hideLoading() {
        this.rl_progress.setVisibility(View.GONE);
        this.getActivity().setProgressBarIndeterminateVisibility(false);
    }

    @Override
    public void showRetry() {
        this.rl_retry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        this.rl_retry.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        this.showToastMessage(message);
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void renderCertificateOfBirthList(Collection<CertificateOfBirthDataModel> dataModels) {
        if (dataModels != null) {
            this.mCertificateOfBirthDataAdapter.setCertificateOfBirthDataCollection(dataModels);
        }
    }

    @Override
    public void viewCertificateOfBirth(CertificateOfBirthDataModel model) {
        if (this.mCertificateOfBirthDataListListener != null) {
            this.mCertificateOfBirthDataListListener.onCertificateOfBirthDataClicked(model);
        }
    }

    private void setupRecyclerView() {
        this.mCertificateOfBirthDataAdapter.setOnItemClickListener(onItemClickListener);
        this.rv_certificateOfBirthData.setLayoutManager(new CertificateOfBirthDataLayoutManager(context()));
        this.rv_certificateOfBirthData.setAdapter(mCertificateOfBirthDataAdapter);
    }

    /**
     * Loads all certificate of birth.
     */
    private void loadCertificateOfBirthDataList() {
        this.mCertificateOfBirthDataGetListPresenter.initialize();
    }

    @OnClick(R.id.bt_retry) void onButtonRetryClick() {
        loadCertificateOfBirthDataList();
    }
}
