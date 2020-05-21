package com.imohsenb.kotlin.view.activity

import androidx.lifecycle.Observer
import com.imohsenb.kotlin.R
import com.imohsenb.kotlin.databinding.ActivityMainBinding
import com.imohsenb.kotlin.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(MainViewModel::class.java, R.layout.activity_main) {

    override fun onInitData(viewModel: MainViewModel) {
        super.onInitData(viewModel)
        viewModel.loadData()
        viewModel.galleryList.observe(this, Observer {
            println("Data")
        })
    }
}
