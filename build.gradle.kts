// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(com.darabi.mohammad.buildSrc.Configs.Plugins.ANDROID_GRADLE_PLUGIN)
        classpath(com.darabi.mohammad.buildSrc.Configs.Plugins.KOTLIN_PLUGIN)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {

    repositories {
        google()
        mavenCentral()
    }
}