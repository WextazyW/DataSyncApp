package com.example.currencyrate.screens.root

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.currencyrate.R
import com.example.currencyrate.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class RootFragment : Fragment() {

    private var ctx : Context ?= null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_root, container, false)
        view.findViewById<TabLayout>(R.id.tab_layout).tabIconTint = null
        view.findViewById<ViewPager2>(R.id.viewPager).adapter = ViewPagerAdapter(ctx as FragmentActivity)
        TabLayoutMediator(view.findViewById<TabLayout>(R.id.tab_layout), view.findViewById<ViewPager2>(R.id.viewPager)){
            tab, pos ->
            when(pos){
                0 -> {
                    tab.setIcon(R.drawable.baseline_attach_money_24)
                }
                1 -> {
                    tab.setIcon(R.drawable.baseline_monetization_on_24)
                }
            }
        }.attach()
        return view
    }


}