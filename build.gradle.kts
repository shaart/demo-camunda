import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val camundaVersion = "7.16.0"

plugins {
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
}

group = "com.github.shaart"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_15

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // spring
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    // camunda
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-webapp:$camundaVersion")
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-rest:$camundaVersion")
    implementation("org.camunda.spin:camunda-spin-dataformat-json-jackson:1.18.1")
    implementation("org.camunda.bpm:camunda-engine-plugin-spin:$camundaVersion")

    implementation("org.apache.commons:commons-csv:1.6")
    runtimeOnly("com.sun.xml.bind:jaxb-impl:2.3.5")

    // kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // db
    runtimeOnly("org.postgresql:postgresql")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.camunda.bpm.assert:camunda-bpm-assert:3.0.0")
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
