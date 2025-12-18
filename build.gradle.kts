plugins {
   kotlin("jvm") version "2.2.21"
   id("org.jetbrains.kotlin.plugin.serialization") version "2.2.21"
   id("maven-publish")
}

group = "com.swelms"
version = GitVersion.getVersion()

repositories {
   mavenCentral()
}


dependencies {
   implementation(kotlin("reflect"))
   implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
   implementation("org.jetbrains.kotlinx:kotlinx-serialization-hocon:1.7.3")
   implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.1")
   testImplementation(kotlin("test"))
   testImplementation("org.junit.jupiter:junit-jupiter:5.14.0")
   implementation(kotlin("stdlib-jdk8"))
}


tasks.test {
   useJUnitPlatform()
}

publishing {
   publications {
      create<MavenPublication>("full") {
         from(components["kotlin"])
         groupId = project.group.toString()
         artifactId = "swelms-lib"
         version = project.version.toString()
      }
   }
}


kotlin {
   jvmToolchain(21)
}