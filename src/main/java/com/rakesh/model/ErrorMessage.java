package com.rakesh.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by osboxes on 03/06/16.
 */
@XmlRootElement
public class ErrorMessage {

    private int errorCode;
    private String errorMessaage;

    public ErrorMessage() {
    }

    public ErrorMessage(int errorCode, String errorMessaage) {
        this.errorCode = errorCode;
        this.errorMessaage = errorMessaage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessaage() {
        return errorMessaage;
    }

    public void setErrorMessaage(String errorMessaage) {
        this.errorMessaage = errorMessaage;
    }
}
