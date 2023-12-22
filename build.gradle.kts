/** plugins {
    kotlin("jvm") version "1.9.21"
    application
    id("org.jetbrains.dokka") version "1.9.21"
}

tasks.dokkaHtml.configure {
    outputDirectory.set(buildDir.resolve("dokka"))
}

dependencies {
    testImplementation(kotlin("test"))
    dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.9.10")
}

**/