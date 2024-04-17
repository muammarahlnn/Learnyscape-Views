package com.muammarahlnn.lsv.core.ui.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.muammarahlnn.lsv.core.ui.R

/**
 * @Author Muammar Ahlan Abimanyu
 * @File BaseDialog, 15/04/2024 05.12
 */
class BaseDialog(
    private val title: String,
    private val message: String,
    private val positiveText: String? = null,
    private val negativeText: String? = null,
    private val onPositiveClick: (dialog: DialogInterface) -> Unit = {},
    private val onNegativeClick: (dialog: DialogInterface) -> Unit = {},
) : DialogFragment() {

    private val key = javaClass.name

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext(), R.style.DialogTheme).apply {
            setTitle(title)
            setMessage(message)

            positiveText?.let {
                setPositiveButton(it) { dialog, _ ->
                    onPositiveClick(dialog)
                }
            }

            negativeText?.let {
                setNegativeButton(it) { dialog, _ ->
                    onNegativeClick(dialog)
                }
            }
        }.create()
    }

    fun show(fragmentManager: FragmentManager?) {
        fragmentManager ?: return
        show(fragmentManager, key)
    }
}