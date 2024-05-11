package com.muammarahlnn.lsv.ui.camera

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector.DEFAULT_BACK_CAMERA
import androidx.camera.core.CameraSelector.DEFAULT_FRONT_CAMERA
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCapture.OnImageSavedCallback
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.muammarahlnn.lsv.core.ui.ext.readDrawable
import com.muammarahlnn.lsv.ui.camera.databinding.ActivityCameraBinding
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CameraActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityCameraBinding

    private val requiredPermissions = arrayOf(Manifest.permission.CAMERA)

    private var imageCapture: ImageCapture? = null

    private var cameraSelector = DEFAULT_BACK_CAMERA

    private var isTorchEnabled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCameraBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        setStatusBarColorColorToBlack()
        checkRequiredPermissions()
        setupView()
    }

    override fun onResume() {
        super.onResume()
        setupCamera()
    }

    private fun setStatusBarColorColorToBlack() {
        window.apply {
            statusBarColor = Color.BLACK

            WindowCompat.getInsetsController(this, decorView).apply {
                isAppearanceLightStatusBars = false
                navigationBarColor = Color.BLACK
            }
        }
    }

    private fun checkRequiredPermissions() {
        if (!isAllPermissionsGranted()) {
            requestPermissions()
        }
    }

    private fun isAllPermissionsGranted(): Boolean = requiredPermissions.all { permission ->
        ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            requiredPermissions,
            REQUEST_CODE_PERMISSION
        )
    }

    private fun setupView() {
        viewBinding.ivClose.also { view ->
            view.setOnClickListener { finish() }
        }

        viewBinding.ivFlash.also { view ->
            view.setOnClickListener {
                isTorchEnabled = !isTorchEnabled
                view.setImageDrawable(
                    readDrawable(
                        if (!isTorchEnabled) R.drawable.ic_flash_on
                        else R.drawable.ic_flash_off
                    )
                )
                setupCamera()
            }
        }

        viewBinding.ivCapture.also { view ->
            view.setOnClickListener { captureImage() }
        }

        viewBinding.ivSwitchCamera.also { view ->
            view.setOnClickListener {
                cameraSelector =
                    if (cameraSelector == DEFAULT_BACK_CAMERA) DEFAULT_FRONT_CAMERA
                    else DEFAULT_BACK_CAMERA
                setupCamera()
            }
        }
    }

    private fun setupCamera() {
        ProcessCameraProvider.getInstance(this).also { cameraProviderFuture ->
            cameraProviderFuture.addListener({
                imageCapture = ImageCapture.Builder().build()
                try {
                    cameraProviderFuture.get().also { cameraProvider: ProcessCameraProvider ->
                        cameraProvider.unbindAll()
                        cameraProvider.bindToLifecycle(
                            this,
                            cameraSelector,
                            Preview.Builder().build().apply {
                                setSurfaceProvider(viewBinding.cameraPreview.surfaceProvider)
                            },
                            imageCapture
                        ).apply {
                            cameraControl.enableTorch(isTorchEnabled)
                        }
                    }
                } catch (e: Exception) {
                    Toast.makeText(this, "Failed to show camera", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }, ContextCompat.getMainExecutor(this))
        }
    }



    private fun captureImage() {
        val imageCapture = imageCapture ?: return
        val imageFile = createImageFile()
        val outputOptions = ImageCapture.OutputFileOptions.Builder(imageFile).build()
        val imageSavedCallback = object : OnImageSavedCallback {
            override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                val intent = Intent()
                    .putExtra(EXTRA_IMAGE, imageFile)
                    .putExtra(EXTRA_IS_BACK_CAMERA, cameraSelector == DEFAULT_BACK_CAMERA)
                setResult(CAMERA_RESULT, intent)
                finish()
            }

            override fun onError(exception: ImageCaptureException) {
                Toast.makeText(
                    this@CameraActivity ,
                    "Failed to take a picture",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        imageCapture.takePicture(
            outputOptions,
            ContextCompat.getMainExecutor(this),
            imageSavedCallback
        )
    }

    private fun createImageFile(): File {
        val mediaDir = externalMediaDirs.firstOrNull()?.let { dir ->
            File(dir, "Learnyscape Views")
        }
        val outputDir = if (mediaDir != null && mediaDir.exists()) mediaDir else filesDir
        return File(outputDir, createImageFileName())
    }

    private fun createImageFileName(): String {
        val dateFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
        return "${LocalDateTime.now().format(dateFormatter)}.jpg"
    }

    companion object {

        const val EXTRA_IMAGE = "extra_image"

        const val EXTRA_IS_BACK_CAMERA = "is_back_camera"

        const val CAMERA_RESULT = 200

        private const val REQUEST_CODE_PERMISSION = 10
    }

}