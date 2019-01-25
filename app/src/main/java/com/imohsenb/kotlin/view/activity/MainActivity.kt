package com.imohsenb.kotlin.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.imohsenb.kotlin.R
import com.imohsenb.kotlin.databinding.ActivityMainBinding
import com.imohsenb.kotlin.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //create data binding view
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //provide view model
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        //assign view model to viewModel data binding layout variable
        binding.viewModel = viewModel
    }
}
