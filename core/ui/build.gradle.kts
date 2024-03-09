plugins {
    id("lsv.android.library")
    id("lsv.android.hilt")
}

android {
    namespace = "com.muammarahlnn.lsv.core.ui"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core:threading"))

    api(libs.androidx.core.ktx)
    api(libs.androidx.lifecycle.viewModel)
    api(libs.androidx.lifecycle.savedState)
    api(libs.androidx.lifecycle.runtime)
    api(libs.androidx.navigation.fragment)
    api(libs.androidx.navigation.ui)
    api(libs.kotlinx.coroutines.android)
    api(libs.kotlinx.coroutines.core)
}