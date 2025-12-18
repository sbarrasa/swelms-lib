val kotlinVersion = "2.2.21"
val dateTimeVersion = "0.6.2"
val group = "com.swelms"
version = GitVersion.getVersion()

plugins {
   kotlin("jvm") version "2.2.21"
   id("org.jetbrains.kotlin.plugin.serialization") version "2.2.21"
}

repositories {
   mavenCentral()
}


dependencies {
   implementation(kotlin("reflect"))
   implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
   implementation("org.jetbrains.kotlinx:kotlinx-serialization-hocon:1.7.3")
   implementation("org.jetbrains.kotlinx:kotlinx-datetime:$dateTimeVersion")
   testImplementation(kotlin("test"))
   testImplementation("org.junit.jupiter:junit-jupiter:5.14.0")
}


tasks.test {
   useJUnitPlatform()
}


