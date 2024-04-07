plugins {
    id("lsv.android.library")
    id("lsv.android.hilt")
}

android {
    namespace = "com.muammarahlnn.lsv.data"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    implementation(project(":network"))
    implementation(project(":datastore"))
    implementation(project(":core:model"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)
}
