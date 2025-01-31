/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.12/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application

    // Apply the Shadow plugin for creating a fat JAR.
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit test framework.
    testImplementation(libs.junit)

//    implementation(files("lib/jaco-mp3-player-0.9.3.jar"))
    implementation("com.googlecode.soundlibs:mp3spi:1.9.5.4")
    implementation("com.googlecode.soundlibs:tritonus-share:0.3.7-2")

}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    // Define the main class for the application.
    mainClass = "minesweeper4d.Main"
    applicationDefaultJvmArgs = listOf("-Dapple.awt.UIElement=true")
}

tasks {
    shadowJar {
        // Set the main class for the fat JAR.
        manifest {
            attributes["Main-Class"] = "minesweeper4d.Main"
        }
        archiveFileName.set("minesweeper4d.jar")
    }
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
    doFirst {
        project.gradle.startParameter.consoleOutput = org.gradle.api.logging.configuration.ConsoleOutput.Plain
    }
}