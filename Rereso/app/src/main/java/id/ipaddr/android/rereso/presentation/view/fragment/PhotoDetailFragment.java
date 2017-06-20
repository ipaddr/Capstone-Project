package id.ipaddr.android.rereso.presentation.view.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ipaddr.android.rereso.R;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.domain.model.DocumentRequired;
import id.ipaddr.android.rereso.presentation.presenter.CertificateOfBirthDataSetDetailPresenter;
import id.ipaddr.android.rereso.presentation.view.activity.ImageViewActivity;
import id.ipaddr.android.rereso.presentation.view.adapter.CertificateOfBirthDataDocumentRequiredAdapter;
import id.ipaddr.android.rereso.util.ImageUtil;
import id.ipaddr.android.rereso.util.ItemDecorationAlbumColumns;

/**
 * Created by iip on 3/30/17.
 */

public class PhotoDetailFragment extends Fragment implements BlockingStep {

    private static final String TAG = PhotoDetailFragment.class.getSimpleName();

    private List<DocumentRequired> documentRequireds;



    @BindView(R.id.rv_photo_detail)
    RecyclerView mPhotoRecyclerView;

    @Inject
    CertificateOfBirthDataDocumentRequiredAdapter mCertificateOfBirthDataDocumentRequiredAdapter;

    private CertificateOfBirthDataSetDetailPresenter mCertificateOfBirthDataSetDetailPresenter;
    public void setCertificateOfBirthDataSetDetailPresenter(CertificateOfBirthDataSetDetailPresenter certificateOfBirthDataSetDetailPresenter) {
        this.mCertificateOfBirthDataSetDetailPresenter = certificateOfBirthDataSetDetailPresenter;
    }

    private int selectedDocumentPosition = -1;
    private CertificateOfBirthDataDocumentRequiredAdapter.OnItemClickListener onItemClickListener =
        new CertificateOfBirthDataDocumentRequiredAdapter.OnItemClickListener() {
            @Override
            public void onCloseDocumentItemClicked(int position) {
                setDocumentImageAtPosition(position, null);
            }

            @Override
            public void onDocumentRequiredItemClicked(int position) {
                DocumentRequired dr = mCertificateOfBirthDataDocumentRequiredAdapter.getDocumentRequired(position);
                if (dr.getDocumentImageURI() == null)
                    dispatchTakePictureIntent(position);
                else viewImage(dr.getDocumentImageURI());
            }
        };

    private void viewImage(String uri){
        Intent intent = new Intent(getActivity(), ImageViewActivity.class);
        intent.putExtra("uri", uri);
        startActivity(intent);
    }

    private void setDocumentImageAtPosition(int position, Bitmap bitmap){
        DocumentRequired documentRequired = mCertificateOfBirthDataDocumentRequiredAdapter.getDocumentRequired(position);

        if (bitmap != null){
            documentRequired.setBitmap(bitmap);
            byte [] datas = ImageUtil.convertBitmapToByte(bitmap);
            documentRequired.setDatas(datas);
            String base64 = Base64.encodeToString(datas, Base64.DEFAULT);
            documentRequired.setDocumentImageBase64(base64);
        } else {
            documentRequired.setBitmap(null);
            documentRequired.setDatas(null);
            documentRequired.setDocumentImageBase64(null);
            documentRequired.setDocumentImageURI(null);
        }

        mCertificateOfBirthDataDocumentRequiredAdapter.setDocumentRequired(position, documentRequired);
    };

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private void dispatchTakePictureIntent(int position) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            // Create the File where the photo should go
            Pair<String, File> pair = null;
            File photoFile = null;
            try {
                pair = ImageUtil.createImageFile(getActivity());
                photoFile = pair.second;
            } catch (IOException ex) {
                // Error occurred while creating the File
                Toast.makeText(getActivity(),getString(R.string.exception_message_generic), Toast.LENGTH_SHORT).show();
            }

            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(getActivity(),
                        "id.ipaddr.android.rereso",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                selectedDocumentPosition = position;
                DocumentRequired documentRequired = mCertificateOfBirthDataDocumentRequiredAdapter.getDocumentRequired(selectedDocumentPosition);
                documentRequired.setDocumentImageURI(pair.first);
                documentRequired.setFile(photoFile);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == getActivity().RESULT_OK) {
            if (data != null){
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                setDocumentImageAtPosition(selectedDocumentPosition, imageBitmap);
            }
        }
        selectedDocumentPosition = -1;
    }

    public PhotoDetailFragment(){
        setRetainInstance(true);
    }

    public static PhotoDetailFragment newInstance(){
        PhotoDetailFragment f = new PhotoDetailFragment();
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCertificateOfBirthDataDocumentRequiredAdapter = new CertificateOfBirthDataDocumentRequiredAdapter(getActivity());
        mCertificateOfBirthDataDocumentRequiredAdapter.setDocumentRequiredCollection(initDocReq());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_detail, container, false);
        ButterKnife.bind(this, view);
        setupRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void setupRecyclerView() {
        final int column = 2;
        mCertificateOfBirthDataDocumentRequiredAdapter.setOnItemClickListener(onItemClickListener);
        mPhotoRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), column));
        mPhotoRecyclerView.setAdapter(mCertificateOfBirthDataDocumentRequiredAdapter);
        mPhotoRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), column));
        mPhotoRecyclerView.addItemDecoration(new ItemDecorationAlbumColumns(
                getResources().getDimensionPixelSize(R.dimen.photos_list_spacing),
                column));
    }

    private List<DocumentRequired>  initDocReq(){
        documentRequireds = new ArrayList<>();
        documentRequireds.add(new DocumentRequired(getString(R.string.household_recommendation_letter), true));
        documentRequireds.add(new DocumentRequired(getString(R.string.family_identity_card), true));
        documentRequireds.add(new DocumentRequired(getString(R.string.father_id_card), true));
        documentRequireds.add(new DocumentRequired(getString(R.string.mother_id_card), true));
        documentRequireds.add(new DocumentRequired(getString(R.string.marital_certificate_letter), true));
        documentRequireds.add(new DocumentRequired(getString(R.string.father_certificate_of_birth), true));
        documentRequireds.add(new DocumentRequired(getString(R.string.mother_certificate_of_birth), true));
        documentRequireds.add(new DocumentRequired(getString(R.string.father_passport), false));
        documentRequireds.add(new DocumentRequired(getString(R.string.mother_passport), false));
        documentRequireds.add(new DocumentRequired(getString(R.string.first_spectator_id_card), true));
        documentRequireds.add(new DocumentRequired(getString(R.string.second_spectator_id_card), true));
        documentRequireds.add(new DocumentRequired(getString(R.string.police_certificate_for_unfamiliy_baby), false));
        documentRequireds.add(new DocumentRequired(getString(R.string.social_services_certificate_for_vulnerable_residents), false));
        documentRequireds.add(new DocumentRequired(getString(R.string.img_of_certificate_of_birth_form), true));
        return documentRequireds;
    }

    private boolean verifyAndSaveImageData(){
        CertificateOfBirthData cd = mCertificateOfBirthDataSetDetailPresenter.getCertificateOfBirthData();

        DocumentRequired houseHoldRecommLetter = documentRequireds.get(0);
        DocumentRequired familyIdentityCard = documentRequireds.get(1);
        DocumentRequired fatherIdCard = documentRequireds.get(2);
        DocumentRequired motherIdCard = documentRequireds.get(3);
        DocumentRequired maritalCertificateLetter = documentRequireds.get(4);
        DocumentRequired fatherCertificateLetter = documentRequireds.get(5);
        DocumentRequired motherCertificateLetter = documentRequireds.get(6);
        DocumentRequired fatherPassport = documentRequireds.get(7);
        DocumentRequired motherPassport = documentRequireds.get(8);
        DocumentRequired firstSpectatorIdCard = documentRequireds.get(9);
        DocumentRequired secondSpectatorIdCard = documentRequireds.get(10);
        DocumentRequired policeCertificate = documentRequireds.get(11);
        DocumentRequired socialServiceCertificate = documentRequireds.get(12);
        DocumentRequired imgOfCertificateOfBirthForm = documentRequireds.get(13);


        if (verifyDocumentRequired(houseHoldRecommLetter) && verifyDocumentRequired(familyIdentityCard) && verifyDocumentRequired(fatherIdCard)
                && verifyDocumentRequired(motherIdCard) && verifyDocumentRequired(maritalCertificateLetter) && verifyDocumentRequired(fatherCertificateLetter)
                && verifyDocumentRequired(motherCertificateLetter) && verifyDocumentRequired(firstSpectatorIdCard) && verifyDocumentRequired(secondSpectatorIdCard)
                && verifyDocumentRequired(imgOfCertificateOfBirthForm)) {

            cd.setHouseholdRecommendationLetter(houseHoldRecommLetter);
            cd.setFamilyIdentityCard(familyIdentityCard);
            cd.setFatherIdCard(fatherIdCard);
            cd.setMotherIdCard(motherIdCard);
            cd.setMaritalCertificateLetter(maritalCertificateLetter);
            cd.setFatherCertificateOfBirth(fatherCertificateLetter);
            cd.setMotherCertificateOfBirth(motherCertificateLetter);
            cd.setFatherPassport(fatherPassport);
            cd.setMotherPassport(motherPassport);
            cd.setFirstSpectatorIdCard(firstSpectatorIdCard);
            cd.setSecondSpectatorIdCard(secondSpectatorIdCard);
            cd.setPoliceCertificateForUnfamiliyBaby(policeCertificate);
            cd.setSocialServicesCertificateForVulnerableResidents(socialServiceCertificate);
            cd.setImgOfCertificateOfBirthForm(imgOfCertificateOfBirthForm);
            return true;
        }

        return false;
    }

    private boolean verifyDocumentRequired(DocumentRequired dr){
        String base64 = dr.getDocumentImageBase64();
        if (null == base64 || TextUtils.isEmpty(base64))
            return false;
        return true;
    }

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

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        Log.d(TAG, "onCompleteClicked");
        if (verifyAndSaveImageData()) {
            saveData();
            callback.complete();
            getActivity().finish();
        }
        else Toast.makeText(getActivity(), "Add detail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        Log.d(TAG, "onBackClicked");
        callback.goToPrevStep();
    }

    private void saveData(){
        DatabaseReference dbr = FirebaseDatabase.getInstance().getReference(CertificateOfBirthData.class.getSimpleName());
        dbr.push().setValue(mCertificateOfBirthDataSetDetailPresenter.getCertificateOfBirthData());
    }

}
