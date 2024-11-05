package com.example.moviesapp.screens.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.DataSyncApp.MAIN
import com.example.DataSyncApp.R
import com.example.DataSyncApp.databinding.FragmentFavoriteBinding
import com.example.DataSyncApp.model.reader.ReaderItem
import com.example.DataSyncApp.screens.favorite.FavoriteAdapter

class FavoriteFragment : Fragment() {

    private var mBinding : FragmentFavoriteBinding ?= null
    private val binding get() = mBinding!!
    private lateinit var recyclerView: RecyclerView
    private val adapter by lazy {
        FavoriteAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[FavoriteFragmentViewModel::class.java]
        recyclerView = binding.rvFavorite
        recyclerView.adapter = adapter
        viewModel.getAllNal().observe(viewLifecycleOwner) { list ->
            adapter.setList(list.asReversed())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

    companion object{
        fun clickMovie(model : ReaderItem){
            val bundle = Bundle()
            if (model != null){
                bundle.putSerializable("nal", model)
            }
            MAIN.navController.navigate(R.id.action_favoriteFragment_to_detailFragment, bundle)
        }
    }

}