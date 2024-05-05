plugins {
    id("lsv.android.ui")
}

android {
    namespace = "com.muammarahlnn.lsv.ui.schedule"
}

dependencies {
    implementation(libs.material)
    implementation(libs.kotlinx.datetime)
}