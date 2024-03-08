plugins {
    id("learnyscape.android.library")
    id("learnyscape.android.hilt")
}

android {
    namespace = "com.muammarahlnn.learnyscape.core.ui"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    api(libs.androidx.core.ktx)
    api(libs.androidx.lifecycle.viewModel)
    api(libs.androidx.lifecycle.savedState)
    api(libs.androidx.lifecycle.runtime)
    api(libs.androidx.navigation.fragment)
    api(libs.androidx.navigation.ui)
    api(libs.kotlinx.coroutines.android)
    api(libs.kotlinx.coroutines.core)
}