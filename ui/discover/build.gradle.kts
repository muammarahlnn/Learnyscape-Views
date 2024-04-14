plugins {
    id("lsv.android.ui")
}

android {
    namespace = "com.muammarahlnn.lsv.ui.discover"
}

dependencies {
    implementation(libs.material)
    implementation(libs.facebook.shimmer)
    implementation(libs.kotlinx.datetime)
}