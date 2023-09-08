package com.example.snackaudiobook.navigation.banner

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class RecommendViewpagerAdapter (fragment : Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> RecommendFragment()
            else -> RecommendFragment2()
        }
    }
}