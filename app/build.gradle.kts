plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    id("com.palantir.git-version")
}

val gitVersion: groovy.lang.Closure<String> by extra

android {
    namespace = "com.heinrichreimersoftware.materialintro.demo"

    compileSdk = 29

    defaultConfig {
        applicationId = "com.heinrichreimersoftware.materialintro.demo"
        minSdk = 15
        targetSdk = 29
        versionCode = 20000
        versionName = gitVersion()
    }

    lint {
        abortOnError = false
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }

    dataBinding {
        enabled = true
    }
}

dependencies {
    implementation(project(":library"))
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("com.google.android.material:material:1.0.0")
    implementation("com.google.firebase:firebase-core:16.0.6")
    implementation("com.google.firebase:firebase-crash:16.2.1")
}
