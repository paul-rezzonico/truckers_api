plugins {
    java
	id("org.springframework.boot") version "3.1.5"
    id("org.jetbrains.kotlin.jvm") version "2.0.0-Beta1"
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

	testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.1")
	testImplementation("junit:junit:4.13.2")
	testImplementation("org.mockito:mockito-core:5.9.0")
	testImplementation("io.strikt:strikt-core:0.34.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}