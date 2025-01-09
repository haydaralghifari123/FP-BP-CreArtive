package com.example.fp_bp.client


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://172.24.200.230/rest_api_fp/index.php/"
    val url = "http://172.24.200.230/rest_api_fp/index.php/picture/"

    val instance: Api by lazy {
        val  retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        retrofit.create(Api::class.java)
    }
}