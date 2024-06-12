plugins {
    id("lsv.android.ui")
    id("kotlinx-serialization")
}

android {
    namespace = "com.muammarahlnn.lsv.ui.assignmentsubmission"
}

dependencies {
    implementation(libs.material)
    implementation(libs.retrofit.core)
    implementation(libs.kotlinx.serialization.json)
}