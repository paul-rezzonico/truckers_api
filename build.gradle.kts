plugins {
    java
    id("org.springframework.boot") version "3.1.5"
    id("org.jetbrains.kotlin.jvm") version "2.0.0-Beta1"
    id("org.sonarqube") version "4.4.1.3373"
    id("org.jetbrains.kotlinx.kover") version "0.7.5"
}

group = "com.unilim.info"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.1")
    implementation("org.springframework.security:spring-security-core:6.2.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.0-Beta1")
    implementation("org.springframework.boot:spring-boot-starter-mail:3.2.2")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.1")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
    testImplementation("org.mockito:mockito-core:5.9.0")
    testImplementation("org.mockito:mockito-inline:5.2.0")
    testImplementation("io.strikt:strikt-core:0.34.0")
    testImplementation("com.google.jimfs:jimfs:1.3.0")
}

kotlin {
    jvmToolchain(21)
}

sonar {
    properties {
        property("sonar.projectName", "truckers_api")
        property("sonar.projectKey", "truckers_api")
        property("sonar.host.url", "http://localhost:9000")
        property("sonar.token", project.findProperty("sonarToken") as String? ?: "")
        property("sonar.gradle.skipCompile", "true")
    }
}

tasks.test {
    useJUnitPlatform()
}