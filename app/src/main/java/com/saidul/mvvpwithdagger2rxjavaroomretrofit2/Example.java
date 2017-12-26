
package com.saidul.mvvpwithdagger2rxjavaroomretrofit2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status_code",
    "result",
    "rate"
})
public class Example {

    @JsonProperty("status_code")
    private Integer statusCode;
    @JsonProperty("result")
    private Double result;
    @JsonProperty("rate")
    private Double rate;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Example() {
    }

    /**
     * 
     * @param statusCode
     * @param result
     * @param rate
     */
    public Example(Integer statusCode, Double result, Double rate) {
        super();
        this.statusCode = statusCode;
        this.result = result;
        this.rate = rate;
    }

    @JsonProperty("status_code")
    public Integer getStatusCode() {
        return statusCode;
    }

    @JsonProperty("status_code")
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @JsonProperty("result")
    public Double getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(Double result) {
        this.result = result;
    }

    @JsonProperty("rate")
    public Double getRate() {
        return rate;
    }

    @JsonProperty("rate")
    public void setRate(Double rate) {
        this.rate = rate;
    }



}
