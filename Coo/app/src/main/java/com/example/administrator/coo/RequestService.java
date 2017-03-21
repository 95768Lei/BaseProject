package com.example.administrator.coo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by zhanglei on 2017/3/13 0013.
 */

public interface RequestService {
    @GET(API.GET_POLICYLIST_URL)
    Call<String> getString();
}
