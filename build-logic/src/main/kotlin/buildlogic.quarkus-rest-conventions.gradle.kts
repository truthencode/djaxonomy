import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("buildlogic.quarkus-common-conventions")
}

val libs = the<LibrariesForLibs>()

dependencies {
    implementation(libs.quarkus.arc)
    implementation(libs.quarkus.rest)
    implementation(libs.quarkus.rest.client)
    implementation(libs.quarkus.rest.jackson)
    // quarkus test dependencies need to be moved to apply in jvmtest suite
    testImplementation(libs.quarkus.junit)
    testImplementation(libs.rest.assured)
}
