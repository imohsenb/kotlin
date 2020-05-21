package com.imohsenb.kotlin.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.imohsenb.kotlin.BR
import com.imohsenb.kotlin.viewmodel.BaseViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel>(
    private val viewModelClass: Class<VM>,
    @LayoutRes val layoutRes: Int
) :
    DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: VB
    private lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //create data binding view
        binding = DataBindingUtil.setContentView(this, layoutRes)
        //provide view model
        viewModel = ViewModelProvider(this, viewModelFactory).get(viewModelClass)
        //assign view model to viewModel data binding layout variable
        binding.setVariable(BR.viewModel, viewModel)
        //execute binding changes
        binding.executePendingBindings()

        onInitLayout(binding)
        onInitData(viewModel)
    }

    @CallSuper
    open fun onInitLayout(binding: VB) {
    }

    @CallSuper
    open fun onInitData(viewModel: VM) {
        observeBaseViewModel()
    }

    private fun observeBaseViewModel() {
        viewModel.toastMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}