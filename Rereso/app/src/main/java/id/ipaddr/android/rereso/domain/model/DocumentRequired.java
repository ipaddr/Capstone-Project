package id.ipaddr.android.rereso.domain.model;

import android.graphics.Bitmap;

/**
 * Created by iip on 3/26/17.
 */

public final class DocumentRequired {

    private String documentTitle;
    private String documentImageBase64;
    private String documentImageURI;
    private boolean isRequired;

    private DocumentRequired(Builder builder){
        this.documentTitle = builder.documentTitle;
        this.documentImageBase64 = builder.documentImageBase64;
        this.documentImageURI = builder.documentImageURI;
        this.isRequired = builder.isRequired;
    }

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


    public static class Builder {
        private String documentTitle;
        private String documentImageBase64;
        private String documentImageURI;
        private boolean isRequired;

        public String withDocumentTitle(){
            return documentTitle;
        }

        public String withDocumentImageBase64() { return documentImageBase64; }

        public String withDocumentImageURI(){
            return documentImageURI;
        }

        public boolean withIsRequired(){
            return isRequired;
        }

        public DocumentRequired build(){
            return new DocumentRequired(this);
        }

    }
}
