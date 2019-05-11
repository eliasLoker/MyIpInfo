package com.example.myipinfo.retrofit.ip;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Alexandr Mikhalev on 11.05.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface MessageApi {

    @GET("?format=json")
    Call<MessageIp> messages();
}
