package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 11/7/2017.
 */

public class APIResponse {

    @SerializedName("status_code")
    @Expose
    private Integer statusCode;
    @SerializedName("result")
    @Expose
    private Double result;
    @SerializedName("rate")
    @Expose
    private Double rate;

    private Throwable error;

    public APIResponse(Throwable t) {
        this.error = t;

    }

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

}
