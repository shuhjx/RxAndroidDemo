package com.shuh.myapplication.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.shuh.myapplication.Config;
import com.shuh.myapplication.R;
import com.shuh.myapplication.api.APIService;
import com.shuh.myapplication.base.BaseFragment;
import com.shuh.myapplication.holder.F1ViewHolder;
import com.shuh.myapplication.model.F1Model;
import com.shuh.mymodule.adapter.BaseRecyclerAdapter;
import com.shuh.mymodule.utils.LogUtil;
import com.shuh.mymodule.utils.ViewUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class Fragment01 extends BaseFragment {

    private View root;
    private RecyclerView recyclerView;
    private BaseRecyclerAdapter<F1ViewHolder> adapter;
    private List<F1Model> list;

    @Override
    protected View findViews(LayoutInflater inflater) {
        root = inflater.inflate(R.layout.fragment01, null);
        recyclerView = ViewUtil.findViewById(root, R.id.recyclerview);
        return root;
    }

    @Override
    protected void initViews() {
        list = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.addItemDecoration(new DividerItemDecoration);
        recyclerView.setAdapter(adapter = new BaseRecyclerAdapter<>(getContext(), list, R.layout.item_f1, F1ViewHolder.class));
        getDataFromHttp();
    }

    @Override
    protected void initListener() {

    }

    private void getDataFromHttp() {
        for(int i=1;i<=31;i++){
            F1Model f1 = new F1Model();
            f1.setUpdatetime("时间"+i);
            f1.setContent("内容"+1);
            list.add(f1);
        }
        adapter.notifyDataSetChanged();

        // OkHttp3.0的使用方式
//        LogUtil.log("============111111=============");
//        OkHttpClient client = new OkHttpClient.Builder()
////                .addInterceptor(new Interceptor() {
////                    @Override
////                    public Response intercept(Chain chain) throws IOException {
////                        Request oldRequest = chain.request();
////
//////                        // 添加新的参数
//////                        HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
//////                                .newBuilder()
//////                                .scheme(oldRequest.url().scheme())
//////                                .host(oldRequest.url().host())
//////                                .addQueryParameter("page", "1")
//////                                .addQueryParameter("pagesize", "10");
//////
//////                        // 新的请求
//////                        Request newRequest = oldRequest.newBuilder()
//////                                .method(oldRequest.method(), oldRequest.body())
//////                                .url(authorizedUrlBuilder.build())
//////                                .build();
////
//////                        return chain.proceed(newRequest);
////
////                        return chain.request();
////                    }
////                })
////                .addInterceptor(new Interceptor() {
////                    @Override
////                    public Response intercept(Chain chain) throws IOException {
////                        return null;
////                    }
////                })
//                .build();
//        LogUtil.log("===========22222222==============");
//
//        // 适配器
//        Retrofit marvelApiAdapter = new Retrofit.Builder()
//                .baseUrl(Config.api.API_HOST)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .client(client)
//                .build();
//        LogUtil.log("============3333333=============");
//
//        // 服务
//        APIService apiService = marvelApiAdapter.create(APIService.class);
//        LogUtil.log("============444444=============");
//
//        Observable<retrofit2.Response<List<F1Model>>> observable = apiService.getGokeList();
//        LogUtil.log("============555555=============");
//
//        mCompositeSubscription.add(observable.subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Action1<retrofit2.Response<List<F1Model>>>() {
//                            @Override
//                            public void call(retrofit2.Response<List<F1Model>> listResponse) {
//                                LogUtil.log("===========77777==============");
//                                if (listResponse.isSuccess()) {
//                                    list.addAll(listResponse.body());
//                                    adapter.notifyDataSetChanged();
//                                }
//                            }
//                        })
//        );
//        LogUtil.log("===========66666==============");
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        return chain.proceed(chain.request());
                    }
                }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.api.API_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        APIService apiService = retrofit.create(APIService.class);
        Call<List<F1Model>> call = apiService.getGokeList2(1, 10);
        call.enqueue(new Callback<List<F1Model>>() {
            @Override
            public void onResponse(retrofit2.Response<List<F1Model>> response) {
                LogUtil.log("========onResponse==============");
                list.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Throwable t) {
                LogUtil.log("=========onFailure=============");

            }
        });
//        // Fetch and print a list of the contributors to the library.
////        call.execute().body();
//        try{
//            for(F1Model f1 : call.execute().body())
//                LogUtil.log(f1);
////            list.addAll();
////            adapter.notifyDataSetChanged();
//        }catch (Exception exc){
//            exc.printStackTrace();
//        }


//        Call<List<F1Model>> call = apiService.getGokeList2();
//        call.enqueue(new Callback<List<F1Model>>() {
//            @Override
//            public void onResponse(retrofit2.Response<List<F1Model>> response) {
//                LogUtil.log("==========onResponse==============");
//                if (response.isSuccess()) {
//                    list.addAll(response.body());
//                adapter.notifyDataSetChanged();
//            }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                LogUtil.log("==========onFailure==============");
//
//            }
//        });
    }



}
