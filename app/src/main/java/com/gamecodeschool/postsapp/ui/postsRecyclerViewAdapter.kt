package com.gamecodeschool.postsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gamecodeschool.postsapp.R
import com.gamecodeschool.postsapp.Repository.Posts

class postsRecyclerViewAdapter (val namesList: List<String>) :
    RecyclerView.Adapter<PostsRecyclerViewAdapter.PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_post_item, parent, false)
        return PostsViewHolder(itemView)
    }
    override fun getItemCount(): Int {
        return namesList.size
    }
    override fun onBindViewHolder(holder: NamesViewHolder, position: Int) {
        holder.rowView.tvPost.text = namesList[position]
    }
    class NamesViewHolder(val rowView: View) : RecyclerView.ViewHolder(rowView)
}