package com.example.snackaudiobook.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.snackaudiobook.R
import com.example.snackaudiobook.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FragmentPageAdapter
    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        adapter = FragmentPageAdapter(supportFragmentManager, lifecycle)
        viewPager2 = findViewById(R.id.fl_con)

        viewPager2.adapter = adapter

        var bnv_main = findViewById(R.id.bnv_main) as BottomNavigationView

        viewPager2.isUserInputEnabled = false
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bnvMain.menu.getItem(position).isChecked = true
            }
        })

        bnv_main.run {
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_main_home -> { // 다른 프래그먼트 화면으로 이동하는 기능
                        viewPager2.currentItem = 0
                        /*val BlankFragment1 = HomeFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_con, BlankFragment1).commit()*/
                    }
                    R.id.menu_main_search -> { // 다른 프래그먼트 화면으로 이동하는 기능
                        viewPager2.currentItem = 1
                        /*val BlankFragment1 = SearchFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_con, BlankFragment1).commit()*/
                    }
                    R.id.menu_main_store -> { // 다른 프래그먼트 화면으로 이동하는 기능
                        viewPager2.currentItem = 2
//                        val storeFragment = adapter.getFragment(2) as StoreFragment
//                        storeFragment.refreshAdapter()

                        /*val BlankFragment1 = InfoFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_con, BlankFragment1).commit()*/
                    }
                    R.id.menu_main_info -> { // 다른 프래그먼트 화면으로 이동하는 기능
                        viewPager2.currentItem = 3
                        /*val BlankFragment1 = InfoFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_con, BlankFragment1).commit()*/
                    }
                }
                true
            }
            selectedItemId = R.id.menu_main_home
        }
    }
}