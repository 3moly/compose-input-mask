enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}
//issue: can't pass "compose-input-mask", its duplicate name for sub-module and root project
rootProject.name = "compose-input-mask-library"
include(":compose-input-mask")
include(":sample")