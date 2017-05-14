package id.ipaddr.android.rereso.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.common.base.Preconditions;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.ipaddr.android.rereso.R;
import id.ipaddr.android.rereso.domain.model.Baby;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthForm;
import id.ipaddr.android.rereso.domain.model.Citizen;
import id.ipaddr.android.rereso.domain.model.DocumentRequired;
import id.ipaddr.android.rereso.presentation.internal.di.components.CertificateOfBirthDataComponent;
import id.ipaddr.android.rereso.presentation.model.CertificateOfBirthDataModel;
import id.ipaddr.android.rereso.presentation.presenter.CertificateOfBirthDataGetDetailPresenter;
import id.ipaddr.android.rereso.presentation.view.CertificateOfBirthDataDetailView;
import id.ipaddr.android.rereso.presentation.view.adapter.CertificateOfBirthDataDocumentRequiredAdapter;
import id.ipaddr.android.rereso.util.ItemDecorationAlbumColumns;

/**
 * Created by iip on 3/21/17.
 */

public class CertificateOfBirthDataGetDetailFragment extends BaseFragment
        implements CertificateOfBirthDataDetailView, Step{

    private static final String ID = "id.ipaddr.android.rereso.presentation.view.fragment.CertificateOfBirthDataGetDetailFragment.ID";

    /**
     * Interface for listening user list events.
     */
    public interface CertificateOfBirthDataDocumentRequiredListener {
        void onItemClicked(final DocumentRequired documentRequired);
    }

    @Inject
    CertificateOfBirthDataGetDetailPresenter mCertificateOfBirthDataGetDetailPresenter;
    @Inject
    CertificateOfBirthDataDocumentRequiredAdapter mCertificateOfBirthDataDocumentRequiredAdapter;

    @BindView(R.id.text_input_layout_dad_name)
    TextInputLayout tilDadName;
    @BindView(R.id.text_input_layout_mom_name)
    TextInputLayout tilMomName;
    @BindView(R.id.text_input_layout_baby_name)
    TextInputLayout tilBabyName;
    @BindView(R.id.app_compat_edit_text_dad_name)
    AppCompatEditText acetDadName;
    @BindView(R.id.app_compat_edit_text_mom_name)
    AppCompatEditText acetMomName;
    @BindView(R.id.app_compat_edit_text_baby_name)
    AppCompatEditText acetBabyName;
    @BindView(R.id.list_of_document_required)
    RecyclerView listOfDocumentRequired;
    @BindView(R.id.top_button)
    AppCompatButton topButton;
    @BindView(R.id.bottom_button)
    AppCompatButton bottomButton;
    @BindView(R.id.rl_progress)
    RelativeLayout progressLayout;
    @BindView(R.id.rl_retry)
    RelativeLayout retryLayout;

    private CertificateOfBirthDataDocumentRequiredListener mCertificateOfBirthDataDocumentRequiredListener;

    public CertificateOfBirthDataGetDetailFragment(){
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AppCompatActivity a = (AppCompatActivity)context;
        if ((a) instanceof CertificateOfBirthDataDocumentRequiredListener){
            mCertificateOfBirthDataDocumentRequiredListener = (CertificateOfBirthDataDocumentRequiredListener)a;
        }
    }

    public static CertificateOfBirthDataGetDetailFragment forCer(String id){
        final CertificateOfBirthDataGetDetailFragment fragment = new CertificateOfBirthDataGetDetailFragment();
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
        final View view = inflater.inflate(R.layout.fragment_certificateofbirthdatadetail, container, false);
        ButterKnife.bind(this, view);
        setupRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCertificateOfBirthDataGetDetailPresenter.setView(this);
        if (savedInstanceState == null){
            loadCertificateOfBirthDataDetail();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mCertificateOfBirthDataGetDetailPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mCertificateOfBirthDataGetDetailPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.bind(this, getView()).unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCertificateOfBirthDataGetDetailPresenter.destroy();
    }

    @Override public void showLoading() {
        this.progressLayout.setVisibility(View.VISIBLE);
        this.getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override public void hideLoading() {
        this.progressLayout.setVisibility(View.GONE);
        this.getActivity().setProgressBarIndeterminateVisibility(false);
    }

    @Override public void showRetry() {
        this.retryLayout.setVisibility(View.VISIBLE);
    }

    @Override public void hideRetry() {
        this.retryLayout.setVisibility(View.GONE);
    }

    @Override
    public void renderCertificateOfBirthData(CertificateOfBirthDataModel model) {
        if (model != null){
            CertificateOfBirthForm form = model.certificateOfBirthForm;
            Citizen father = form.getFather();
            Citizen mother = form.getMother();
            Baby baby = form.getBaby();
            acetDadName.setText(father.getFullName());
            acetMomName.setText(mother.getFullName());
            acetBabyName.setText(baby.getName());
            mCertificateOfBirthDataDocumentRequiredAdapter.setDocumentRequiredCollection(initDocReq(model));
        }
    }

    private List<DocumentRequired> initDocReq(CertificateOfBirthDataModel model){
        List<DocumentRequired> documentRequireds = new ArrayList<>();
        documentRequireds.add(from(model.householdRecommendationLetter));
        documentRequireds.add(from(model.householdRecommendationLetter));
        documentRequireds.add(from(model.familyIdentityCard));
        documentRequireds.add(from(model.fatherIdCard));
        documentRequireds.add(from(model.motherIdCard));
        documentRequireds.add(from(model.maritalCertificateLetter));
        documentRequireds.add(from(model.fatherCertificateOfBirth));
        documentRequireds.add(from(model.motherCertificateOfBirth));
        documentRequireds.add(from(model.fatherPassport));
        documentRequireds.add(from(model.motherPassport));
        documentRequireds.add(from(model.firstSpectatorIdCard));
        documentRequireds.add(from(model.secondSpectatorIdCard));
        documentRequireds.add(from(model.policeCertificateForUnfamiliyBaby));
        documentRequireds.add(from(model.socialServicesCertificateForVulnerableResidents));
        documentRequireds.add(from(model.imgOfCertificateOfBirthForm));
        return documentRequireds;
    }

    private DocumentRequired from(DocumentRequired documentRequired){
        return documentRequired;
    }

    @Override public void showError(String message) {
        this.showToastMessage(message);
    }

    @Override public Context context() {
        return getActivity().getApplicationContext();
    }

    private void setupRecyclerView() {
        final int column = 2;
        this.mCertificateOfBirthDataDocumentRequiredAdapter.setOnItemClickListener(onItemClickListener);
        listOfDocumentRequired.setLayoutManager(new GridLayoutManager(context(), column));
        listOfDocumentRequired.setAdapter(mCertificateOfBirthDataDocumentRequiredAdapter);
        listOfDocumentRequired.setLayoutManager(new GridLayoutManager(context(), column));
        listOfDocumentRequired.addItemDecoration(new ItemDecorationAlbumColumns(
                getResources().getDimensionPixelSize(R.dimen.photos_list_spacing),
                column));
    }

    /**
     * Load user details.
     */
    private void loadCertificateOfBirthDataDetail() {
        if (mCertificateOfBirthDataGetDetailPresenter != null){
            mCertificateOfBirthDataGetDetailPresenter.initialize(currentId());
        }
    }

    /**
     * Get current  id from fragments arguments.
     */
    private String currentId() {
        final Bundle arguments = getArguments();
        Preconditions.checkNotNull(arguments, "Fragment arguments cannot be null");
        return arguments.getString(ID);
    }

    @OnClick(R.id.bt_retry)
    void onButtonRetryClick() {
        loadCertificateOfBirthDataDetail();
    }


    private CertificateOfBirthDataDocumentRequiredAdapter.OnItemClickListener onItemClickListener =
            new CertificateOfBirthDataDocumentRequiredAdapter.OnItemClickListener() {
                @Override
                public void onCloseDocumentItemClicked(int position) {

                }

                @Override
                public void onDocumentRequiredItemClicked(int position) {

                }
            };


    @Override
    public VerificationError verifyStep() {
        //return null if the user can go to the next step, create a new VerificationError instance otherwise
        return null;
    }

    @Override
    public void onSelected() {
        //update UI when selected
    }

    @Override
    public void onError(@NonNull VerificationError error) {
        //handle error inside of the fragment, e.g. show error on EditText
    }
}
