plugins {
    id("lsv.android.ui")
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

android {
    namespace = "com.muammarahlnn.lsv.ui.camera"
}

dependencies {
    implementation(libs.material)
    implementation(libs.androidx.camera.camera2)
    implementation(libs.androidx.camera.lifecycle)
    implementation(libs.androidx.camera.view)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.constraintlayout)
}