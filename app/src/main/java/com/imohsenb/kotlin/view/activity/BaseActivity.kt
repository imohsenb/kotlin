package com.imohsenb.kotlin.view.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.imohsenb.kotlin.BR
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<VB : ViewDataBinding, VM : ViewModel>(private val viewModelClass: Class<VM>) :
    DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: VB
    private lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //create data binding view
        binding = DataBindingUtil.setContentView(this, getResLayout())
        //provide view model
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
        //assign view model to viewModel data binding layout variable
        binding.setVariable(BR.viewModel, viewModel)
        //execute binding changes
        binding.executePendingBindings()
    }

    /**
     * Get Activity layout resource for creating content view.
     */
    @LayoutRes
    abstract fun getResLayout(): Int
}