package com.muammarahlnn.lsv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import com.muammarahlnn.lsv.databinding.ActivityMainBinding
import com.muammarahlnn.lsv.ui.homenavigator.navigation.homeNavigatorFragment
import com.muammarahlnn.lsv.ui.login.screen.navigation.LOGIN_ROUTE
import com.muammarahlnn.lsv.ui.login.screen.navigation.loginFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).also { viewBinding ->
            setContentView(viewBinding.root)
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navRootContainer) as NavHostFragment
        val navController = navHostFragment.navController
        navController.graph = navController.createGraph(
            startDestination = LOGIN_ROUTE
        ) {
            loginFragment()
            homeNavigatorFragment()
        }
    }
}