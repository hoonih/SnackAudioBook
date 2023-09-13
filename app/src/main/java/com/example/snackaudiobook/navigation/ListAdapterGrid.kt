package com.example.snackaudiobook.navigation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.snackaudiobook.R

class ListAdapterGrid(var context: Context, var list:ArrayList<Book>):
    RecyclerView.Adapter<ListAdapterGrid.ItemHolder>() {
    fun updateData(newDataList: ArrayList<Book>) {
        list = newDataList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.list_grid_item, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val storelist:Book = list.get(position)
        if (storelist.name == "어린왕자") {
            holder.bookpage.setImageResource(R.drawable.book1)
            holder.bookback.setBackgroundResource(R.drawable.bg_image0)

        } else if (storelist.name == "달러구트 꿈 백화점") {
            holder.bookpage.setImageResource(R.drawable.book2)
            holder.bookback.setBackgroundResource(R.drawable.bg_image1)

        } else if (storelist.name == "불편한 편의점") {
            holder.bookpage.setImageResource(R.drawable.book3)
            holder.bookback.setBackgroundResource(R.drawable.bg_image2)

        } else if (storelist.name == "아몬드") {
            holder.bookpage.setImageResource(R.drawable.book4)
            holder.bookback.setBackgroundResource(R.drawable.bg_image3)

        } else if (storelist.name == "해리 포터와 마법사의 돌") {
            holder.bookpage.setImageResource(R.drawable.book5)
            holder.bookback.setBackgroundResource(R.drawable.bg_image4)

        } else if (storelist.name == "파친코") {
            holder.bookpage.setImageResource(R.drawable.book6)
            holder.bookback.setBackgroundResource(R.drawable.bg_image5)
        }
        holder.bookname.text = storelist.name
        holder.bookauthor.text = storelist.author
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bookpage = itemView.findViewById<ImageView>(R.id.img)
        val bookname= itemView.findViewById<TextView>(R.id.bookname)
        val bookauthor= itemView.findViewById<TextView>(R.id.bookauthor)
        val bookback= itemView.findViewById<ConstraintLayout>(R.id.layoutlistItem)

    }


}