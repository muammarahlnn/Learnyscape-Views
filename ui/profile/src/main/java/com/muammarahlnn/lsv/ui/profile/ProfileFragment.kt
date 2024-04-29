package com.muammarahlnn.lsv.ui.profile

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.model.UserModel
import com.muammarahlnn.lsv.core.navigation.getRootNavController
import com.muammarahlnn.lsv.core.navigation.navigateToChangePassword
import com.muammarahlnn.lsv.core.navigation.navigateToLogin
import com.muammarahlnn.lsv.core.ui.dialog.BaseDialog
import com.muammarahlnn.lsv.core.ui.ext.hide
import com.muammarahlnn.lsv.core.ui.ext.invisible
import com.muammarahlnn.lsv.core.ui.ext.readDrawable
import com.muammarahlnn.lsv.core.ui.ext.readText
import com.muammarahlnn.lsv.core.ui.ext.show
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.profile.databinding.ScreenProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import com.muammarahlnn.lsv.core.ui.R as uiR

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ProfileUi, 19/03/2024 02.38
 */
@AndroidEntryPoint
internal class ProfileFragment : BaseFragment<ScreenProfileBinding, ProfileViewModel, ProfileUiState>( ){

    override val viewModel: ProfileViewModel by viewModels()

    override fun createView(inflater: LayoutInflater, container: ViewGroup?): ScreenProfileBinding {
        return ScreenProfileBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
        if (savedInstanceState == null) {
            viewModel.getCurrentUser()
            viewModel.fetchProfilePic()
        }
    }

    override fun renderState(state: ProfileUiState) {
        when (state) {
            ProfileUiState.None -> Unit

            is ProfileUiState.OnGetCurrentUser ->
                renderOnGetCurrentUserState(state.user)

            ProfileUiState.OnLoadingFetchProfilePic ->
                renderOnLoadingFetchProfilePic()

            is ProfileUiState.OnSuccessFetchProfilePic ->
                renderOnFetchProfilePic(state.profilePic)

        }
    }

    private fun setupView() {
        viewBinding.btnLogout.also { button ->
            button.setOnClickListener {
                showLogoutDialog()
            }
        }

        viewBinding.btnChangePassword.also { button ->
            button.setOnClickListener {
                requireActivity().getRootNavController().navigateToChangePassword()
            }
        }
    }

    private fun renderOnGetCurrentUserState(user: UserModel) {
        with(viewBinding) {
            tvName.text = user.fullName
            tvUsername.text = user.username
        }
    }

    private fun renderOnLoadingFetchProfilePic() {
        with(viewBinding) {
            ivProfilePic.invisible()
            loadingProfilePic.root.show()
        }
    }

    private fun renderOnFetchProfilePic(profilePic: Bitmap?) {
        with(viewBinding) {
            loadingProfilePic.root.hide()

            ivProfilePic.apply {
                show()
                if (profilePic != null) setImageBitmap(profilePic)
                else setImageDrawable(readDrawable(uiR.drawable.dummy_photo_profile))
            }
        }
    }

    private fun showLogoutDialog() {
        BaseDialog(
            title = readText(R.string.log_out),
            message = readText(R.string.log_out_dialog_message),
            positiveText = readText(R.string.log_out),
            negativeText = readText(R.string.log_out_dialog_negative_text),
            onPositiveClick = { dialog ->
                viewModel.userLogout()
                requireActivity().getRootNavController().navigateToLogin()

                dialog.dismiss()
            },
            onNegativeClick = { dialog -> dialog.dismiss() }
        ).show(activity?.supportFragmentManager)
    }
}