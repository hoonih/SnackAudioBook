package com.example.snackaudiobook.navigation

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
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

        holder.itemView.setOnClickListener {

            var putbook: Book = Bookstring(6)
            var itemIndex = 6
            when (storelist.name) {
                "어린왕자" -> {
                    putbook = Bookstring(0)
                    itemIndex = 0
                }
                "달러구트 꿈 백화점" -> {
                    putbook = Bookstring(1)
                    itemIndex = 1

                }
                "불편한 편의점" -> {
                    putbook = Bookstring(2)
                    itemIndex = 2

                }
                "아몬드" -> {
                    putbook = Bookstring(3)
                    itemIndex = 3

                }
                "해리 포터와 마법사의 돌" -> {
                    putbook = Bookstring(4)
                    itemIndex = 4

                }
                "파친코" -> {
                    putbook = Bookstring(5)
                    itemIndex = 5
                }
            }

            val intent = Intent(context, ViewpageActivity::class.java)

            intent.putExtra("book", putbook)
            intent.putExtra("index", itemIndex)
            context.startActivity(intent)
        }
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val bookpage = itemView.findViewById<ImageView>(R.id.img)
        val bookname= itemView.findViewById<TextView>(R.id.bookname)
        val bookauthor= itemView.findViewById<TextView>(R.id.bookauthor)
        val bookback= itemView.findViewById<ConstraintLayout>(R.id.layoutlistItem)

    }

    fun Bookstring(itemIndex: Int): Book{
        if (itemIndex == 0)
        {
            return Book("어린왕자", "생텍쥐페리", "비행기를 타고 아프리카 사막을 여행하고 있던 조종사가 비행기 고장으로 사막에 불시착을 하게 된다. 아무도 없을 것 같던 사막에서 생사를 고민하던 중 우연히 한 소년을 만나게 된다. 조종사는 이 소년과 대화하던 중 그가 다른 별에서 왔다는 것을 알게 되었다. 어린왕자는 B612라는 작은 혹성에서 살았는데 우연히 만난 장미에게 사랑을 느끼지만 장미는 어린왕자에게 상처만 줄 뿐이었다. 그때 어린왕자를 찾아온 사업가를 통해 다른 별의 이야기를 전해 듣고 더 큰 세상을 알면 장미의 행동을 이해할 수 있으리란 생각을 하며 여행을 결심한다. ", "홍예훈")

        }
        if (itemIndex == 1)
        {
            return Book("달러구트 꿈 백화점"
                ,"이미예"
                ,"취업 준비생인 페니가 달러구트 꿈 백화점에 취직하며 경험하는 다양하고 재미난 이야기. 잠들어야만 입장할 수 있는 세계를 배경으로 하며, 사건들은 그중에서도 가장 인기 있는 건물인 달러구트 꿈 백화점에서 주로 일어난다. 작중 달러구트 꿈 백화점은 도시에서 가장 멋진 건물, 즉 랜드마크와 청년들의 꿈의 직장으로써 묘사된다."
                ,"홍예훈")
        }
        if (itemIndex == 2)
        {
            return Book("불편한 편의점"
                ,"김호연"
                ,"동네 골목의 작은 편의점을 배경으로 삶의 희로애락을 따뜻하고 유머러스하게 그린 소설. 서울역에서 살다가 우연한 기회에 편의점에서 일하게 된 한 인물과 저마다의 사연을 안고 편의점을 찾는 이들의 이야기, 그 속에서 지친 하루를 위로하는 편의점의 밤이 열린다."
                ,"홍예훈")
        }
        if (itemIndex == 3)
        {
            return Book("아몬드"
                ,"손원평"
                ,"감정표현불능증(알렉시티미아)을 앓고 있는 열여섯 살 소년 선윤재. '아몬드'라 불리는 편도체가 작아 분노도 공포도 잘 느끼지 못하는 그는 타고난 침착성, 엄마와 할머니의 지극한 사랑 덕에 별 탈 없이 지냈다. 그러나 크리스마스 이브이던 열여섯 번째 생일날 벌어진 비극적인 사고로 가족을 잃는다. 그렇게 세상에 홀로 남겨진 윤재 앞에 '곤이'가 나타난다. 놀이동산에서 가정부의 손을 잠깐 놓은 사이 사라진 후 13년 만에 가족의 품으로 돌아오게 된 곤이는 분노로 가득 찬 아이다. 곤이는 모두가 두려워하는 자신을 무서워하지 않는 윤재가 마음에 들지 않는다. 윤재를 괴롭히고 윤재에게 화를 쏟아 내지만, 윤재는 곤이의 행동에 동요하지 않는다. 곤은 동요가 없는 윤재 앞에서 오히려 쩔쩔매고 만다. 그 후 두 소년은 남들이 이해할 수 없는 특별한 우정을 쌓아가기 시작한다. 그 과정에서 윤재는 조금씩 내면의 변화를 겪는데..."
                ,"홍예훈")
        }
        if (itemIndex == 4)
        {
            return Book("해리 포터와 마법사의 돌"
                ,"J.K 롤링"
                ,"친척집에서 구박받는 생활을 하던 해리는 11살 생일을 앞두고 호그와트 마법학교로부터 입학초대장을 받고 자신이 마법사라는 사실을 알게 된다. 해리는 호그와트 마법학교로 가는 열차에서 친구 론과 헤르미온느를 사귀고 함께 마법과 신비, 모험으로 가득한 학교생활을 시작한다."
                ,"홍예훈")
        }
        if (itemIndex == 5)
        {
            return Book("파친코"
                ,"이민진"
                ,"일제강점기 부산에서 살던 훈이와 양진 부부와 그들의 딸 선자에서부터 시작해 선자가 일본으로 이주해 간 후 낳은 아들과 그의 아들에 이르기까지 4대에 걸친 일가족과 주변 인물들에 대한 이야기다. 이런 재일교포들이 일본에서 겪는 멸시와 차별과 그 속의 처절한 삶을 그리고 있다."
                ,"홍예훈")
        }
        return Book("ERROR", "ERROR", "ERROR", "ERROR")
    }


}