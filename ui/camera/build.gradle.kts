plugins {
    id("lsv.android.ui")
}

android {
    namespace = "com.muammarahlnn.lsv.ui.camera"
}

dependencies {
    implementation(libs.material)
    implementation(libs.androidx.camera.camera2)
    implementation(libs.androidx.camera.lifecycle)
    implementation(libs.androidx.camera.view)
}