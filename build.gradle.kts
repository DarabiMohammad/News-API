// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {

        classpath(com.darabi.mohammad.buildSrc.Configs.Plugins.ANDROID_GRADLE_PLUGIN)
        classpath(com.darabi.mohammad.buildSrc.Configs.Plugins.KOTLIN_PLUGIN)
        classpath(com.darabi.mohammad.buildSrc.Configs.Plugins.HILT_PLUGIN)
        classpath(com.darabi.mohammad.buildSrc.Configs.Plugins.SAFE_ARGS_PLUGIN)
    }
}

allprojects {

    repositories {
        google()
        mavenCentral()
    }
}