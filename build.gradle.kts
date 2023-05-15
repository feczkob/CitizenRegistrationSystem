import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.1"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
}

group = "com.crs"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

object Version {
    val springdoc = "1.7.0"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("org.springdoc:springdoc-openapi-data-rest:${Version.springdoc}")
    implementation("org.springdoc:springdoc-openapi-ui:${Version.springdoc}")
    runtimeOnly("org.springdoc:springdoc-openapi-kotlin:${Version.springdoc}")

    implementation("javax.ws.rs:javax.ws.rs-api:2.1.1")
    implementation("org.springframework.boot:spring-boot-starter-jersey")
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.5")
    implementation("org.modelmapper:modelmapper:3.1.1")
    implementation("org.openapitools:jackson-databind-nullable:0.2.1")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
