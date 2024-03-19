plugins {
    id("lsv.android.ui")
}

android {
    namespace = "com.muammarahlnn.lsv.ui.homenavigator"
}

dependencies {
    implementation(project(":ui:home"))
    implementation(project(":ui:discover"))
    implementation(project(":ui:schedule"))
    implementation(project(":ui:profile"))

    implementation(libs.material)
}