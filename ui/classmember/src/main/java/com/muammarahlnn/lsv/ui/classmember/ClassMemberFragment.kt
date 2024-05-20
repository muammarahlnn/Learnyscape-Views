package com.muammarahlnn.lsv.ui.classmember

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.model.ClassMembersModel
import com.muammarahlnn.lsv.core.navigation.CLASS_ID_ARG
import com.muammarahlnn.lsv.core.ui.ext.hide
import com.muammarahlnn.lsv.core.ui.ext.show
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.classmember.adapter.ClassMemberAdapter
import com.muammarahlnn.lsv.ui.classmember.databinding.ScreenClassMemberBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMemberFragment, 12/05/2024 02.46
 */
@AndroidEntryPoint
internal class ClassMemberFragment :
    BaseFragment<ScreenClassMemberBinding, ClassMemberViewModel, ClassMemberUiState>() {

    override val viewModel: ClassMemberViewModel by viewModels()

    private val lecturerAdapter: ClassMemberAdapter by lazy {
        ClassMemberAdapter()
    }

    private val studentAdapter: ClassMemberAdapter by lazy {
        ClassMemberAdapter()
    }

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenClassMemberBinding {
        return ScreenClassMemberBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
        if (savedInstanceState == null) {
            val classId = arguments?.getString(CLASS_ID_ARG) as String
            viewModel.fetchClassMembers(classId)
        }
    }

    override fun renderState(state: ClassMemberUiState) {
        when (state) {
            is ClassMemberUiState.Loading ->
                renderLoadingState(state.loading)

            is ClassMemberUiState.Success ->
                renderSuccessState(state.classMembers)

            is ClassMemberUiState.Error ->
                showMessage(state.message)
        }
    }

    private fun setupView() {
        viewBinding.toolbar.ivBack.also { view ->
            view.setOnClickListener {
                back()
            }
        }
    }

    private fun renderLoadingState(loading: Boolean) {
        with(viewBinding) {
            if (loading) {
                shimmerLoading.root.show()
                lecturersCard.hide()
                studentsCard.hide()
            } else {
                shimmerLoading.root.hide()
                lecturersCard.show()
                studentsCard.show()
            }
        }
    }

    private fun renderSuccessState(classMembersModel: ClassMembersModel) {
        viewBinding.rvLecturers.apply {
            adapter = lecturerAdapter.apply {
                setItems(classMembersModel.lecturers)
            }
        }

        viewBinding.rvStudents.apply {
            adapter = studentAdapter.apply {
                setItems(classMembersModel.students)
            }
        }
    }
}