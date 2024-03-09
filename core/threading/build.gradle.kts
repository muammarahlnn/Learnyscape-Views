plugins {
    id("lsv.android.library")
    id("lsv.android.hilt")
}

android {
    namespace = "com.muammarahlnn.lsv.core.threading"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    api(libs.kotlinx.coroutines.core)
}