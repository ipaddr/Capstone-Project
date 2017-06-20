package id.ipaddr.android.rereso.domain.model;

import android.graphics.Bitmap;

import java.io.File;

/**
 * Created by iip on 3/26/17.
 */

public final class DocumentRequired {

    private String documentTitle;
    private String documentImageBase64;
    private String documentImageURI;
    private boolean isRequired;
    private Bitmap bitmap;
    private byte[] datas;
    private File file;

    public DocumentRequired(){}

    public DocumentRequired(String documentTitle, boolean isRequired){
        this.documentTitle = documentTitle;
        this.isRequired = isRequired;
    }

    public DocumentRequired(String documentTitle, String documentImageURI, boolean isRequired) {
        this.documentTitle = documentTitle;
        this.documentImageURI = documentImageURI;
        this.isRequired = isRequired;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getDocumentImageBase64() {
        return documentImageBase64;
    }

    public void setDocumentImageBase64(String documentImageBase64) {
        this.documentImageBase64 = documentImageBase64;
    }

    public String getDocumentImageURI() {
        return documentImageURI;
    }

    public void setDocumentImageURI(String documentImageURI) {
        this.documentImageURI = documentImageURI;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }


    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public byte[] getDatas() {
        return datas;
    }

    public void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
