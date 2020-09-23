package com.gamecodeschool.postsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.gamecodeschool.postsapp.R
import com.gamecodeschool.postsapp.model.Post

class PostsRvAdapter( var postsList: List<Post>, var postItemClickListener: PostItemClickListener)
RecyclerView.Adapter<PostsRvAdapter.PostsViewHolder>() {
    override fun onCreateVIewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        var itemview =
            LayoutInflater.from(parent.context).inflate(R.layout.row_post_, parent, attachToRo)
        return PostsViewHolder(itemview)
    }
    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        var post = postsList[position]
        holder.rowView.tvTitle.text = post.title
        holder.rowView.tvBody.text = post.body
        holder.rowView.tvUserId.text = post.userId.toString()
        holder.rowView.setOnClickListener.onItemClick()
        postItemClickListener.onItemClick()
    }
}

    override fun getItemCount(): Int {
        return postsList.size
    }
    class PostsViewHolder(val rowView: View) : RecyclerView.ViewHolder(rowView)

}