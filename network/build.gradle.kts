plugins {
    id("lsv.android.library")
    id("lsv.android.hilt")
    id("kotlinx-serialization")
}

val BASE_URL: String by project

android {
    namespace = "com.muammarahlnn.lsv.network"
    buildFeatures {
        buildConfig = true
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    defaultConfig {
        buildConfigField("String", "BASE_URL", BASE_URL)
    }
}

dependencies {
    implementation(project(":datastore"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
}
