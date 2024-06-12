package com.example.skyafra.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.skyafra.fragment.HomeFragment2
import com.example.skyafra.fragment.HowToFragment
import com.example.skyafra.fragment.ProfileFragment
import com.example.skyafra.fragment.SettingFragment

class FragmentAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val fragmentList = listOf(
        HomeFragment2(),
        HowToFragment(),
        ProfileFragment(),
        SettingFragment()
    )

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]

}