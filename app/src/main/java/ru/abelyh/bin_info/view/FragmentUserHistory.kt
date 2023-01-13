package ru.abelyh.bin_info.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import ru.abelyh.bin_info.databinding.FragmentUserHistoryBinding
import ru.abelyh.bin_info.view.adapter.HistoryListAdapter
import ru.abelyh.bin_info.view_model.UserViewModel

class FragmentUserHistory : Fragment() {

    private val viewModel: UserViewModel by activityViewModels()

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HistoryListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentUserHistoryBinding.inflate(inflater, container, false)
        val data = viewModel.binNumber

        recyclerView = binding.userHistoryRecycler
        adapter = HistoryListAdapter(data)
        recyclerView.adapter = adapter

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentUserHistory()
    }
}