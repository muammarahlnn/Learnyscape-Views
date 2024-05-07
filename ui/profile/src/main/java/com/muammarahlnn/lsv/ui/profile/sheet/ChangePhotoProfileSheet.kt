package com.muammarahlnn.lsv.ui.profile.sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.ui.sheet.BaseSheet
import com.muammarahlnn.lsv.ui.profile.databinding.SheetChangePhotoProfileBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChangePhotoProfileSheet, 07/05/2024 21.36
 */
@AndroidEntryPoint
internal class ChangePhotoProfileSheet :
    BaseSheet<SheetChangePhotoProfileBinding, ChangePhotoProfileViewModel, ChangePhotoProfileState>() {

    override val fullHeight: Boolean = false

    override val viewModel: ChangePhotoProfileViewModel by viewModels()

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): SheetChangePhotoProfileBinding {
        return SheetChangePhotoProfileBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
    }

    private fun setupView() {
        viewBinding.ivCamera.also { view ->
            view.setOnClickListener {
                Toast.makeText(context, "Camera clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}