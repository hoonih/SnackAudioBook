package com.example.snackaudiobook.navigation

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.snackaudiobook.R
import com.example.snackaudiobook.databinding.ActivityViewpageBinding
import com.google.firebase.firestore.FirebaseFirestore

class ViewpageActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityViewpageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val db = FirebaseFirestore.getInstance()
        val collectionRef = db.collection("store")
        val testDocRef = collectionRef.document("test")

        var buttonactive = false

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
            testDocRef.get()
                .addOnSuccessListener { documentSnapshot ->
                    if (documentSnapshot.exists()) {
                        val data = documentSnapshot.data
                        if (data != null) {
                            // index와 일치하는 필드를 찾고 해당 필드의 값이 true인지 확인
                            val fieldName = "$index"  // 필드 이름 예: "field_42"
                            val fieldValue = data[fieldName] as Boolean?

                            if (fieldValue == true) {
                                buttonactive = true
                                binding.btnStore.setTextColor(Color.parseColor("#FFC700"))
                                binding.btnStore.text = "보관됨"
                                binding.btnStore.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_storemiri, 0, 0, 0)
                            }
                        }
                    } else {
                        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                    }
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(this, "$exception", Toast.LENGTH_SHORT).show()
                }

        binding.btnStore.setOnClickListener {
            if (buttonactive == false)
            {
                val fieldName = "$index"  // 필드 이름 예: "0"
                val updatedData = hashMapOf(fieldName to true as Any)
                testDocRef.update(updatedData)
                binding.btnStore.setTextColor(Color.parseColor("#FFC700"))
                binding.btnStore.text = "보관됨"
                binding.btnStore.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_storemiri, 0, 0, 0)
            }
            else
            {
                val fieldName = "$index"  // 필드 이름 예: "0"
                val updatedData = hashMapOf(fieldName to false as Any)
                testDocRef.update(updatedData)
                binding.btnStore.setTextColor(Color.parseColor("#FFFFFF"))
                binding.btnStore.text = "보관"
                binding.btnStore.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_store2, 0, 0, 0)

            }

        }




    }
}
