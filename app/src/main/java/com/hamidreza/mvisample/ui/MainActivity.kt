package com.hamidreza.mvisample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamidreza.mvisample.R
import com.hamidreza.mvisample.databinding.ActivityMainBinding
import com.hamidreza.mvisample.utils.ResultState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var userAdapter: UserAdapter
    private val viewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()

        observeDataState()

        viewModel.setStateEvent(MainStateEvent.getUsersEvent)
    }

    fun observeDataState(){
        viewModel.dataState.observe(this){ state ->
            when(state) {
                is ResultState.Loading -> showLoading(true)
                is ResultState.Success ->{
                    showLoading(false)
                    userAdapter.submitList(state.data)
                }
                is ResultState.Error -> {
                    showLoading(false)
                    Toast.makeText(this, "${state.msg}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun showLoading(hide:Boolean){
        binding.progressBar.isVisible = hide
    }

    fun setUpRecyclerView(){
        binding.apply {
            userAdapter = UserAdapter()
            rv.apply {
                adapter = userAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
}