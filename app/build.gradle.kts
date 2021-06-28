import com.darabi.mohammad.buildSrc.Configs
import com.darabi.mohammad.buildSrc.Configs.Dependencies.dependencies

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("androidx.navigation.safeargs.kotlin")
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
        multiDexEnabled = true
    }

    buildTypes {

        getByName(Configs.BuildTypes.RELEASE) {

            isMinifyEnabled = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )

            buildConfigField("String","BASE_URL","\"https://newsapi.org/v2/\"")
            buildConfigField("String","GITHUB_LINK","\"https://github.com/DarabiMohammad\"")
            buildConfigField("String","API_KEY","\"3bc9ba4aebe54a9b8827f97c01dcef67\"")
        }

        getByName(Configs.BuildTypes.DEBUG) {

            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )

            buildConfigField("String","BASE_URL","\"https://newsapi.org/v2/\"")
            buildConfigField("String","GITHUB_LINK","\"https://github.com/DarabiMohammad\"")
            buildConfigField("String","API_KEY","\"3bc9ba4aebe54a9b8827f97c01dcef67\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = Configs.JVM_TARGET
    }

    buildFeatures {
        viewBinding = true
    }

    androidExtensions {
        isExperimental = true
    }
}

dependencies {

//    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    dependencies()
}