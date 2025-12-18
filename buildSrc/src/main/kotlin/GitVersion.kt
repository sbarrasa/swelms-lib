object GitVersion {
   fun getMajorMinor(): Pair<Int, Int> {
      val process = ProcessBuilder("git", "describe", "--tags", "--abbrev=0")
         .redirectErrorStream(true)
         .start()
      val tag = process.inputStream.bufferedReader().readText().trim()
      if (tag.startsWith("fatal")) return 0 to 0
      val parts = tag.split(".")
      return parts.getOrElse(0){ "0" }.toInt() to parts.getOrElse(1){ "0" }.toInt()
   }

   fun getPatch(): Int {
      val count = ProcessBuilder("git", "rev-list", "--count", "HEAD")
         .redirectErrorStream(true)
         .start()
         .inputStream.bufferedReader().readText().trim()
      return count.toInt()
   }

   fun getVersion(suffix: String = "SNAPSHOT"): String {
      val (major, minor) = getMajorMinor()
      val patch = getPatch()
      return "$major.$minor.$patch-$suffix"
   }
}

