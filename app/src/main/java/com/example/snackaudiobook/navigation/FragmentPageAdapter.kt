package com.example.snackaudiobook.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPageAdapter (
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0)
            HomeFragment()
        else if (position == 1)
            SearchFragment()
        else if (position == 2)
            StoreFragment()
        else
            InfoFragment()
    }

    fun getFragment(i: Int): Any {
        return createFragment(i)
    }
}
