plugins {
    java
    id("org.sonarqube") version "4.4.1.3373"
    id("org.jetbrains.kotlinx.kover") version "0.7.5"
    id("org.jetbrains.kotlin.jvm") version "2.1.20"
    id("org.jetbrains.kotlin.plugin.spring") version "2.1.20"
}

group = "com.unilim.info"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.4.4")
    implementation("org.springframework.security:spring-security-core:6.4.4")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.3")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.3")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.1.20")
    implementation("org.springframework.boot:spring-boot-starter-mail:3.4.4")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.6")
    implementation("org.hibernate.validator:hibernate-validator:8.0.1.Final")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.4")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.4.0")
    testImplementation("org.mockito:mockito-core:5.16.1")
    testImplementation("org.mockito:mockito-inline:5.2.0")
    testImplementation("io.strikt:strikt-core:0.35.1")
    testImplementation("com.google.jimfs:jimfs:1.3.0")
}

kotlin {
    jvmToolchain(17)
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