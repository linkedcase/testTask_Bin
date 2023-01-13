package ru.abelyh.bin_info.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.abelyh.bin_info.R
import ru.abelyh.bin_info.view_model.UserViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModels()

    private lateinit var buttonGetInfo: Button
    private lateinit var buttonShowHistory: Button
    private lateinit var buttonEditTextBin: EditText
    private lateinit var buttonClearBinNumber: ImageButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGetInfo = findViewById(R.id.activity_main_button_get_info)
        buttonGetInfo.setOnClickListener {
            val inputBinNumber = buttonEditTextBin.text.toString()
            viewModel.binNumber.add(inputBinNumber)
            viewModel.getUserInfo(inputBinNumber)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_place_holder, FragmentUserInfo.newInstance())
                .commit()
        }

        buttonShowHistory = findViewById(R.id.activity_main_button_show_history)
        buttonShowHistory.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_place_holder, FragmentUserHistory.newInstance())
                .commit()
        }

        buttonEditTextBin = findViewById(R.id.activity_main_edit_text_bin)
        buttonEditTextBin.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
                buttonClearBinNumber.visibility =
                    if (p0.isNotBlank()) VISIBLE else INVISIBLE
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        buttonClearBinNumber = findViewById(R.id.activity_main_clear_bin_number)
        buttonClearBinNumber.setOnClickListener {
            toCleanEditTextBin()
        }
    }

    private fun toCleanEditTextBin() {
        buttonEditTextBin.text.clear()
    }
}