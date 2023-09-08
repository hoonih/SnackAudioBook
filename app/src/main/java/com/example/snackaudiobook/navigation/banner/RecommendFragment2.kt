package com.example.snackaudiobook.navigation.banner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.snackaudiobook.R
import com.example.snackaudiobook.databinding.FragmentRecommend2Binding
import com.example.snackaudiobook.databinding.FragmentRecommendBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecommendFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecommendFragment2 : Fragment() {
    lateinit var binding: FragmentRecommend2Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecommend2Binding.inflate(inflater, container, false)

        return binding.root
    }
}