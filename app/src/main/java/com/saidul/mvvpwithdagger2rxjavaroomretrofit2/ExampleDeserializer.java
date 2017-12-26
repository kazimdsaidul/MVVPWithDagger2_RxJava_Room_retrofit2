package com.saidul.mvvpwithdagger2rxjavaroomretrofit2;




import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;



public class ExampleDeserializer implements JsonDeserializer<Double> {

    private static final String TAG = "";


    @Override
    public Double deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Double aDouble = Double.valueOf(json.getAsDouble());

        return aDouble;
    }
}
