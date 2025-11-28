package com.example.pruebatecnicaxml.presentation.commentList.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatecnicaxml.data.database.comments.Comments
import com.example.pruebatecnicaxml.databinding.ItemcommentsBinding

class CommentListAdapter(
    private var commentList: List<Comments>
): RecyclerView.Adapter<CommentListAdapter.ViewHolder>()  {

    class ViewHolder(val binding: ItemcommentsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemcommentsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val comments = commentList[position]
        holder.binding.txtComment.text = comments.comment
    }

    override fun getItemCount() = commentList.size

    fun updateCommentList(newComments:List<Comments>){
        commentList = listOf()
        commentList = newComments
        notifyDataSetChanged()
    }



}