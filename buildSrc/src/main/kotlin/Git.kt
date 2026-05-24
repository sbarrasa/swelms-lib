package swelms.plugins

object Git {

   private fun exec(vararg command: String): String =
      ProcessBuilder(*command)
         .redirectErrorStream(true)
         .start()
         .inputStream
         .bufferedReader()
         .readText()
         .trim()

   private fun getVer(): String {
      val tag = exec("git", "describe", "--tags", "--abbrev=0")
         .removePrefix("v")

      val patch =
         exec("git", "rev-list", "$tag..HEAD", "--count")

      val version = "$tag.$patch"
      println("Version = $version")
      return version
   }

   val version by lazy { getVer() }

}