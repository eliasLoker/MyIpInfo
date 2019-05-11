package com.example.myipinfo.retrofit;

import com.example.myipinfo.retrofit.ip.MessageApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alexandr Mikhalev on 11.05.2019.
 *
 * @author Alexandr Mikhalev
 */
public class Controller {
    private static final String BASE_IP_URL = "https://api.ipify.org/";

    public static MessageApi getMessageIp() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_IP_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        MessageApi messagesApi = retrofit.create(MessageApi.class);

        return messagesApi;
    }
}
