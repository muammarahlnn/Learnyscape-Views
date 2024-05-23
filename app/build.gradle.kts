plugins {
    id("lsv.android.application")
    id("lsv.android.hilt")
}

android {
    namespace = "com.muammarahlnn.lsv"

    defaultConfig {
        applicationId = "com.muammarahlnn.lsv"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(":domain"))

    implementation(project(":core:ui"))
    implementation(project(":core:navigation"))

    implementation(project(":ui:login"))
    implementation(project(":ui:homenavigator"))
    implementation(project(":ui:notifications"))
    implementation(project(":ui:pendingrequest"))
    implementation(project(":ui:changepassword"))
    implementation(project(":ui:classnavigator"))
    implementation(project(":ui:resourcedetails"))

    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.core.splashscreen)
}