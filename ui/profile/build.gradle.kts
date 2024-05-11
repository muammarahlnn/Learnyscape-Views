plugins {
    id("lsv.android.ui")
}

android {
    namespace = "com.muammarahlnn.lsv.ui.profile"
}

dependencies {
    implementation(project(":ui:camera"))

    implementation(libs.material)
    implementation(libs.facebook.shimmer)
}