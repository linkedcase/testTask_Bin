//package ru.abelyh.bin_info.view
//
//import android.os.Bundle
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import ru.abelyh.bin_info.R
//import ru.abelyh.bin_info.data.UserInformation
//import ru.abelyh.bin_info.view_model.UserInfoViewModel
//
//class UserInfo : AppCompatActivity() {
//
//    private val mViewModel: UserInfoViewModel = UserInfoViewModel()
//
//    private lateinit var mSchemeMeaning: TextView
//    private lateinit var mBrandMeaning: TextView
//    private lateinit var mLengthMeaning: TextView
//    private lateinit var mLuhnMeaning: TextView
//    private lateinit var mTypeMeaning: TextView
//    private lateinit var mPreparedMeaning: TextView
//    private lateinit var mCountryMeaning: TextView
//    private lateinit var mLatitudeMeaning: TextView
//    private lateinit var mLongitudeMeaning: TextView
//    private lateinit var mBankMeaning: TextView
//    private lateinit var mBankUrl: TextView
//    private lateinit var mBankPhoneNumber: TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_user_info)
//
//        val binNumber = intent.getStringExtra("binNumber")
//
//        if (binNumber != null) {
//            mViewModel.getUserInfo(binNumber)
//        }
//        initViews()
//        initObservers()
//    }
//
//    private fun initObservers() {
//        mViewModel.apply {
//            userInfo.observe(this@UserInfo) {
//                setUserInformation(it)
//            }
//        }
//    }
//
//    private fun setUserInformation(userInformation: UserInformation) {
//        mSchemeMeaning.text = userInformation.scheme
//        mBrandMeaning.text = userInformation.brand
//        mLengthMeaning.text = userInformation.number.length.toString()
//        mLuhnMeaning.text = if(userInformation.number.luhn) "YES" else "NO"
//        mTypeMeaning.text = userInformation.type
//        mPreparedMeaning.text = if(userInformation.prepaid) "YES" else "NO"
//        mCountryMeaning.text = userInformation.country.name
//        mLatitudeMeaning.text = userInformation.country.latitude.toString()
//        mLongitudeMeaning.text = userInformation.country.longitude.toString()
//        mBankMeaning.text = userInformation.bank.name
//        mBankUrl.text = userInformation.bank.url
//        mBankPhoneNumber.text = userInformation.bank.phone
//    }
//
//    private fun initViews() {
//        mSchemeMeaning = findViewById(R.id.fragment_user_info_scheme_meaning)
//        mBrandMeaning = findViewById(R.id.fragment_user_info_brand_meaning)
//        mLengthMeaning = findViewById(R.id.fragment_user_info_length_meaning)
//        mLuhnMeaning = findViewById(R.id.fragment_user_info_luhn_meaning)
//        mTypeMeaning = findViewById(R.id.fragment_user_info_type_meaning)
//        mPreparedMeaning = findViewById(R.id.fragment_user_info_prepaid_meaning)
//        mCountryMeaning = findViewById(R.id.fragment_user_info_country_meaning)
//        mLatitudeMeaning = findViewById(R.id.fragment_user_info_latitude_meaning)
//        mLongitudeMeaning = findViewById(R.id.fragment_user_info_longitude_meaning)
//        mBankMeaning = findViewById(R.id.fragment_user_info_bank_meaning)
//        mBankUrl = findViewById(R.id.fragment_user_info_bank_url)
//        mBankPhoneNumber = findViewById(R.id.fragment_user_info_bank_phone_number)
//    }
//}