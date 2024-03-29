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

include(":core:ui")
include(":core:navigation")

include(":ui:login")
include(":ui:homenavigator")
include(":ui:home")
include(":ui:profile")
include(":ui:schedule")
include(":ui:discover")
include(":network")
include(":datastore")
