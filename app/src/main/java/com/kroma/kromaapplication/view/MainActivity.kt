package com.kroma.kromaapplication.view

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProviders
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kroma.kromaapplication.R
import com.kroma.kromaapplication.model.Article
import com.kroma.kromaapplication.utils.Status
import com.kroma.kromaapplication.utils.ViewModelFactory
import com.kroma.kromaapplication.view.adapter.ApiArticleAdapter
import com.kroma.kromaapplication.viewmodel.SingleNetworkCallViewModel
import com.kroma.kromaapplication.viewmodel.api.ApiHelperImpl
import com.kroma.kromaapplication.viewmodel.api.RetrofitBuilder
import com.kroma.kromaapplication.viewmodel.local.DatabaseBuilder
import com.kroma.kromaapplication.viewmodel.local.DatabaseHelperImpl

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: SingleNetworkCallViewModel
    private lateinit var adapter: ApiArticleAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter =
            ApiArticleAdapter(
                arrayListOf()
            )
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        viewModel.getArticles().observe(this, {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { apiResults -> renderList(apiResults.results) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun renderList(artiles: List<Article>) {
        adapter.addArticles(artiles)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService),
                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
            )
        )[SingleNetworkCallViewModel::class.java]
    }
}