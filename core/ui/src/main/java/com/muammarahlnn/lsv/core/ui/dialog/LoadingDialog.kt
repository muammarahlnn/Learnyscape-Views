package com.muammarahlnn.lsv.core.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.muammarahlnn.lsv.core.ui.R
import com.muammarahlnn.lsv.core.ui.ext.readDrawable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoadingDialog, 17/04/2024 22.11
 */
class LoadingDialog : DialogFragment() {

    private val key: String = javaClass.name

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext()).apply {
            background = readDrawable(R.drawable.bg_dialog)
            isCancelable = false
            setView(R.layout.dialog_loading)
        }.create()
    }

    fun show(fragmentManager: FragmentManager?) {
        fragmentManager ?: return
        show(fragmentManager, key)
    }

    fun hide() {
        dialog?.dismiss()
    }
}