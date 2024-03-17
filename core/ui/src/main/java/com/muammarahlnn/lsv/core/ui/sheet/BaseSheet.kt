package com.muammarahlnn.lsv.core.ui.sheet

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.muammarahlnn.lsv.core.ui.ext.screenHeight
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.launch
import com.google.android.material.R as materialR
import com.muammarahlnn.lsv.core.ui.R as uiR

/**
 * @Author Muammar Ahlan Abimanyu
 * @File BaseSheet, 17/03/2024 01.34
 */
abstract class BaseSheet<VB: ViewBinding, VM: BaseViewModel<*>> : BottomSheetDialogFragment() {

    abstract val fullHeight: Boolean

    protected abstract val viewModel: VM

    private val key: String
        get() = javaClass.name

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

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener(::adjustSheetHeight)

        return dialog
    }

    private fun adjustSheetHeight(dialog: DialogInterface) {
        val sheetLayout = (dialog as BottomSheetDialog).findViewById<FrameLayout>(materialR.id.design_bottom_sheet)
        val sheetBehavior = BottomSheetBehavior.from(sheetLayout!!)

        if (!fullHeight) {
            sheetLayout.also { layout ->
                layout.layoutParams.height = LayoutParams.WRAP_CONTENT
            }
        } else {
            sheetLayout.also { layout ->
                layout.layoutParams.height = LayoutParams.MATCH_PARENT
            }

            sheetBehavior.also { behavior ->
                behavior.peekHeight = screenHeight
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                onViewLoaded(savedInstanceState)
            }
        }
    }

    abstract suspend fun onViewLoaded(savedInstanceState: Bundle?)

    fun show(fragmentManager: FragmentManager?) {
        fragmentManager ?: return
        show(fragmentManager, key)
    }

    override fun getTheme(): Int {
        return uiR.style.BottomSheetDialogTheme
    }

    override fun onDestroy() {
        _viewBinding = null
        super.onDestroy()
    }
}