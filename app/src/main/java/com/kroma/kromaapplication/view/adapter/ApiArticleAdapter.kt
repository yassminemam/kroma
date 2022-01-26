package com.kroma.kromaapplication.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kroma.kromaapplication.R
import com.kroma.kromaapplication.model.Article

class ApiArticleAdapter(private val mList: ArrayList<Article>) : RecyclerView.Adapter<ApiArticleAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val article = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.title.text = article.title
        holder.author.text = article.byline
        holder.source.text = article.source
        holder.date.text = article.published_date

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val author: TextView = itemView.findViewById(R.id.author)
        val source: TextView = itemView.findViewById(R.id.source)
        val date: TextView = itemView.findViewById(R.id.date)
    }

    fun addArticles(list: List<Article>) {
        mList.addAll(list)
    }
}