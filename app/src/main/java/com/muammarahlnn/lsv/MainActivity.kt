package com.muammarahlnn.lsv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import com.muammarahlnn.lsv.core.navigation.HOME_NAVIGATOR_ROUTE
import com.muammarahlnn.lsv.core.navigation.LOGIN_ROUTE
import com.muammarahlnn.lsv.databinding.ActivityMainBinding
import com.muammarahlnn.lsv.domain.login.IsUserLoggedInUseCase
import com.muammarahlnn.lsv.ui.changepassword.navigation.changePasswordFragment
import com.muammarahlnn.lsv.ui.homenavigator.navigation.homeNavigatorFragment
import com.muammarahlnn.lsv.ui.login.screen.navigation.loginFragment
import com.muammarahlnn.lsv.ui.pendingrequest.navigation.pendingRequestFragment
import com.muammarahlnn.ui.lsv.notifications.navigation.notificationsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.muammarahlnn.lsv.core.navigation.R as navigationR

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var isUserLoggedInUseCase: IsUserLoggedInUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).also { viewBinding ->
            setContentView(viewBinding.root)
        }

        val startDestination = if (isUserLoggedInUseCase.execute()) {
            HOME_NAVIGATOR_ROUTE
        } else {
            LOGIN_ROUTE
        }
        createNavControllerGraph(startDestination)
    }

    private fun createNavControllerGraph(startDestination: String) {
        val navHostFragment = supportFragmentManager.findFragmentById(navigationR.id.nav_root) as NavHostFragment
        val navController = navHostFragment.navController
        navController.graph = navController.createGraph(
            startDestination = startDestination
        ) {
            loginFragment()
            homeNavigatorFragment()
            notificationsFragment()
            pendingRequestFragment()
            changePasswordFragment()
        }
    }
}