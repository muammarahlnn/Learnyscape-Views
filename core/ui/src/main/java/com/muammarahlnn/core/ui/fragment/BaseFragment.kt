@file:Suppress("UNCHECKED_CAST")

package com.muammarahlnn.core.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.muammarahlnn.core.ui.renderer.RendererInitializer
import com.muammarahlnn.core.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File BaseFragment, 08/03/2024 22.24
 */
abstract class BaseFragment<VB: ViewBinding, R, E, VM: BaseViewModel<*, E>> : Fragment() {

    @Inject
    internal lateinit var rendererInitializer: RendererInitializer<R, VM>

    @Inject
    protected lateinit var thread: Thread

    protected abstract val viewModel: VM

    private var _viewBinding: VB? = null

    protected val viewBinding: VB
        get() =_viewBinding!!

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
        initRenderer()
        observeEvent()

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                onViewLoaded(savedInstanceState)
            }
        }
    }

    private fun initRenderer() {
        rendererInitializer.init(
            renderer = this as R,
            viewModel = viewModel,
        )
    }

    private fun observeEvent() {
        viewModel.eventFlow
            .flowWithLifecycle(
                lifecycle = lifecycle,
                minActiveState = Lifecycle.State.RESUMED,
            )
            .onEach(::action)
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    abstract suspend fun onViewLoaded(savedInstanceState: Bundle?)

    abstract suspend fun action(event: E)

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