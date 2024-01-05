import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.compose)
    id("com.vanniktech.maven.publish") version "0.26.0"
}

kotlin {
    applyDefaultHierarchyTemplate()
    js(IR) {
        browser()
    }
//    wasmJs {
//        binaries.executable()
//        browser()
//    }
    jvm("desktop")
    androidTarget {
        publishLibraryVariants("release")
        publishLibraryVariantsGroupedByFlavor = true
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.ui)
            implementation(compose.foundation)
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }

    //https://kotlinlang.org/docs/native-objc-interop.html#export-of-kdoc-comments-to-generated-objective-c-headers
    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        compilations["main"].compilerOptions.options.freeCompilerArgs.add("-Xexport-kdoc")
    }
}

android {
    namespace = "io.github.the3moly.composemask"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

mavenPublishing {
    //publishToMavenCentral(SonatypeHost.DEFAULT)
    // or when publishing to https://s01.oss.sonatype.org
    publishToMavenCentral(SonatypeHost.S01)

    signAllPublications()

//    coordinates("io.github.3moly", "compose-input-mask", "0.1.2")
//
//    pom {
//        name.set("compose-input-mask")
//        description.set("kmp library for jetpack compose")
//        inceptionYear.set("2024")
//        url.set("https://github.com/3moly/compose-input-mask")
//        licenses {
//            license {
//                name.set("MIT")
//                url.set("https://opensource.org/licenses/MIT")
//                //distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
//            }
//        }
//        developers {
//            developer {
//                id.set("3moly")
//                name.set("3moly")
//                url.set("3molydev@gmail.com")
//            }
//        }
//        scm {
//            url.set("https://github.com/3moly/compose-input-mask")
//            connection.set("scm:git:git://github.com/3moly/compose-input-mask")
//            developerConnection.set("scm:git:ssh://git@github.com/3moly/compose-input-mask")
//        }
//    }
}