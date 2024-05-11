package com.muammarahlnn.lsv.ui.profile.sheet

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.ui.ext.serializableExtra
import com.muammarahlnn.lsv.core.ui.sheet.BaseSheet
import com.muammarahlnn.lsv.core.ui.util.toFile
import com.muammarahlnn.lsv.ui.camera.CameraActivity
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
    private val onImageCaptured: (image: File) -> Unit,
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

    private val cameraLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == CameraActivity.CAMERA_RESULT) {
            val imageFile = result.data?.serializableExtra<File>(CameraActivity.EXTRA_IMAGE)
            val isBackCamera = result.data?.getBooleanExtra(CameraActivity.EXTRA_IS_BACK_CAMERA, true) as Boolean
            imageFile?.let {
                onImageCaptured(it)
                dismiss()
            }
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

        viewBinding.ivCamera.also { view ->
            view.setOnClickListener { openCamera() }
        }
    }

    private fun openGallery() {
        imagePickerLauncher.launch("image/*")
    }

    private fun openCamera() {
        cameraLauncher.launch(Intent(activity, CameraActivity::class.java))
    }
}