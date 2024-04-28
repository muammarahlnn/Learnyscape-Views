package com.muammarahlnn.lsv.ui.profile

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.model.UserModel
import com.muammarahlnn.lsv.core.navigation.getRootNavController
import com.muammarahlnn.lsv.core.navigation.navigateToLogin
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.profile.databinding.ScreenProfileBinding
import dagger.hilt.android.AndroidEntryPoint

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

            is ProfileUiState.OnFetchProfilePic ->
                renderOnFetchProfilePic(state.profilePic)
        }
    }

    private fun setupView() {
        viewBinding.btnLogout.also { button ->
            button.setOnClickListener {
                viewModel.userLogout()
                requireActivity().getRootNavController().navigateToLogin()
            }
        }
    }

    private fun renderOnGetCurrentUserState(user: UserModel) {
        with(viewBinding) {
            tvName.text = user.fullName
            tvUsername.text = user.username
        }
    }

    private fun renderOnFetchProfilePic(profilePic: Bitmap?) {
        viewBinding.ivProfilePic.also { view ->
            profilePic?.let { view.setImageBitmap(it) }
        }
    }
}