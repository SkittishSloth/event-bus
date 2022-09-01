import org.checkerframework.gradle.plugin.CheckerFrameworkExtension

plugins {
    // Apply the java-library plugin for API and implementation separation.
    `java-library`
    id("org.checkerframework") version "0.6.15"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

configure<CheckerFrameworkExtension> {
    checkers = listOf(
        "org.checkerframework.checker.nullness.NullnessChecker",
        "org.checkerframework.checker.units.UnitsChecker"
    )
}

dependencies {
  compileOnly("org.projectlombok:lombok:1.18.24")
  annotationProcessor("org.projectlombok:lombok:1.18.24")
	
	testCompileOnly("org.projectlombok:lombok:1.18.24")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.24")
    
  // Use JUnit Jupiter for testing.
  testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
