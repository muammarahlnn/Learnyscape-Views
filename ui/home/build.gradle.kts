plugins {
    id("lsv.android.ui")
}

android {
    namespace = "com.muammarahlnn.lsv.ui.home"
}

dependencies {
    implementation(libs.material)
    implementation(libs.androidx.recyclerView)
    implementation(libs.facebook.shimmer)
}