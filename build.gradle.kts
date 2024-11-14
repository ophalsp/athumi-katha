import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "2.0.21"
}

repositories {
    mavenLocal()
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

dependencies {
    val junitVersion = "3.26.3"
    val approvalTestsVersion = "24.9.0"
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("org.assertj:assertj-core:$junitVersion")
    testImplementation("com.approvaltests:approvaltests:$approvalTestsVersion")

    testCompileOnly("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testCompileOnly("org.junit.jupiter:junit-jupiter-params:$junitVersion")
}

extensions.findByName("buildScan")?.withGroovyBuilder {
    setProperty("termsOfServiceUrl", "https://gradle.com/terms-of-service")
    setProperty("termsOfServiceAgree", "yes")
}
