/**
 * This file is part of the common build-logic project.
 * Adds quarkus specific core plugins and configurations
 * Includes basic CDI, Health Checks, Validation (Jakarta ala Hibernate) and basic testing.
 *
 * Advanced features (e.g. OpenAPI, REST, Reactive, etc.) should be added to the project-specific build logic
 *
 */
import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("io.quarkus")
    id("buildlogic.common-conventions")
}
val libs = the<LibrariesForLibs>()
val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("$quarkusPlatformGroupId:$quarkusPlatformArtifactId:$quarkusPlatformVersion"))
    implementation(libs.quarkus.arc)
    implementation(libs.quarkus.smallrye.health)
    implementation(libs.quarkus.hibernate.validator) {
        because(
            "Hibernate Validator is an implementation of the Jakarta Bean Validation specification." +
                " Not specific to JPA.",
        )
    }
//    implementation(libs.quarkus.rest)
    // basic Quarkus Unit, Component and Integration test support included.
    testImplementation(libs.quarkus.junit)
//    testImplementation("io.quarkus:quarkus-junit5-component")
    testImplementation(libs.quarkus.cucumber)
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
