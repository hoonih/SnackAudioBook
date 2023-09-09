package com.example.snackaudiobook.navigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
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
        // Inflate the layout for this fragment
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        for (i in 0 until binding.grid1.childCount) {
            val imageView = binding.grid1.getChildAt(i) as ImageView
            imageView.setOnClickListener { view ->
                val itemIndex = binding.grid1.indexOfChild(view)
                val toastMessage = "아이템 순서 번호: $itemIndex"
                Toast.makeText(getActivity(), toastMessage, Toast.LENGTH_SHORT).show()

                val intent = Intent(activity, ViewpageActivity::class.java)
                intent.putExtra("book", itemIndex)
                startActivity(intent)
            }
        }

        return binding.root

    }

}