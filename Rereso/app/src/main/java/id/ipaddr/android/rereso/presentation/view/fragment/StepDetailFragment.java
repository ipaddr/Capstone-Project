package id.ipaddr.android.rereso.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ipaddr.android.rereso.R;
import id.ipaddr.android.rereso.constant.Constant;
import id.ipaddr.android.rereso.domain.model.Address;
import id.ipaddr.android.rereso.domain.model.Baby;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthForm;
import id.ipaddr.android.rereso.domain.model.Citizen;
import id.ipaddr.android.rereso.domain.model.EBirthHelper;
import id.ipaddr.android.rereso.domain.model.ECitizenship;
import id.ipaddr.android.rereso.domain.model.EPlaceOfBirth;
import id.ipaddr.android.rereso.domain.model.ESex;
import id.ipaddr.android.rereso.domain.model.ETypeOfBirth;
import id.ipaddr.android.rereso.presentation.presenter.CertificateOfBirthDataSetDetailPresenter;
import id.ipaddr.android.rereso.util.DateUtil;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by iip on 3/28/17.
 */

public class StepDetailFragment extends Fragment
        implements
        BlockingStep
    , View.OnClickListener
{

    public static final String TAG = StepDetailFragment.class.getSimpleName();

    public static final String POSITION = "id.ipaddr.android.rereso.presentation.view.fragment.StepDetailFragment.POSITION";

    @BindView(R.id.til_kk_name) TextInputLayout tilPatriarchName;
    @BindView(R.id.acet_kk_name) AppCompatEditText acetPatriarchName;
    @BindView(R.id.til_kk_num) TextInputLayout tilPatriarchNum;
    @BindView(R.id.acet_kk_num) AppCompatEditText acetPatriarchNum;
    @BindView(R.id.til_nik) TextInputLayout tilNik;
    @BindView(R.id.acet_nik) AppCompatEditText acetNik;
    @BindView(R.id.til_name) TextInputLayout tilName;
    @BindView(R.id.acet_name) AppCompatEditText acetName;
    @BindView(R.id.ll_sex) LinearLayout llSex;
    @BindView(R.id.rg_sex) RadioGroup rgSex;
    @BindView(R.id.rg_sex_rb_male) RadioButton rbMale;
    @BindView(R.id.rg_sex_rb_female) RadioButton rbFemale;
    @BindView(R.id.ll_born_place) LinearLayout llBornPlace;
    @BindView(R.id.rg_born_place) RadioGroup rgBronPlace;
    @BindView(R.id.rg_born_place_rs) RadioButton rgBronPlaceRS;
    @BindView(R.id.rg_born_place_puskesmas) RadioButton rgBronPlacePuskesmas;
    @BindView(R.id.rg_born_place_polindes) RadioButton rgBronPlacePolindes;
    @BindView(R.id.rg_born_place_home) RadioButton rgBronPlaceHome;
    @BindView(R.id.rg_born_place_others) RadioButton rgBronPlaceOthers;
    @BindView(R.id.til_born_location) TextInputLayout tilBornLocation;
    @BindView(R.id.acet_born_location) AppCompatEditText acetBornLocation;
    @BindView(R.id.til_born_day) TextInputLayout tilBornDay;
    @BindView(R.id.acet_born_day) AppCompatEditText acetBornDay;
    @BindView(R.id.til_born_date) TextInputLayout tilBornDate;
    @BindView(R.id.acet_born_date) AppCompatEditText acetBornDate;
    @BindView(R.id.til_born_time) TextInputLayout tilBornTime;
    @BindView(R.id.acet_born_time) AppCompatEditText acetBornTime;
    @BindView(R.id.til_age) TextInputLayout tilAge;
    @BindView(R.id.acet_age) AppCompatEditText acetAge;
    @BindView(R.id.til_job) TextInputLayout tilJob;
    @BindView(R.id.acet_job) AppCompatEditText acetJob;
    @BindView(R.id.til_address) TextInputLayout tilAddress;
    @BindView(R.id.acet_address) AppCompatEditText acetAddress;
    @BindView(R.id.til_village) TextInputLayout tilVillage;
    @BindView(R.id.acet_village) AppCompatEditText acetVillage;
    @BindView(R.id.til_subdistrict) TextInputLayout tilSubDistrict;
    @BindView(R.id.acet_subdistrict) AppCompatEditText acetSubDistrcit;
    @BindView(R.id.til_district) TextInputLayout tilDistrict;
    @BindView(R.id.acet_district) AppCompatEditText acetDistrict;
    @BindView(R.id.til_state) TextInputLayout tilState;
    @BindView(R.id.acet_state) AppCompatEditText acetState;
    @BindView(R.id.ll_nationality) LinearLayout llNationality;
    @BindView(R.id.rg_nationality) RadioGroup rgNationality;
    @BindView(R.id.rg_nationality_wni) RadioButton rbWNI;
    @BindView(R.id.rg_nationality_wna) RadioButton rbWNA;
    @BindView(R.id.til_ethnic) TextInputLayout tilEthnic;
    @BindView(R.id.acet_ethnic) AppCompatEditText acetEthnic;
    @BindView(R.id.til_married_date) TextInputLayout tilMarriedDate;
    @BindView(R.id.acet_married_date) AppCompatEditText acetMarriedDate;
    @BindView(R.id.ll_born_type) LinearLayout llBornType;
    @BindView(R.id.rg_born_type) RadioGroup rgBornType;
    @BindView(R.id.rg_born_type_single) RadioButton rbSingle;
    @BindView(R.id.rg_born_type_twin) RadioButton rbTwin;
    @BindView(R.id.rg_born_type_triplets) RadioButton rbTriplets;
    @BindView(R.id.rg_born_type_quadruplets) RadioButton rbQuadruplets;
    @BindView(R.id.rg_born_type_others) RadioButton rbBornTypeOthers;
    @BindView(R.id.til_born_seq) TextInputLayout tilBornSeq;
    @BindView(R.id.acet_born_seq) AppCompatEditText acetBornSeq;
    @BindView(R.id.ll_born_helper) LinearLayout llBornHelper;
    @BindView(R.id.rg_born_helper) RadioGroup rgBronHelper;
    @BindView(R.id.rg_born_helper_docter) RadioButton rbDocter;
    @BindView(R.id.rg_born_helper_tocologist_nurse) RadioButton rbTocologistNurse;
    @BindView(R.id.rg_born_helper_midwife) RadioButton rgMidwife;
    @BindView(R.id.rg_born_helper_others) RadioButton rbBornHelperOthers;
    @BindView(R.id.til_baby_weight) TextInputLayout tilBabyWeight;
    @BindView(R.id.acet_baby_weight) AppCompatEditText acetBabyWeight;
    @BindView(R.id.til_baby_height) TextInputLayout tilBabyHeight;
    @BindView(R.id.acet_baby_height) AppCompatEditText acetBabyHeight;
    @BindView(R.id.ll_sig_first_spectator) LinearLayout llSigFirstSpectator;
    @BindView(R.id.signature_first_spectator) SignaturePad sigFirstSpectator;
    @BindView(R.id.acb_clear_sig_first_spectator) AppCompatButton acbFirstSpectator;
    @BindView(R.id.ll_sig_second_spectator) LinearLayout llSigSecondSpectator;
    @BindView(R.id.signature_second_spectator) SignaturePad sigSecondSpectator;
    @BindView(R.id.acb_clear_sig_second_spectator) AppCompatButton acbSecondSpectator;
    @BindView(R.id.ll_sig_rapporteur) LinearLayout llSigRapporteurSpectator;
    @BindView(R.id.signature_rapporteur) SignaturePad sigRapporteurSpectator;
    @BindView(R.id.acb_clear_sig_rapporture) AppCompatButton acbRapportureSpectator;

    private int position = -1;

    private CertificateOfBirthDataSetDetailPresenter mCertificateOfBirthDataSetDetailPresenter;
    public void setCertificateOfBirthDataSetDetailPresenter(CertificateOfBirthDataSetDetailPresenter certificateOfBirthDataSetDetailPresenter) {
        this.mCertificateOfBirthDataSetDetailPresenter = certificateOfBirthDataSetDetailPresenter;
    }

    public StepDetailFragment(){
        setRetainInstance(true);
    }

    public static StepDetailFragment newInstance(int position){
        StepDetailFragment f = new StepDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(POSITION, position);
        f.setArguments(bundle);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stepper, container, false);
        ButterKnife.bind(this, view);
        setOnButonSignatureClearCLickListener();
        return view;
    }

    private void setOnButonSignatureClearCLickListener(){
        acbFirstSpectator.setOnClickListener(this);
        acbSecondSpectator.setOnClickListener(this);
        acbRapportureSpectator.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.acb_clear_sig_first_spectator:
                sigFirstSpectator.clear();
                break;
            case R.id.acb_clear_sig_second_spectator:
                sigSecondSpectator.clear();
                break;
            case R.id.acb_clear_sig_rapporture:
                sigRapporteurSpectator.clear();
                break;
            default:break;
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hideAllView();
        if (getArguments() != null && getArguments().containsKey(POSITION))
            position = getArguments().getInt(POSITION);
        if (position != -1){
            switch (position){
                case 0:patriarchData();
                    break;
                case 1:babyData();
                    break;
                case 2:
                case 3:fatherOrMotherData();
                    break;
                case 4:
                case 5:
                case 6:rapporteurOrSpectatorData();
                    break;
                case 7: signatureData();
                    break;
                default:break;
            }
        }
    }

    private void hideAllView(){
        // Patriarch data
        tilPatriarchName.setVisibility(View.GONE);
        tilPatriarchNum.setVisibility(View.GONE);

        // Baby data
        tilName.setVisibility(View.GONE);
        llSex.setVisibility(View.GONE);
        llBornPlace.setVisibility(View.GONE);
        tilBornLocation.setVisibility(View.GONE);
        tilBornDay.setVisibility(View.GONE);
        tilBornDate.setVisibility(View.GONE);
        tilBornTime.setVisibility(View.GONE);
        llBornType.setVisibility(View.GONE);
        tilBornSeq.setVisibility(View.GONE);
        llBornHelper.setVisibility(View.GONE);
        tilBabyWeight.setVisibility(View.GONE);
        tilBabyHeight.setVisibility(View.GONE);

        // Father / mother data
        tilNik.setVisibility(View.GONE);
        tilAge.setVisibility(View.GONE);
        tilJob.setVisibility(View.GONE);
        tilAddress.setVisibility(View.GONE);
        tilVillage.setVisibility(View.GONE);
        tilSubDistrict.setVisibility(View.GONE);
        tilDistrict.setVisibility(View.GONE);
        tilState.setVisibility(View.GONE);
        llNationality.setVisibility(View.GONE);
        tilEthnic.setVisibility(View.GONE);
        tilMarriedDate.setVisibility(View.GONE);

        // rapporteur / spectator data

        // Signature
        llSigFirstSpectator.setVisibility(View.GONE);
        llSigSecondSpectator.setVisibility(View.GONE);
        llSigRapporteurSpectator.setVisibility(View.GONE);

    }

    private void patriarchData(){
        tilPatriarchName.setVisibility(View.VISIBLE);
        tilPatriarchNum.setVisibility(View.VISIBLE);
    }

    private boolean verifyAndSavePatriarchData(){
        String patriarch = acetPatriarchName.getText().toString();
        String familyCardNumber = acetPatriarchNum.getText().toString();
        if (!TextUtils.isEmpty(patriarch) && !TextUtils.isEmpty(familyCardNumber)) {
            CertificateOfBirthData cd = mCertificateOfBirthDataSetDetailPresenter.getCertificateOfBirthData();
            checkOrGenerateForm(cd);
            CertificateOfBirthForm cf = cd.getCertificateOfBirthForm();
            cf.setPatriarch(patriarch);
            cf.setFamilyCardNumber(familyCardNumber);
            cd.setCertificateOfBirthForm(cf);
            return true;
        }
        return false;
    }

    private void babyData(){
        tilName.setVisibility(View.VISIBLE);
        llSex.setVisibility(View.VISIBLE);
        llBornPlace.setVisibility(View.VISIBLE);
        tilBornLocation.setVisibility(View.VISIBLE);
        tilBornDay.setVisibility(View.VISIBLE);
        tilBornDate.setVisibility(View.VISIBLE);
        tilBornTime.setVisibility(View.VISIBLE);
        llBornType.setVisibility(View.VISIBLE);
        tilBornSeq.setVisibility(View.VISIBLE);
        llBornHelper.setVisibility(View.VISIBLE);
        tilBabyWeight.setVisibility(View.VISIBLE);
        tilBabyHeight.setVisibility(View.VISIBLE);
    }

    private boolean verifyAndSaveBabyData(){
        String babyName = acetName.getText().toString();

        int rbSexidx = -1;
        String babySex = null;
        if (rgSex.getCheckedRadioButtonId() != -1) {
            int rbSexID = rgSex.getCheckedRadioButtonId();
            View rbSexView = rgSex.findViewById(rbSexID);
            rbSexidx = rgSex.indexOfChild(rbSexView);
            RadioButton rbSex = (RadioButton) rgSex.getChildAt(rbSexidx);
            babySex = rbSex.getText().toString();
        }

        int rbPlaceidx = -1;
        String babyBornPlace = null;
        if (rgBronPlace.getCheckedRadioButtonId() != -1) {
            int rbPlaceID = rgBronPlace.getCheckedRadioButtonId();
            View rbPlaceView = rgBronPlace.findViewById(rbPlaceID);
            rbPlaceidx = rgBronPlace.indexOfChild(rbPlaceView);
            RadioButton rbPlace = (RadioButton) rgBronPlace.getChildAt(rbPlaceidx);
            babyBornPlace = rbPlace.getText().toString();
        }

        String babyBornLocation = acetBornLocation.getText().toString();
        String babyBornDay = acetBornDay.getText().toString();
        String babyBornDate = acetBornDate.getText().toString();
        String babyBornTime = acetBornTime.getText().toString();

        int rbBornTypeidx = -1;
        String babyBornType = null;
        if (rgBornType.getCheckedRadioButtonId() != -1) {
            int rbBornTypeID = rgBornType.getCheckedRadioButtonId();
            View rbBornTypeView = rgBornType.findViewById(rbBornTypeID);
            rbBornTypeidx = rgBornType.indexOfChild(rbBornTypeView);
            RadioButton rbBornType = (RadioButton) rgBornType.getChildAt(rbBornTypeidx);
            babyBornType = rbBornType.getText().toString();
        }

        String babyBornSeq = acetBornSeq.getText().toString();

        int rbBornHelperidx = -1;
        String babyrbBornHelper = null;
        if (rgBronHelper.getCheckedRadioButtonId() != -1) {
            int rbBornHelperID = rgBronHelper.getCheckedRadioButtonId();
            View rbBornHelperView = rgBronHelper.findViewById(rbBornHelperID);
            rbBornHelperidx = rgBronHelper.indexOfChild(rbBornHelperView);
            RadioButton rbBornHelper = (RadioButton) rgBronHelper.getChildAt(rbBornHelperidx);
            babyrbBornHelper = rbBornHelper.getText().toString();
        }

        String babyWeight = acetBabyWeight.getText().toString();
        String babyHeight = acetBabyHeight.getText().toString();

        if (!TextUtils.isEmpty(babyName) && !TextUtils.isEmpty(babySex) && !TextUtils.isEmpty(babyBornPlace) && !TextUtils.isEmpty(babyBornLocation)
                && !TextUtils.isEmpty(babyBornDay) && !TextUtils.isEmpty(babyBornDate) && !TextUtils.isEmpty(babyBornTime) && !TextUtils.isEmpty(babyBornType)
                && !TextUtils.isEmpty(babyBornSeq) && !TextUtils.isEmpty(babyrbBornHelper) && !TextUtils.isEmpty(babyWeight) && !TextUtils.isEmpty(babyHeight)) {

            Baby baby = new Baby(babyName, ESex.fromId(rbSexidx), EPlaceOfBirth.fromId(rbPlaceidx), babyBornLocation
                    , DateUtil.dateFromString(babyBornDate), DateUtil.timeFromString(babyBornTime), ETypeOfBirth.fromId(rbBornTypeidx), Integer.valueOf(babyBornSeq), EBirthHelper.fromId(rbBornHelperidx)
                    , Float.valueOf(babyWeight), Float.valueOf(babyHeight));

            CertificateOfBirthData cd = mCertificateOfBirthDataSetDetailPresenter.getCertificateOfBirthData();
            checkOrGenerateForm(cd);
            CertificateOfBirthForm cf = cd.getCertificateOfBirthForm();
            cf.setBaby(baby);
            cd.setCertificateOfBirthForm(cf);

            return true;
        }
        return false;
    }

    private void fatherOrMotherData(){
        tilNik.setVisibility(View.VISIBLE);
        tilName.setVisibility(View.VISIBLE);
        tilBornDate.setVisibility(View.VISIBLE);
        tilAge.setVisibility(View.VISIBLE);
        tilJob.setVisibility(View.VISIBLE);
        tilAddress.setVisibility(View.VISIBLE);
        tilVillage.setVisibility(View.VISIBLE);
        tilSubDistrict.setVisibility(View.VISIBLE);
        tilDistrict.setVisibility(View.VISIBLE);
        tilState.setVisibility(View.VISIBLE);
        llNationality.setVisibility(View.VISIBLE);
        tilEthnic.setVisibility(View.VISIBLE);
        tilMarriedDate.setVisibility(View.VISIBLE);
    }

    private void rapporteurOrSpectatorData(){
        tilNik.setVisibility(View.VISIBLE);
        tilName.setVisibility(View.VISIBLE);
        tilBornDate.setVisibility(View.VISIBLE);
        tilAge.setVisibility(View.VISIBLE);
        llSex.setVisibility(View.GONE);
        tilJob.setVisibility(View.VISIBLE);
        tilAddress.setVisibility(View.VISIBLE);
        tilVillage.setVisibility(View.VISIBLE);
        tilSubDistrict.setVisibility(View.VISIBLE);
        tilDistrict.setVisibility(View.VISIBLE);
        tilState.setVisibility(View.VISIBLE);
    }

    private boolean verifyAndSaveFatherOrMotherOrrapporteurOrSpectatorData(int position){
        // 2 is father, 3 is mother
        String nik = acetNik.getText().toString();
        String name  = acetName.getText().toString();
        String bornDate = acetBornDate.getText().toString();
        String age = acetAge.getText().toString();
        String job = acetJob.getText().toString();
        String streetAddress = acetAddress.getText().toString();
        String village  = acetVillage.getText().toString();
        String subDistrict = acetSubDistrcit.getText().toString();
        String district = acetDistrict.getText().toString();
        String state = acetState.getText().toString();

        int rbNationalityidx = -1;
        String nationality = null;
        if (rgNationality.getCheckedRadioButtonId() != -1) {
            int rbNationalityID = rgNationality.getCheckedRadioButtonId();
            View rbNationalityView = rgNationality.findViewById(rbNationalityID);
            rbNationalityidx = rgNationality.indexOfChild(rbNationalityView);
            RadioButton rbNationality = (RadioButton) rgNationality.getChildAt(rbNationalityidx);
            nationality = rbNationality.getText().toString();
        }

        String ethnic = acetEthnic.getText().toString();
        String marriedDate = acetMarriedDate.getText().toString();


        if (!TextUtils.isEmpty(nik) && !TextUtils.isEmpty(name) && !TextUtils.isEmpty(bornDate) && !TextUtils.isEmpty(age) && !TextUtils.isEmpty(job)
                && !TextUtils.isEmpty(streetAddress) && !TextUtils.isEmpty(village) && !TextUtils.isEmpty(subDistrict) && !TextUtils.isEmpty(district) && !TextUtils.isEmpty(state)) {

            CertificateOfBirthData cd = mCertificateOfBirthDataSetDetailPresenter.getCertificateOfBirthData();
            checkOrGenerateForm(cd);
            CertificateOfBirthForm cf = cd.getCertificateOfBirthForm();

            Address address = new Address(streetAddress, village, subDistrict, district, state, null);
            Citizen citizen = null;
            if (position == 2){
                // father
                if (!TextUtils.isEmpty(nationality) && !TextUtils.isEmpty(ethnic) && !TextUtils.isEmpty(marriedDate)) {
                    citizen = new Citizen(nik, name, ESex.Male, DateUtil.dateFromString(bornDate), Integer.valueOf(age), job, address, ECitizenship.fromId(rbNationalityidx), nationality, DateUtil.dateFromString(marriedDate));
                    cf.setFather(citizen);
                } else {
                    return false;
                }
            } else if (position == 3){
                // mother
                if (!TextUtils.isEmpty(nationality) && !TextUtils.isEmpty(ethnic) && !TextUtils.isEmpty(marriedDate)) {
                    citizen = new Citizen(nik, name, ESex.Female, DateUtil.dateFromString(bornDate), Integer.valueOf(age), job, address, ECitizenship.fromId(rbNationalityidx), nationality, DateUtil.dateFromString(marriedDate));
                    cf.setMother(citizen);
                } else {
                    return false;
                }
            } else if (position == 4){
                // rapporteur
                citizen = new Citizen(nik, name, DateUtil.dateFromString(bornDate), Integer.valueOf(age), job, address, ECitizenship.fromId(rbNationalityidx), nationality, DateUtil.dateFromString(marriedDate));
                cf.setRapporteur(citizen);
            } else if (position == 5){
                // rapporteur
                citizen = new Citizen(nik, name, DateUtil.dateFromString(bornDate), Integer.valueOf(age), job, address, ECitizenship.fromId(rbNationalityidx), nationality, DateUtil.dateFromString(marriedDate));
                cf.setFirstSpectator(citizen);
            } else if (position == 6){
                // rapporteur
                citizen = new Citizen(nik, name, DateUtil.dateFromString(bornDate), Integer.valueOf(age), job, address, ECitizenship.fromId(rbNationalityidx), nationality, DateUtil.dateFromString(marriedDate));
                cf.setSecondSpectator(citizen);
            }
            return true;
        }
        return false;
    }

    private void signatureData(){
        llSigFirstSpectator.setVisibility(View.VISIBLE);
        llSigSecondSpectator.setVisibility(View.VISIBLE);
        llSigRapporteurSpectator.setVisibility(View.VISIBLE);
    }

    private boolean verifySignatureData(){

        if (sigFirstSpectator.isEmpty() || sigSecondSpectator.isEmpty() || sigRapporteurSpectator.isEmpty())
            return false;

        String sfs = sigFirstSpectator.getSignatureSvg();
        String sss = sigSecondSpectator.getSignatureSvg();
        String srs = sigRapporteurSpectator.getSignatureSvg();

        if (!TextUtils.isEmpty(sfs) && !TextUtils.isEmpty(sss) && !TextUtils.isEmpty(srs)){
            CertificateOfBirthData cd = mCertificateOfBirthDataSetDetailPresenter.getCertificateOfBirthData();
            checkOrGenerateForm(cd);
            CertificateOfBirthForm cf = cd.getCertificateOfBirthForm();
            cf.setFirstSpectatorSignature(sfs);
            cf.setSecondSpectatorSignature(sss);
            cf.setRapporteurSignature(srs);
            return true;
        }

        return false;
    }

    private void checkOrGenerateForm(CertificateOfBirthData cd){
        if (null == cd.getCertificateOfBirthForm()){
            CertificateOfBirthForm cf = new CertificateOfBirthForm();
            cd.setCertificateOfBirthForm(cf);
        }
        return ;
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
        if (position != -1){
            switch (position){
                case 0:
                    verifyAndSavePatriarchData();
                    break;
                case 1:
                    verifyAndSaveBabyData();
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    verifyAndSaveFatherOrMotherOrrapporteurOrSpectatorData(position);
                    break;
                case 7: verifySignatureData();
                    break;
                default:break;
            }
        }
        callback.goToNextStep();
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        Log.d(TAG, "onCompleteClicked");
        callback.complete();
    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        Log.d(TAG, "onBackClicked");
        callback.goToPrevStep();
    }
}
