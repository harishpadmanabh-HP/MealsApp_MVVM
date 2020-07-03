package com.hp.mealsapp_mvvm.data.network

import com.hp.mealsapp_mvvm.data.models.Categories
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface MyApi {

    @GET("categories.php")
     fun getCategories(): Call<Categories>

    companion object{
        operator fun invoke():MyApi{
            var logger  = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val client: OkHttpClient =
                OkHttpClient.Builder().addInterceptor(logger).build()

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .build()

                .create(MyApi::class.java)
        }

    }

}