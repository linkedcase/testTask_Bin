package ru.abelyh.bin_info.model.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import ru.abelyh.bin_info.data.UserInformation

interface ApiInterface {

    @GET("{binNumber}")
    fun getUserInfo(
        @Path("binNumber") binNumber: String
    ): Call<UserInformation>


    companion object {
        private const val BASE_URL = "https://lookup.binlist.net/"

        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}