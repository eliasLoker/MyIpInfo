package com.example.myipinfo.retrofit;

import com.example.myipinfo.retrofit.detailedinfo.MessageDetailedApi;
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
    private static final String BASE_MESSAGE_DETAILED_URL = "https://ipapi.co/";

    public static MessageApi getMessageIp() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_IP_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(MessageApi.class);
    }

    public static MessageDetailedApi getMessageDetailed() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_MESSAGE_DETAILED_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(MessageDetailedApi.class);
    }
}
