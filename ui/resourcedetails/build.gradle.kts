plugins {
    id("lsv.android.ui")
}

android {
    namespace = "com.muammarahlnn.lsv.ui.resourcedetails"
}

dependencies {
    implementation(project(":ui:assignmentsubmission"))
    implementation(libs.material)
    implementation(libs.kotlinx.datetime)
}