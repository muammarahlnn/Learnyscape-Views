plugins {
    id("lsv.android.library")
    id("lsv.android.hilt")
}

android {
    namespace = "com.muammarahlnn.lsv.core.threading"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}
