package com.example.ruwa.mockservertest.service;

import android.util.Log;
import android.widget.Toast;

import com.example.ruwa.mockservertest.model.Hero;
import com.example.ruwa.mockservertest.model.ResponseDetails;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

public class TestService {

    public interface ServiceCallback<T> {
        void onResponse(T model, int statusCode);
        void onFailure(String message);
    }

    private final ApiService apiService;

    public TestService(){
        apiService = ServiceFactory.create(ApiService.class);
    }

    public void getHeroes(final ServiceCallback<List<Hero>> callback){
        apiService.getHeroes().enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                if(response.isSuccessful()){
                    callback.onResponse(response.body(), response.code());
                }else{
                    Converter<ResponseBody, Hero> converter =
                            ServiceFactory.getRetrofit().responseBodyConverter(Hero.class, new Annotation[0]);
                    try {
                        callback.onResponse(response.body(), response.code());
                    } catch (Exception e) {
                        callback.onFailure(e.getMessage());
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                callback.onFailure(t.getMessage());
                Log.d("mani1", t.getMessage().toString());
            }
        });
    }
/*    public void getHeroes(final ServiceCallback<Hero> callback) {
        apiService.getHeroes().enqueue(new Callback<Hero>() {
            @Override
            public void onResponse(Call <Hero> call,Response<Hero> response) {
                if(response.isSuccessful()){

                }
            }

            @Override
            public void onFailure(Call<Hero> call, Throwable t) {
                Log.d("mani1", t.getMessage().toString());
            }
        });
    }*/
}
