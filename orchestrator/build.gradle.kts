plugins {
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.spring") version "2.2.21"
    id("org.springframework.boot") version "4.0.2"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
description = "Project for Datadog integration"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("net.logstash.logback:logstash-logback-encoder:7.4")
    implementation("com.h2database:h2")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:3.0.0")
    implementation("io.micrometer:micrometer-tracing-bridge-otel")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.datadoghq:dd-trace-api:1.59.0")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.bootRun {
    jvmArgs = listOf(
        "-javaagent:${project.rootDir}/datadog/dd-java-agent.jar",
        "-Ddd.service=orchestrator",
        "-Ddd.env=dev",
        "-Ddd.version=1.0",
        "-Ddd.logs.injection=true",
        "-Ddd.trace.agent.host=localhost",
        "-Ddd.trace.agent.port=8126"
    )
}