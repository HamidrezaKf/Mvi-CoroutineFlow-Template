package com.hamidreza.mvisample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hamidreza.mvisample.R
import com.hamidreza.mvisample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}