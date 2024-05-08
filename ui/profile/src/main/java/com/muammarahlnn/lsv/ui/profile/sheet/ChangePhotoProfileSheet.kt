package com.muammarahlnn.lsv.ui.profile.sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.ui.sheet.BaseSheet
import com.muammarahlnn.lsv.core.ui.util.toFile
import com.muammarahlnn.lsv.ui.profile.databinding.SheetChangePhotoProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import java.io.File

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChangePhotoProfileSheet, 07/05/2024 21.36
 */
@AndroidEntryPoint
internal class ChangePhotoProfileSheet(
    private val onImagePicked: (image: File) -> Unit,
) : BaseSheet<SheetChangePhotoProfileBinding, ChangePhotoProfileViewModel, ChangePhotoProfileState>() {

    override val fullHeight: Boolean = false

    override val viewModel: ChangePhotoProfileViewModel by viewModels()

    private val imagePickerLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            onImagePicked(it.toFile(requireContext()))
            dismiss()
        }
    }

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
        viewBinding.ivGallery.also { view ->
            view.setOnClickListener { openGallery() }
        }
    }

    private fun openGallery() {
        imagePickerLauncher.launch("image/*")
    }
}