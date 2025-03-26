plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-api:1.7.36")
    implementation("ch.qos.logback:logback-classic:1.2.11")
    testImplementation("junit:junit:4.13.2")
}

tasks.register<JavaExec>("runCalculator") {
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("org.example.App")
    if (project.hasProperty("num1") && project.hasProperty("num2") && project.hasProperty("operation")) {
        args(project.property("num1"), project.property("operation"), project.property("num2"))
    } else {
        args("5", "+", "3") // Default values
    }
}