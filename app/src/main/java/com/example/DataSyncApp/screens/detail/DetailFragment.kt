package com.example.moviesapp.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.DataSyncApp.MAIN
import com.example.DataSyncApp.R
import com.example.DataSyncApp.SaveShared
import com.example.DataSyncApp.databinding.FragmentDetailBinding
import com.example.DataSyncApp.model.reader.ReaderItem

class DetailFragment : Fragment() {

    private var mBinding : FragmentDetailBinding ?= null
    private val binding get() = mBinding!!
    private lateinit var nal : ReaderItem
    private var isFavorite = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        nal = arguments?.getSerializable("nal") as ReaderItem
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val valueBool = SaveShared.getFavorite(MAIN, nal.id.toString())
        val viewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        if (isFavorite != valueBool){
            binding.imgFavorite.setImageResource(R.drawable.baseline_favorite_24)
        } else{
            binding.imgFavorite.setImageResource(R.drawable.baseline_favorite_border_24)
        }

        binding.tvTitle.text = nal.firstName
        binding.tvDate.text = nal.lastName
        binding.tvDescription.text = nal.contactDetails.toString()

        binding.imgFavorite.setOnClickListener {
            if(isFavorite == valueBool){
                binding.imgFavorite.setImageResource(R.drawable.baseline_favorite_24)
                SaveShared.setFavorite(MAIN, nal.id.toString(), true)
                viewModel.insert(nal){}
                isFavorite = true
            } else {
                binding.imgFavorite.setImageResource(R.drawable.baseline_favorite_border_24)
                SaveShared.setFavorite(MAIN, nal.id.toString(), false)
                viewModel.delete(nal){}
                isFavorite = false
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}