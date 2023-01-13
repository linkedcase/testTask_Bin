package ru.abelyh.bin_info.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.abelyh.bin_info.data.UserInformation
import ru.abelyh.bin_info.model.repository.UserInfoRepository
import ru.abelyh.bin_info.model.repository.UserInfoRepositoryImpl

class UserViewModel : ViewModel() {

    private val mUserRepository: UserInfoRepository = UserInfoRepositoryImpl()

    val _userInfo: MutableLiveData<UserInformation> by lazy {
        MutableLiveData<UserInformation>()
    }
    val binNumber: ArrayList<String> = arrayListOf()

    fun getUserInfo(binNumber: String) {
        val response = mUserRepository.getUserinfo(binNumber)
        response.enqueue(object : Callback<UserInformation> {
            override fun onResponse(
                call: Call<UserInformation>,
                response: Response<UserInformation>
            ) {
                Log.d("testLogs", "onResponse Success: ${response.body()?.bank}")
                _userInfo.value = response.body()
            }

            override fun onFailure(call: Call<UserInformation>, t: Throwable) {
                Log.d("testLogs", "onFailure: ${t?.message}")
            }
        })
    }
}