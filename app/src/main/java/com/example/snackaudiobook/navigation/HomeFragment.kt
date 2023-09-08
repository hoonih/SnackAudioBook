package com.example.snackaudiobook.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.snackaudiobook.R
import com.example.snackaudiobook.databinding.FragmentHomeBinding
import com.example.snackaudiobook.navigation.banner.RecommendFragment
import com.example.snackaudiobook.navigation.banner.RecommendViewpagerAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /* val myView = inflater.inflate(R.layout.fragment_home, container, false)
        // Inflate the layout for this fragment
        val binding = FragmentHomeBinding.inflate(inflater)

        val bannerAdapter = RecommendViewpagerAdapter(this)
        binding.banner.adapter = bannerAdapter
        binding.banner.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        return binding.root*/

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}