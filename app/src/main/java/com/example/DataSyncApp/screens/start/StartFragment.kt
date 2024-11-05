package com.example.DataSyncApp.screens.start

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.DataSyncApp.MAIN
import com.example.DataSyncApp.R
import com.example.DataSyncApp.databinding.FragmentStartBinding
import com.example.DataSyncApp.model.reader.ReaderItem

class StartFragment : Fragment() {

    private var mBinding: FragmentStartBinding?= null
    private val binding get() = mBinding!!
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: StartAdapter
    lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentStartBinding.inflate(layoutInflater, container, false)
        val viewModel = ViewModelProvider(this)[StartViewModel::class.java]
        viewModel.initDatabase()
        setHasOptionsMenu(true)
        recyclerView = binding.rvStart
        progressBar = binding.progressBar

        adapter = StartAdapter()
        recyclerView.adapter = adapter
        showLoading()

        if (isNetworkAvailable()) {
            viewModel.getNalMoneyRetrofit()
            viewModel.myMoneyList.observe(viewLifecycleOwner) { list ->
                hideLoading()
                if (list.isSuccessful) {
                    list.body()?.let {
                        adapter.setList(it)
                    }
                }
            }
        } else {
            showLoading()
        }
        return binding.root

    }

    private fun showLoading() {
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    private fun hideLoading() {
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.item_favorite -> {
                MAIN.navController.navigate(R.id.action_startFragment_to_favoriteFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object{
        fun clickMovie(model : ReaderItem){
            val bundle = Bundle()
            if (model != null){
                bundle.putSerializable("nal", model)
            }
            MAIN.navController.navigate(R.id.action_startFragment_to_detailFragment, bundle)
        }
    }

}