package com.example.pruebatecnicaxml.presentation.postsList

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.pruebatecnicaxml.databinding.ActivityPostListBinding
import com.example.pruebatecnicaxml.presentation.commentList.CommentActivity
import com.example.pruebatecnicaxml.presentation.postsList.list.PostListAdapter
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostListBinding
    private lateinit var adapter: PostListAdapter
    private val viewModel: PostListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //inflar la vista, vincular elementos de codigo con la vista xml
        binding = ActivityPostListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapter = PostListAdapter(listOf())


        //aca se realiza el llamado a los eventos Listeners
        initListener()
        observer()

    }

    private fun initListener(){
        viewModel.getPostList()
        adapter.onItemClick = {
            val intent = Intent(this@PostListActivity, CommentActivity::class.java)
            intent.putExtra("title",it.title)
            intent.putExtra("body",it.body)
            intent.putExtra("idPost",it.idPost)
            startActivity(intent)
        }
    }

    private fun observer () {
        lifecycleScope.launchWhenStarted {
            viewModel.messageError.collect { message ->
                if (message.isNotEmpty()) {
                    Snackbar.make(
                        binding.main,
                        message,
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
        lifecycleScope.launchWhenStarted{
            viewModel.success.collect { message ->
                if (message.isNotEmpty()) {
                    adapter.updateList(message)
                }
            }
        }
    }
}
