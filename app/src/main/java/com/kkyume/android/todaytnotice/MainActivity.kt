package com.kkyume.android.todaytnotice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kkyume.android.todaytnotice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}