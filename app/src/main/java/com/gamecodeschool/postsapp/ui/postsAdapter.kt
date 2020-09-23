package com.gamecodeschool.postsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gamecodeschool.postsapp.Repository.Posts

class postsAdapter (var postsList: List<Posts>) :
    RecyclerView.Adapter<postsAdapter.PostsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.row_post_item, parent, false)
        return PostsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.rowView.tvPostName.text = postsList[position]

    }

    class CoursesViewHolder(val rowView: View) : RecyclerView.ViewHolder(rowView)
}
