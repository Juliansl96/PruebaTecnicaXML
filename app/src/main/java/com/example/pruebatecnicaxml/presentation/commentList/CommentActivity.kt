package com.example.pruebatecnicaxml.presentation.commentList

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.pruebatecnicaxml.databinding.ActivityCommentListBinding

import com.example.pruebatecnicaxml.databinding.ActivityPostListBinding
import com.example.pruebatecnicaxml.presentation.commentList.list.CommentListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.getValue

class CommentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommentListBinding
    private lateinit var adapter: CommentListAdapter
    private val viewModel: CommentViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCommentListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}