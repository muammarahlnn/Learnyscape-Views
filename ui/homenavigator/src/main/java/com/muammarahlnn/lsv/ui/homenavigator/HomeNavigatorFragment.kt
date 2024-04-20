package com.muammarahlnn.lsv.ui.homenavigator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.view.WindowCompat
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.createGraph
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import com.muammarahlnn.lsv.core.navigation.DISCOVER_ROUTE
import com.muammarahlnn.lsv.core.navigation.HOME_ROUTE
import com.muammarahlnn.lsv.core.navigation.PROFILE_ROUTE
import com.muammarahlnn.lsv.core.navigation.SCHEDULE_ROUTE
import com.muammarahlnn.lsv.core.navigation.navigateToDiscover
import com.muammarahlnn.lsv.core.navigation.navigateToHome
import com.muammarahlnn.lsv.core.navigation.navigateToProfile
import com.muammarahlnn.lsv.core.navigation.navigateToSchedule
import com.muammarahlnn.lsv.core.ui.ext.readColor
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.discover.navigation.discoverFragment
import com.muammarahlnn.lsv.ui.home.navigation.homeFragment
import com.muammarahlnn.lsv.ui.homenavigator.databinding.ScreenHomeNavigatorBinding
import com.muammarahlnn.lsv.ui.profile.navigation.profileFragment
import com.muammarahlnn.lsv.ui.schedule.navigation.scheduleFragment
import dagger.hilt.android.AndroidEntryPoint
import com.muammarahlnn.lsv.core.ui.R as uiR

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeNavigatorUi, 19/03/2024 03.23
 */
@AndroidEntryPoint
internal class HomeNavigatorFragment : BaseFragment<ScreenHomeNavigatorBinding, HomeNavigatorViewModel, HomeNavigatorState>() {

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

    override fun renderState(state: HomeNavigatorState) {}

    private fun setupView() {
        setStatusBarColorToRed()

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
                    R.id.navigationHome ->
                        navController.navigateToHome(buildHomeNavigatorNavOptions(HOME_ROUTE))

                    R.id.navigationDiscover ->
                        navController.navigateToDiscover(buildHomeNavigatorNavOptions(DISCOVER_ROUTE))

                    R.id.navigationSchedule ->
                        navController.navigateToSchedule(buildHomeNavigatorNavOptions(SCHEDULE_ROUTE))

                    R.id.navigationProfile ->
                        navController.navigateToProfile(buildHomeNavigatorNavOptions(PROFILE_ROUTE))
                }
                true
            }
        }

        // set the selected nav view item when back pressed because it's not automatically updated
        requireActivity().onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navController.navigateUp()
                viewBinding.navView.selectedItemId = when (navController.currentDestination?.route) {
                    HOME_ROUTE -> R.id.navigationHome
                    DISCOVER_ROUTE -> R.id.navigationDiscover
                    SCHEDULE_ROUTE -> R.id.navigationSchedule
                    PROFILE_ROUTE -> R.id.navigationProfile
                    else -> R.id.navigationHome
                }
            }
        })
    }

    private fun buildHomeNavigatorNavOptions(popUpToRoute: String): NavOptions = navOptions {
        popUpTo(popUpToRoute)
        launchSingleTop = true
        restoreState = true
    }

    private fun setStatusBarColorToRed() {
        requireActivity().window.apply {
            statusBarColor = readColor(uiR.color.red)

            // set to dark status bar
            WindowCompat.getInsetsController(this, decorView).apply {
                isAppearanceLightStatusBars = false
                navigationBarColor = readColor(uiR.color.black)
            }
        }
    }
}