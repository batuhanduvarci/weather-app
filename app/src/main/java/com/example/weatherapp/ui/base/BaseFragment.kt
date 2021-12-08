package com.example.weatherapp.ui.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

/**
 * Created by Batuhan Duvarci on 6.12.2021.
 */
abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(layoutId: Int) : Fragment(layoutId) {

    abstract val viewModel: VM

    open var binding: VB? = null
    open var onBackPressedCallback: OnBackPressedCallback? = null

    abstract fun bind(view: View): VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = bind(view)

        initUserInterface()
        initObservers()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onBackPressedCallback?.let {
            requireActivity().onBackPressedDispatcher.addCallback(this, it)
        }
    }

    abstract fun initUserInterface()

    abstract fun initObservers()

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}