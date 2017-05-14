package id.ipaddr.android.rereso.util;

import android.graphics.Bitmap;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;
import id.ipaddr.android.rereso.domain.model.Address;
import id.ipaddr.android.rereso.domain.model.Baby;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthForm;
import id.ipaddr.android.rereso.domain.model.Citizen;
import id.ipaddr.android.rereso.domain.model.DocumentRequired;
import id.ipaddr.android.rereso.domain.model.EBirthHelper;
import id.ipaddr.android.rereso.domain.model.ECertificateOfBirthState;
import id.ipaddr.android.rereso.domain.model.ECitizenship;
import id.ipaddr.android.rereso.domain.model.EPlaceOfBirth;
import id.ipaddr.android.rereso.domain.model.ESex;
import id.ipaddr.android.rereso.domain.model.ETypeOfBirth;
import id.ipaddr.android.rereso.domain.model.EUserType;
import id.ipaddr.android.rereso.domain.model.UserAction;

/**
 * Created by iip on 3/24/17.
 */

public class TestClass {

    public static void test(){
        DatabaseReference dbr = FirebaseDatabase.getInstance().getReference(CertificateOfBirthData.class.getSimpleName());
        List<CertificateOfBirthDataEntity> datas = generateList();
        for (CertificateOfBirthDataEntity entity : datas){
            dbr.push().setValue(entity);
        }
    }

    /**
     * additional
     */
    public static List<CertificateOfBirthDataEntity> generateList(){
        List<CertificateOfBirthDataEntity> datas = new ArrayList<CertificateOfBirthDataEntity>();
        CertificateOfBirthDataEntity e = new CertificateOfBirthDataEntity(add());
        datas.add(e);
        datas.add(e);
        datas.add(e);
        datas.add(e);
        datas.add(e);
        datas.add(e);
        datas.add(e);
        datas.add(e);
        datas.add(e);
        datas.add(e);
        datas.add(e);
        datas.add(e);
        datas.add(e);
        datas.add(e);
        datas.add(e);
        datas.add(e);
        return datas;
    }

    private static CertificateOfBirthData add(){
        String photoLocationURL = "https://firebasestorage.googleapis.com/v0/b/rereso-fc354.appspot.com/o/Photo.jpg?alt=media&token=a90a0793-fd96-45d4-a789-d5567a39b19e";

        Calendar calendarBaby = Calendar.getInstance();
        calendarBaby.set(2016, 6, 12, 10, 36);
        Date babyBorn = calendarBaby.getTime();

        Calendar calendarMam = Calendar.getInstance();
        calendarMam.set(1988, 3, 12, 11, 00);
        Date maBorn = calendarBaby.getTime();

        Calendar calendarDad = Calendar.getInstance();
        calendarDad.set(1985, 2, 29, 22, 00);
        Date dadBorn = calendarBaby.getTime();

        Calendar calendarMamDad = Calendar.getInstance();
        calendarMamDad.set(2014, 5, 2, 11, 00);
        Date mamDadMarriage = calendarBaby.getTime();

        Calendar calendarUncu = Calendar.getInstance();
        calendarUncu.set(1993, 2, 28, 22, 00);
        Date uncuBorn = calendarBaby.getTime();

        Calendar calendarTami = Calendar.getInstance();
        calendarTami.set(1990, 1, 1, 01, 01);
        Date tamiBorn = calendarBaby.getTime();

        UserAction userAction = new UserAction("i_p_addr@yahoo.com", EUserType.VillageOfficer, new Date(), ECertificateOfBirthState.Unknow);

        DocumentRequired documentRequired = new DocumentRequired("Doc Title", photoLocationURL, false);

        return addCertificateOfBirth("Iip Permana", "123456789", "foto", "Meca Alesha"
                , ESex.Female, EPlaceOfBirth.RS_RB, "Jakarta", babyBorn, babyBorn
                , ETypeOfBirth.Tunggal, 1, EBirthHelper.Dokter, 3.6f, 5.1f
                , "0987654321", "Ulfia Izzati", maBorn, 29, "Docter"
                , "Latumenten no. 33", "Jembatan Besi", "Tambora", "JakartaBarat", "DKI Jakarta", "11320"
                , ECitizenship.Native, "WNI", mamDadMarriage
                , "0192837465", "Iip Permana", dadBorn, 32, "IT"
                , "Latumenten no. 33", "Jembatan Besi", "Tambora", "JakartaBarat", "DKI Jakarta", "11320"
                , ECitizenship.Native, "WNI", mamDadMarriage
                , "0192837465", "Iip Permana", dadBorn, 32, "IT"
                , "Latumenten no. 33", "Jembatan Besi", "Tambora", "JakartaBarat", "DKI Jakarta", "11320"
                , ECitizenship.Native, "WNI", mamDadMarriage
                , "2382392033", "Ade Pratiwi", uncuBorn, 24, "Bankir"
                , "Latumenten no. 33", "Jembatan Besi", "Tambora", "JakartaBarat", "DKI Jakarta", "11320"
                , ECitizenship.Native, "WNI", null
                , "123829283", "Rahmi Kurnia", tamiBorn, 27, "Bankir"
                , "Latumenten no. 33", "Jembatan Besi", "Tambora", "JakartaBarat", "DKI Jakarta", "11320"
                , ECitizenship.Native, "WNI", null
                , photoLocationURL, photoLocationURL, photoLocationURL, UUID.randomUUID().toString(), documentRequired, documentRequired
                , documentRequired, documentRequired, documentRequired, documentRequired, documentRequired
                , documentRequired, documentRequired, documentRequired, documentRequired, documentRequired
                , documentRequired, documentRequired, documentRequired, ECertificateOfBirthState.Unknow, userAction
        );
    }

    private static CertificateOfBirthData addCertificateOfBirth(String patriarch, String familyCardNumber
            , String babyFoto, String babyName, ESex babySex, EPlaceOfBirth ePlaceOfBirth, String babyBirthPlace, Date dateOfBabyBirth, Date timeOfBabyBirth
            , ETypeOfBirth eTypeOfBirth, int birthSequenceAt, EBirthHelper eBirthHelper, float babyWeight, float babyHeight
            , String motherNik, String motherFullName, Date motherbirthday, int motherAge, String motherOccupation
            , String motherStreetDetail, String motherVillage, String motherSubDistrict, String motherDistrict, String motherState, String motherPostalCode
            , ECitizenship motherECitizenship, String motherNotionality, Date motherMaritalDate
            , String fatherNik, String fatherFullName, Date fatherbirthday, int fatherAge, String fatherOccupation
            , String fatherStreetDetail, String fatherVillage, String fatherSubDistrict, String fatherDistrict, String fatherState, String fatherPostalCode
            , ECitizenship fatherECitizenship, String fatherNotionality, Date fatherMaritalDate
            , String rapporteurNik, String rapporteurFullName, Date rapporteurbirthday, int rapporteurAge, String rapporteurOccupation
            , String rapporteurStreetDetail, String rapporteurVillage, String rapporteurSubDistrict, String rapporteurDistrict, String rapporteurState, String repporteurPostalCode
            , ECitizenship rapporteurECitizenship, String rapporteurNotionality, Date rapporteurMaritalDate
            , String firstSpectatorNik, String firstSpectatorFullName, Date firstSpectatorbirthday, int firstSpectatorAge, String firstSpectatorOccupation
            , String firstSpectatorStreetDetail, String firstSpectatorVillage, String firstSpectatorSubDistrict, String firstSpectatorDistrict, String firstSpectatorState, String firstSpectatorPostalCode
            , ECitizenship firstSpectatorECitizenship, String firstSpectatorNotionality, Date firstSpectatorMaritalDate
            , String secondSpectatorNik, String secondSpectatorFullName, Date secondSpectatorbirthday, int secondSpectatorAge, String secondSpectatorOccupation
            , String secondSpectatorStreetDetail, String secondSpectatorVillage, String secondSpectatorSubDistrict, String secondSpectatorDistrict, String secondSpectatorState, String secondSpectatorPostalCode
            , ECitizenship secondSpectatorECitizenship, String secondSpectatorNotionality, Date secondSpectatorMaritalDate
            , String rapporteurSignature, String firstSpectatorSignature, String secondSpectatorSignature, String id, DocumentRequired imgOfCertificateOfBirthForm, DocumentRequired householdRecommendationLetter
            , DocumentRequired placeOfBirthCertificateLetter, DocumentRequired familyIdentityCard, DocumentRequired fatherIdCard, DocumentRequired motherIdCard, DocumentRequired maritalCertificateLetter
            , DocumentRequired fatherCertificateOfBirth, DocumentRequired motherCertificateOfBirth, DocumentRequired fatherPassport, DocumentRequired motherPassport, DocumentRequired firstSpectatorIdCard
            , DocumentRequired secondSpectatorIdCard, DocumentRequired policeCertificateForUnfamiliyBaby, DocumentRequired socialServicesCertificateForVulnerableResidents
            , ECertificateOfBirthState eCertificateOfBirthState , UserAction userAction
    ){
        Baby baby = new Baby(babyFoto, babyName, babySex, ePlaceOfBirth, babyBirthPlace, dateOfBabyBirth, timeOfBabyBirth
                , eTypeOfBirth, birthSequenceAt, eBirthHelper, babyWeight, babyHeight);

        Address motherAddress = new Address(motherStreetDetail, motherVillage, motherSubDistrict, motherDistrict, motherState, motherPostalCode);
        Citizen mother = new Citizen(motherNik, motherFullName, motherbirthday, motherAge
                , motherOccupation, motherAddress, motherECitizenship, motherNotionality, motherMaritalDate);

        Address fatherAddress = new Address(fatherStreetDetail, fatherVillage, fatherSubDistrict, fatherDistrict, fatherState, fatherPostalCode);
        Citizen father = new Citizen(fatherNik, fatherFullName, fatherbirthday, fatherAge
                , fatherOccupation, fatherAddress, fatherECitizenship, fatherNotionality, fatherMaritalDate);

        Address rapporteurAddress = new Address(rapporteurStreetDetail, rapporteurVillage, rapporteurSubDistrict, rapporteurDistrict, rapporteurState, repporteurPostalCode);
        Citizen rapporteur = new Citizen(rapporteurNik, rapporteurFullName, rapporteurbirthday, rapporteurAge
                , rapporteurOccupation, rapporteurAddress, rapporteurECitizenship, rapporteurNotionality, rapporteurMaritalDate);

        Address firstSpectatorAddress = new Address(firstSpectatorStreetDetail, firstSpectatorVillage, firstSpectatorSubDistrict, firstSpectatorDistrict, firstSpectatorState, firstSpectatorPostalCode);
        Citizen firstSpectator = new Citizen(firstSpectatorNik, firstSpectatorFullName, firstSpectatorbirthday, firstSpectatorAge
                , firstSpectatorOccupation, firstSpectatorAddress, firstSpectatorECitizenship, firstSpectatorNotionality, firstSpectatorMaritalDate);

        Address secondSpectatorAddress = new Address(secondSpectatorStreetDetail, secondSpectatorVillage, secondSpectatorSubDistrict, secondSpectatorDistrict, secondSpectatorState, secondSpectatorPostalCode);
        Citizen secondSpectator = new Citizen(secondSpectatorNik, secondSpectatorFullName, secondSpectatorbirthday, secondSpectatorAge
                , secondSpectatorOccupation, secondSpectatorAddress, secondSpectatorECitizenship, secondSpectatorNotionality, secondSpectatorMaritalDate);

        CertificateOfBirthForm certificateOfBirthForm = new CertificateOfBirthForm(patriarch, familyCardNumber, baby, mother, father
                , rapporteur, firstSpectator, secondSpectator, rapporteurSignature, firstSpectatorSignature, secondSpectatorSignature);

        CertificateOfBirthData certificateOfBirthData = new CertificateOfBirthData(certificateOfBirthForm, imgOfCertificateOfBirthForm
                , householdRecommendationLetter, placeOfBirthCertificateLetter, familyIdentityCard, fatherIdCard, motherIdCard
                , maritalCertificateLetter, fatherCertificateOfBirth, motherCertificateOfBirth, fatherPassport, motherPassport
                , firstSpectatorIdCard, secondSpectatorIdCard, policeCertificateForUnfamiliyBaby, socialServicesCertificateForVulnerableResidents
                , eCertificateOfBirthState, userAction);

        return certificateOfBirthData;
    }
}
