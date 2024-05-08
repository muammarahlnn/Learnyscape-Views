pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Learnyscape Views"
include(":app")

include(":network")
include(":datastore")
include(":data")
include(":domain")

include(":core:ui")
include(":core:navigation")
include(":core:threading")
include(":core:model")

include(":ui:login")
include(":ui:homenavigator")
include(":ui:home")
include(":ui:profile")
include(":ui:schedule")
include(":ui:discover")
include(":ui:notifications")
include(":ui:pendingrequest")
include(":ui:classnavigator")
include(":ui:changepassword")
include(":ui:camera")
