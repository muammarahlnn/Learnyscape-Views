package com.muammarahlnn.lsv.ui.homenavigator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.createGraph
import androidx.navigation.findNavController
import com.muammarahlnn.lsv.core.navigation.navigateToDiscover
import com.muammarahlnn.lsv.core.navigation.navigateToHome
import com.muammarahlnn.lsv.core.navigation.navigateToProfile
import com.muammarahlnn.lsv.core.navigation.navigateToSchedule
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.discover.navigation.discoverFragment
import com.muammarahlnn.lsv.ui.home.navigation.HOME_ROUTE
import com.muammarahlnn.lsv.ui.home.navigation.homeFragment
import com.muammarahlnn.lsv.ui.homenavigator.databinding.ScreenHomeNavigatorBinding
import com.muammarahlnn.lsv.ui.profile.navigation.profileFragment
import com.muammarahlnn.lsv.ui.schedule.navigation.scheduleFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeNavigatorUi, 19/03/2024 03.23
 */
@AndroidEntryPoint
internal class HomeNavigatorFragment : BaseFragment<ScreenHomeNavigatorBinding, HomeNavigatorViewModel>() {

    override val viewModel: HomeNavigatorViewModel by viewModels()

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenHomeNavigatorBinding {
        return ScreenHomeNavigatorBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
    }

    private fun setupView() {
        val navController = requireActivity().findNavController(R.id.navHost)
        navController.graph = navController.createGraph(
            startDestination = HOME_ROUTE
        ) {
            homeFragment()
            discoverFragment()
            scheduleFragment()
            profileFragment()
        }

        viewBinding.navView.also { navView ->
            navView.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigationHome -> navController.navigateToHome()
                    R.id.navigationDiscover -> navController.navigateToDiscover()
                    R.id.navigationSchedule -> navController.navigateToSchedule()
                    R.id.navigationProfile -> navController.navigateToProfile()
                }
                true
            }
        }
    }
}