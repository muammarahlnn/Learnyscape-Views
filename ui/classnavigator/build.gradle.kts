plugins {
    id("lsv.android.ui")
}

android {
    namespace = "com.muammarahlnn.lsv.ui.classnavigator"
}

dependencies {
    implementation(project(":ui:classfeed"))
    implementation(project(":ui:classoverview"))
    implementation(project(":ui:classmember"))
    implementation(libs.material)
}