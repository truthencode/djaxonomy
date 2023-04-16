package io.truthencode.djaxonomy.etc


import org.gradle.api.Project
import org.gradle.api.plugins.jvm.JvmTestSuite
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.provideDelegate

class TestBuildSupport (proj: Project) {
    val koTestVersion: String by proj
    val applyMockito = { suite: JvmTestSuite ->
        suite.useJUnitJupiter()
        suite.dependencies {
            this.implementation("org.mockito:mockito-junit-jupiter:4.6.1")
        }
    }

    val applyKoTest = { suite: JvmTestSuite ->
        suite.useJUnitJupiter()
        suite.dependencies {
            implementation("io.kotest:kotest-runner-junit5:$koTestVersion")
            implementation("io.kotest:kotest-assertions-core:$koTestVersion")
            implementation("io.kotest:kotest-property:$koTestVersion")
        }
    }
}