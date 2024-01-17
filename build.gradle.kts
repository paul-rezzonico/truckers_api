plugins {
    kotlin("jvm") version "1.9.21"
	kotlin("plugin.spring") version "1.9.21"
}

group = "com.unilim.info"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.2.1")
	implementation("org.springframework.boot:spring-boot-starter-data-rest:3.2.1")
	implementation("org.springframework.boot:spring-boot-starter-security:3.2.1")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
	implementation("org.springframework.boot:spring-boot-starter-web:3.2.1")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
	implementation("org.jetbrains.kotlin:kotlin-reflect:2.0.0-Beta2")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.0.0-Beta2")

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