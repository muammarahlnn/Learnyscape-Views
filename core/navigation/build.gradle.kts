plugins {
    id("lsv.android.library")
}

android {
    namespace = "com.muammarahlnn.lsv.core.navigation"
}

dependencies {
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
}