package ru.abelyh.bin_info.model.repository

import retrofit2.Call
import ru.abelyh.bin_info.data.UserInformation
import ru.abelyh.bin_info.model.api.ApiInterface

class UserInfoRepositoryImpl : UserInfoRepository {

    private val apiInterface = ApiInterface.create()

    override fun getUserinfo(binNumber: String): Call<UserInformation> {
        return apiInterface.getUserInfo(binNumber)
    }
}