package com.example.fp_bp.client


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val BASE_URL = "http://192.168.1.5/rest_api_fp/index.php/"

    val instance: Api by lazy {
        val  retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        retrofit.create(Api::class.java)
    }
}