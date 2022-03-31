package com.rku.attendencetakingapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {
    private static final String url="http://attendancemanagementsystem.epizy.com/api/";
     static Controller controller;

    private static Retrofit retrofit;
    Controller()
    {
        retrofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized Controller getInstance()
    {
        if(controller==null)
        {
            controller=new Controller();
        }
        return controller;

    }

    APISet getAPI()
    {

        return retrofit.create(APISet.class);
    }

}
