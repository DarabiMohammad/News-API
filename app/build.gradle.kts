import com.darabi.mohammad.buildSrc.Configs
import com.darabi.mohammad.buildSrc.Configs.Dependencies.dependencies

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {

    compileSdkVersion(Configs.TARGET_SDK_VERSION)

    defaultConfig {

        applicationId(Configs.ID)
        minSdkVersion(Configs.MIN_SDK_VERSION)
        targetSdkVersion(Configs.TARGET_SDK_VERSION)
        versionCode = Configs.VERSION_CODE
        versionName = Configs.VERSION_NAME

        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {

        getByName(Configs.BuildTypes.RELEASE) {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }

        getByName(Configs.BuildTypes.DEBUG) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    dependencies()
}