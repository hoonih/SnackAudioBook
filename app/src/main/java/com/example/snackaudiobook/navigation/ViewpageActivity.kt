package com.example.snackaudiobook.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.snackaudiobook.R
import com.example.snackaudiobook.databinding.ActivityViewpageBinding

class ViewpageActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityViewpageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = intent
        val infobook = intent.getSerializableExtra("book") as Book?
        val index = intent.getIntExtra("index", 6)

        when (index) {
            0 -> binding.phBack.setImageResource(R.drawable.ph_banner_001)
            1 -> binding.phBack.setImageResource(R.drawable.ph_banner_002)
            2 -> binding.phBack.setImageResource(R.drawable.ph_banner_003)
            3 -> binding.phBack.setImageResource(R.drawable.ph_banner_004)
            4 -> binding.phBack.setImageResource(R.drawable.ph_banner_005)
            5 -> binding.phBack.setImageResource(R.drawable.ph_banner_006)
            6 -> binding.phBack.setImageResource(R.drawable.ph_errorpage)
        }
        binding.bookname.text = infobook?.name
        binding.bookauthor.text = infobook?.author
        binding.txJulcontext.text = infobook?.summary
        binding.madeby.text = "스낵 제작: ${infobook?.madeby}"

    }
}
