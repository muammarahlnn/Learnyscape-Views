package com.muammarahlnn.lsv.core.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

/**
 * @Author Muammar Ahlan Abimanyu
 * @File BaseFragment, 17/03/2024 01.22
 */
abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel<S>, S> : Fragment() {

    protected abstract val viewModel: VM

    protected val navController: NavController
        get() = findNavController()

    private var _viewBinding: VB? = null

    protected val viewBinding: VB
        get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = createView(inflater, container)
        return _viewBinding?.root
    }

    abstract fun createView(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                onViewLoaded(savedInstanceState)
                viewModel.state.collect { renderState(it) }
            }
        }
    }

    abstract suspend fun onViewLoaded(savedInstanceState: Bundle?)

    abstract fun renderState(state: S)

    protected fun navigate(direction: NavDirections) {
        findNavController().navigate(direction)
    }

    protected fun back() {
        findNavController().navigateUp()
    }

    protected fun showMessage(message: String?) {
        message ?: return
        Snackbar.make(viewBinding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        _viewBinding = null
        super.onDestroyView()
    }
}