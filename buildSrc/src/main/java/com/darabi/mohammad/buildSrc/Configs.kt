package com.darabi.mohammad.buildSrc

import org.gradle.api.artifacts.dsl.DependencyHandler

object Configs {

    //Core Infos
    const val TARGET_SDK_VERSION = 30
    const val MIN_SDK_VERSION = 19
    const val ID = "com.darabi.mohammad.news"
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0.0"
    const val JVM_TARGET = "1.8"
    private const val COMPILE_SDK_VERSION = TARGET_SDK_VERSION
    private const val HILT_VERSION = "2.35"

    object Plugins {

        //Android Gradle Plugin Version
        private const val AGP_VERSION = "4.1.3"

        //Kotlin Plugin Version
        private const val KOTLIN_PLUGIN_VERSION = "1.4.32"

        const val ANDROID_GRADLE_PLUGIN = "com.android.tools.build:gradle:${AGP_VERSION}"
        const val KOTLIN_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${KOTLIN_PLUGIN_VERSION}"
        const val HILT_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:$HILT_VERSION"
    }

    object BuildTypes {
        const val DEBUG = "debug"
        const val RELEASE = "release"
    }

    object Dependencies {

        private const val IMPLEMENTATION = "implementation"
        private const val KAPT = "kapt"

        private const val CORE_VERSION = "1.5.0"
        private const val APPCOMPAT_VERSION = "1.3.0"
        private const val ACTIVITY_VERSION = "1.2.3"
        private const val COROUTINES_VERSION = "1.4.2"
        private const val RECYCLER_VIEW_VERSION = "1.2.1"
        private const val CONSTRAINT_VERSION = "2.0.4"
        private const val VIEW_PAGER2_VERSION = "1.0.0"
        private const val NAVIGATION_VERSION = "2.3.5"
        private const val MATERIAL_VERSION = "1.3.0"
        private const val LIFECYCLE_VERSION = "2.2.0"
        private const val RETROFIT_VERSION = "2.7.0"
        private const val ROOM_VERSION = "2.2.4"
        private const val GSON_CONVERTER_VERSION = "2.3.0"
        private const val LOGGING_INTERCEPTOR_VERSION = "4.2.2"
        private const val GSON_VERSION = "2.8.6"
        private const val GLIDE_VERSION = "4.11.0"

        private val libs = listOf (

            // core libs
            "androidx.core:core-ktx:${CORE_VERSION}",
            "androidx.appcompat:appcompat:${APPCOMPAT_VERSION}",
            "androidx.activity:activity-ktx:${ACTIVITY_VERSION}",
            "androidx.fragment:fragment-ktx:${APPCOMPAT_VERSION}",
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${COROUTINES_VERSION}",
            "com.google.dagger:hilt-android:$HILT_VERSION",

            // design libs
            "androidx.constraintlayout:constraintlayout:${CONSTRAINT_VERSION}",
            "com.google.android.material:material:${MATERIAL_VERSION}",
            "androidx.recyclerview:recyclerview:${RECYCLER_VIEW_VERSION}",
            "androidx.viewpager2:viewpager2:${VIEW_PAGER2_VERSION}",

            // lifeccyle libs
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${LIFECYCLE_VERSION}",
            "androidx.lifecycle:lifecycle-extensions:${LIFECYCLE_VERSION}",
            "androidx.lifecycle:lifecycle-livedata-ktx:${LIFECYCLE_VERSION}",

            // navigation
            "androidx.navigation:navigation-dynamic-features-fragment:${NAVIGATION_VERSION}",
            "androidx.navigation:navigation-fragment-ktx:${NAVIGATION_VERSION}",
            "androidx.navigation:navigation-ui-ktx:${NAVIGATION_VERSION}",

            // network
            "com.squareup.retrofit2:retrofit:${RETROFIT_VERSION}",
            "com.squareup.okhttp3:logging-interceptor:${LOGGING_INTERCEPTOR_VERSION}",
            "com.squareup.retrofit2:converter-gson:${GSON_CONVERTER_VERSION}",
            "com.google.code.gson:gson:${GSON_VERSION}",

            // cache
            "androidx.room:room-runtime:${ROOM_VERSION}",
            "androidx.room:room-ktx:${ROOM_VERSION}",

            // glide
            "com.github.bumptech.glide:glide:${GLIDE_VERSION}"
        )

        private val proccessors = listOf (

            // hilt
            "com.google.dagger:hilt-android-compiler:$HILT_VERSION",

            // cache
            "androidx.room:room-compiler:${ROOM_VERSION}",

            // glide
            "com.github.bumptech.glide:compiler:${GLIDE_VERSION}"
        )

        fun DependencyHandler.dependencies() {
            libs.forEach { dependecy ->
                add(IMPLEMENTATION, dependecy)
            }
            proccessors.forEach { proccessor ->
                add(KAPT, proccessor)
            }
        }
    }
}