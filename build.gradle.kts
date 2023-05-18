// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("org.jetbrains.kotlin.android") version "1.8.0" apply (false)
}

buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        projectConfigurantion()
    }
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}