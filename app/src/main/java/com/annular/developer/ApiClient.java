package com.annular.developer;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit getRetrofit(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.111.87:8080/")
//                .baseUrl("http://3.110.165.246:8080/developerConnect-0.0.1-SNAPSHOT/")
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    public static UserService getservice(){
        UserService userService = getRetrofit().create(UserService.class);
        return userService;
    }
}
