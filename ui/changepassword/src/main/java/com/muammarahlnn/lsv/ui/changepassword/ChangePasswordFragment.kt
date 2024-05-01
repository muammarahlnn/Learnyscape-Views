package com.muammarahlnn.lsv.ui.changepassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.google.android.material.button.MaterialButton
import com.muammarahlnn.lsv.core.ui.ext.hideSoftKeyboard
import com.muammarahlnn.lsv.core.ui.ext.readColor
import com.muammarahlnn.lsv.core.ui.ext.readText
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.changepassword.databinding.ScreenChangePasswordBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import com.muammarahlnn.lsv.core.ui.R as uiR

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChangePasswordFragment, 29/04/2024 19.44
 */
@AndroidEntryPoint
internal class ChangePasswordFragment :
    BaseFragment<ScreenChangePasswordBinding, ChangePasswordViewModel, ChangePasswordUiState>() {

    private val fieldsValue = MutableStateFlow(FieldsValue())

    override val viewModel: ChangePasswordViewModel by viewModels()

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenChangePasswordBinding = ScreenChangePasswordBinding.inflate(inflater, container, false)

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
        observeSaveButtonEnabledState()
    }

    override fun renderState(state: ChangePasswordUiState) {
        when (state) {
            ChangePasswordUiState.None -> Unit

            ChangePasswordUiState.OnConfirmNewPasswordNotSame ->
                showMessage("Confirm New Password must be same with New Password")

            ChangePasswordUiState.OnLoadingChangePassword ->
                renderButtonLoadingState()

            ChangePasswordUiState.OnSuccessChangePassword -> {
                showMessage("Your password changed successfully")
                back()
            }

            is ChangePasswordUiState.OnErrorChangePassword ->
                showMessage(state.message)

            ChangePasswordUiState.OnCompletionChangePassword ->
                renderButtonNormalState()
        }
    }

    private fun setupView() {
        with(viewBinding) {
            etOldPassword.addTextChangedListener { text ->
                fieldsValue.update {
                    it.copy(oldPassword = text.toString())
                }
            }
            etNewPassword.addTextChangedListener { text ->
                fieldsValue.update {
                    it.copy(newPassword = text.toString())
                }
            }
            etConfirmNewPassword.addTextChangedListener { text ->
                fieldsValue.update {
                    it.copy(confirmNewPassword = text.toString())
                }
            }

            toolbar.icBack.setOnClickListener {
                back()
            }

            btnSave.setOnClickListener {
                it.hideSoftKeyboard()
                viewModel.changePassword(
                    oldPassword = fieldsValue.value.oldPassword,
                    newPassword = fieldsValue.value.newPassword,
                    confirmNewPassword = fieldsValue.value.confirmNewPassword,
                )
            }
        }
    }

    private fun observeSaveButtonEnabledState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                fieldsValue.map {
                    it.oldPassword.isNotBlank()
                        && it.newPassword.isNotBlank()
                        && it.confirmNewPassword.isNotBlank()
                }.collect { isFieldsValid ->
                    viewBinding.btnSave.apply {
                        isEnabled = isFieldsValid
                        setBackgroundColor(
                            if (isFieldsValid) readColor(uiR.color.red)
                            else readColor(uiR.color.gray_light)
                        )
                    }
                }
            }
        }
    }

    private fun renderButtonLoadingState() {
        viewBinding.btnSave.apply {
            isEnabled = false
            icon = CircularProgressDrawable(requireContext()).apply {
                setStyle(CircularProgressDrawable.DEFAULT)
                setColorSchemeColors(readColor(uiR.color.white))
                start()
            }
            iconGravity = MaterialButton.ICON_GRAVITY_TEXT_START
            text = null
            setBackgroundColor(readColor(uiR.color.gray_light))
        }
    }

    private fun renderButtonNormalState() {
        viewBinding.btnSave.apply {
            isEnabled = true
            icon = null
            text = readText(R.string.save)
            setBackgroundColor(readColor(uiR.color.red))
        }
    }

    private data class FieldsValue(
        val oldPassword: String = "",
        val newPassword: String = "",
        val confirmNewPassword: String = "",
    )
}