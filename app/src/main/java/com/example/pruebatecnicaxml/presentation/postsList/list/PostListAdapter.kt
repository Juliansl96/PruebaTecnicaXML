package com.example.pruebatecnicaxml.presentation.postsList.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatecnicaxml.data.database.local.posts.Posts
import com.example.pruebatecnicaxml.databinding.ItempostsBinding

class PostListAdapter(
    private var postList: List<Posts>
    ): RecyclerView.Adapter<PostListAdapter.ViewHolder>() {

    var onItemClick: ((Posts)-> Unit)? = null

    class ViewHolder(val binding: ItempostsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): ViewHolder {

        val binding = ItempostsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val post = postList[position]
        holder.binding.txtTitlePost.text = post.title
        holder.binding.txtBodyPost.text = post.body
        holder.binding.txtID.text = post.idPost.toString()

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(post)
        }
    }

    override fun getItemCount() = postList.size

    fun update(newPosts:List<Posts>){
        postList = newPosts
        notifyDataSetChanged()
    }
}