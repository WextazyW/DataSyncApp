package com.example.DataSyncApp

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.DataSyncApp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    private var mBinding: ActivityMainBinding?= null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        MAIN = this
        navController = Navigation.findNavController(this, R.id.nav_host)
        window.statusBarColor = getColor(R.color.black)
        window.navigationBarColor = getColor(R.color.black)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }
}