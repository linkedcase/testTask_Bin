package ru.abelyh.bin_info.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ru.abelyh.bin_info.data.UserInformation
import ru.abelyh.bin_info.databinding.FragmentUserInfoBinding
import ru.abelyh.bin_info.view_model.UserViewModel

class FragmentUserInfo : Fragment() {

    private val viewModel: UserViewModel by activityViewModels()

    lateinit var binding: FragmentUserInfoBinding

    private lateinit var mSchemeMeaning: TextView
    private lateinit var mBrandMeaning: TextView
    private lateinit var mLengthMeaning: TextView
    private lateinit var mLuhnMeaning: TextView
    private lateinit var mTypeMeaning: TextView
    private lateinit var mPreparedMeaning: TextView
    private lateinit var mCountryMeaning: TextView
    private lateinit var mLatitudeMeaning: TextView
    private lateinit var mLongitudeMeaning: TextView
    private lateinit var mBankMeaning: TextView
    private lateinit var mBankUrl: TextView
    private lateinit var mBankPhoneNumber: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserInfoBinding.inflate(inflater)
        initViews()
        initObservers()
        return binding.root
    }

    private fun initObservers() {
        viewModel._userInfo.observe(viewLifecycleOwner) { userInfo ->
            setUserInformation(userInfo)
        }
    }

    private fun setUserInformation(userInformation: UserInformation) {
        mSchemeMeaning.text = userInformation.scheme
        Log.d("testLogs", "fragment mSchemeMeaning: ${mSchemeMeaning.text}")
        Log.d("testLogs", "fragment viewModel: ${viewModel._userInfo.value?.scheme}")
        mBrandMeaning.text = userInformation.brand
        mLengthMeaning.text = userInformation.number.length.toString()
        mLuhnMeaning.text = if (userInformation.number.luhn) "YES" else "NO"
        mTypeMeaning.text = userInformation.type
        mPreparedMeaning.text = if (userInformation.prepaid) "YES" else "NO"
        mCountryMeaning.text = userInformation.country.name
        mLatitudeMeaning.text = userInformation.country.latitude.toString()
        mLongitudeMeaning.text = userInformation.country.longitude.toString()
        mBankMeaning.text = userInformation.bank.name
        mBankUrl.text = userInformation.bank.url
        mBankPhoneNumber.text = userInformation.bank.phone
    }

    private fun initViews() {
        with(binding) {
            mSchemeMeaning = fragmentUserInfoSchemeMeaning
            mBrandMeaning = fragmentUserInfoBrandMeaning
            mLengthMeaning = fragmentUserInfoLengthMeaning
            mLuhnMeaning = fragmentUserInfoLuhnMeaning
            mTypeMeaning = fragmentUserInfoTypeMeaning
            mPreparedMeaning = fragmentUserInfoPrepaidMeaning
            mCountryMeaning = fragmentUserInfoCountryMeaning
            mLatitudeMeaning = fragmentUserInfoLatitude
            mLongitudeMeaning = fragmentUserInfoLongitudeMeaning
            mBankMeaning = fragmentUserInfoBankMeaning
            mBankUrl = fragmentUserInfoBankUrl
            mBankPhoneNumber = fragmentUserInfoBankPhoneNumber
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentUserInfo()
    }
}