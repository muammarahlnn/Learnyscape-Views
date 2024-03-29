plugins {
    id("lsv.android.library")
    id("lsv.android.hilt")
}

android {
    namespace = "com.muammarahlnn.lsv.datastore"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.kotlinx.coroutines.android)
}
