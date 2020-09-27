package com.gamecodeschool.postsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.comments.view.*
import org.w3c.dom.Comment

class CommentsAdapter(var commentsList: List<Comment>) :
RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>(){

    override fun onCreativeViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder()
    {
        val itemView = LayoutInflater.from(parent.context)
    }
           // LayoutInflater =().inflater(R.layout.row_comment_item, parent, attachId)
   // return CommentsViewHolder(itemView)


    override fun onBlindViewHolder(holder: CommentsViewHolder, position: Int) {
        var comment = commentsList.get(position)
        holder.rowView.tvName.text = comment.name
        holder.rowView.tvCommentBody.text = comment.body
        holder.rowView.tvEmail.text = comment.email
    }

override fun getItemCount(): Int) {
        return commentsList.size
    }
    class CommentsViewHolder(val  rowView: View) : RecyclerView.ViewHolder(rowView)
}
