plugins {
    id("lsv.android.library")
    kotlin("kapt")
}

android {
    namespace = "com.muammarahlnn.lsv.domain"
}

dependencies {
    implementation(project(":data"))
    implementation(project(":core:model"))
    implementation(project(":core:threading"))

    implementation(libs.hilt.android)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)

    kapt(libs.hilt.compiler)
}