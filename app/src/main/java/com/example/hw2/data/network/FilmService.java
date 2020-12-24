package com.example.hw2.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FilmService {
    private static FilmApi filmApi;

    private FilmService(){
    }

    public static FilmApi getInstance(){
        if (filmApi == null){
            filmApi = buildRetrofit();
        }
        return filmApi;
    }

    private static FilmApi buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://ghibliapi.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(FilmApi.class);
    }
}
