package com.example.snackaudiobook.navigation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
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
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {

    val booklist = arrayListOf<Book>()

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