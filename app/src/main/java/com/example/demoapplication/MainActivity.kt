package com.example.demoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.demoapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel: ActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel=ViewModelProvider(this).get(ActivityViewModel::class.java)
        binding.countText.text=viewModel.Total().toString()
        binding.button.setOnClickListener {
            viewModel.updateTotal(binding.number.text.toString().toInt())
            binding.countText.text=viewModel.Total().toString()
        }
    }

}