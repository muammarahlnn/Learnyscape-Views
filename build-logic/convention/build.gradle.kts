import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.muammarahlnn.learnyscape.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "learnyscape.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidLibrary") {
            id = "learnyscape.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidUi") {
            id = "learnyscape.android.ui"
            implementationClass = "AndroidUiConventionPlugin"
        }

        register("androidTest") {
            id = "learnyscape.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }

        register("androidHilt") {
            id = "learnyscape.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("androidRoom") {
            id = "learnyscape.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }

        register("jvmLibrary") {
            id = "learnyscape.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}