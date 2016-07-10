package com.shuh.myapplication.api;

import retrofit2.Call;
import retrofit2.http.Query;
import rx.Observable;

import com.shuh.myapplication.model.F1Model;

import java.util.List;

import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public interface APIService {

    /**
     * 最新趣图
     *
     * @param page
     * @param pagesize
     * @return
     */
//    @FormUrlEncoded
    @GET("joke/img/text.from?key=e4515bebe9e8e39df339f640595b8269&page=1&pagesize=10")
    Observable<Response<List<F1Model>>> getGokeList();
//    Observable<Response<List<F1Model>>> getGokeList(@Query("page") long page, @Query("pagesize") int pagesize);

    @GET("joke/img/text.from?key=e4515bebe9e8e39df339f640595b8269")
    Call<List<F1Model>> getGokeList2(@Query("page") long page, @Query("pagesize") int pagesize);

    @GET("joke/img/text.from?key=e4515bebe9e8e39df339f640595b8269&page=1&pagesize=10")
    Call<String> getGokeList3();
}
