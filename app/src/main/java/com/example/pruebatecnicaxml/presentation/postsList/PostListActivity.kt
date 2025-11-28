package com.example.pruebatecnicaxml.presentation.postsList

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.pruebatecnicaxml.databinding.ActivityPostListBinding
import com.example.pruebatecnicaxml.domain.postslist.PostsListResult
import com.example.pruebatecnicaxml.presentation.commentList.CommentActivity
import com.example.pruebatecnicaxml.presentation.postsList.list.PostListAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostListBinding
    private lateinit var adapter: PostListAdapter
    private val viewModel: PostListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        //inflar la vista, vincular elementos de codigo con la vista xml
        binding = ActivityPostListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapter = PostListAdapter(listOf())
        binding.rvPosts.adapter = adapter

        viewModel.loadPosts()

        //aca se realiza el llamado a los eventos Listeners
        //initListener()
        observer()
        viewModel.loadPosts()
    }
    /*
    private fun initListener(){

        viewModel.loadPosts()
        adapter.onItemClick = {
            val intent = Intent(this@PostListActivity, CommentActivity::class.java)
            intent.putExtra("title",it.title)
            intent.putExtra("body",it.body)
            intent.putExtra("idPost",it.idPost)
            startActivity(intent)
        }
    }
*/
    private fun observer () {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.posts.collect { result ->
                    when (result) {
                        is PostsListResult.Loading -> Toast.makeText(
                            this@PostListActivity,
                            "Cargando",
                            Toast.LENGTH_LONG
                        ).show()

                        is PostsListResult.Success -> {
                            Toast.makeText(
                                this@PostListActivity,
                                "ejecutamos el update",
                                Toast.LENGTH_LONG
                            ).show()
                            adapter.update(result.postList)
                        }

                        is PostsListResult.MessageError ->
                            Toast.makeText(this@PostListActivity, result.message, Toast.LENGTH_LONG)
                                .show()
                    }
                }
            }
        }
    }

}
