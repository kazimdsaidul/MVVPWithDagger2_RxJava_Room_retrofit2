
package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestBody {

    @SerializedName("ClientId")
    @Expose
    private String clientId;
    @SerializedName("ApiKey")
    @Expose
    private String apiKey;
    @SerializedName("AppId")
    @Expose
    private String appId;
    @SerializedName("Method")
    @Expose
    private String method;
    @SerializedName("Body")
    @Expose
    private Body body;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

}
