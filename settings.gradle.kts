pluginManagement {
   val kotlinVersion = "2.3.20"

   plugins {
      kotlin("jvm") version kotlinVersion
      id("org.jetbrains.kotlin.plugin.serialization") version kotlinVersion
   }
}

plugins {
   id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "swelms-lib"
