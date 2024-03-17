package com.muammarahlnn.lsv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import com.muammarahlnn.lsv.databinding.ActivityMainBinding
import com.muammarahlnn.lsv.ui.login.screen.LoginNavigation
import com.muammarahlnn.lsv.ui.login.screen.LoginUi
import dagger.hilt.android.AndroidEntryPoint
import com.muammarahlnn.lsv.ui.login.R as loginR

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
            startDestination = LoginNavigation.ROUTE
        ) {
            fragment<LoginUi>(LoginNavigation.ROUTE) {
                label = resources.getString(loginR.string.login)
            }
        }
    }
}