package com.example.myipinfo.retrofit.detailedinfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Alexandr Mikhalev on 12.05.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface MessageDetailedApi {

    @GET("/{ip}/json/")
    Call<MessageDetailed> messageDetailed(@Path("ip")String ip);
}
