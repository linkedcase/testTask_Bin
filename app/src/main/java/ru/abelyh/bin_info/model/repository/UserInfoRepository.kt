package ru.abelyh.bin_info.model.repository

import retrofit2.Call
import ru.abelyh.bin_info.data.UserInformation

interface UserInfoRepository {
    /**
     * Returns information about user
     */
    fun getUserinfo(binNumber: String): Call<UserInformation>
}