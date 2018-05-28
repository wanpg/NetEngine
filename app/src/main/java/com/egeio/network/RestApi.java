package com.egeio.network;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RestApi {

    @GET
    public Observable<String> baidu();

}
