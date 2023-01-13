//package ru.abelyh.bin_info.view
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import ru.abelyh.bin_info.R
//import ru.abelyh.bin_info.view.adapter.HistoryListAdapter
//import ru.abelyh.bin_info.view_model.UserViewModel
//
//class UserHistory : AppCompatActivity() {
//    private lateinit var mHistoryRecycler: RecyclerView
//    private lateinit var mHistoryAdapter: HistoryListAdapter
//    private var viewModel: UserViewModel = UserViewModel(application)
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_user_history)
//        // Init views
//        mHistoryRecycler = findViewById(R.id.user_history_recycler)
//        mHistoryRecycler.layoutManager = LinearLayoutManager(this)
//        val data = viewModel.binNumbers
//        mHistoryAdapter = HistoryListAdapter(data)
//        mHistoryRecycler.adapter = mHistoryAdapter
//    }
//}