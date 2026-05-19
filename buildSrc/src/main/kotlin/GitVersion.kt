object GitVersion {

   private fun exec(vararg command: String): String =
      ProcessBuilder(*command)
         .redirectErrorStream(true)
         .start()
         .inputStream
         .bufferedReader()
         .readText()
         .trim()

   fun getVersion(): String {
      val tag = exec("git", "describe", "--tags", "--abbrev=0")
         .removePrefix("v")

      val patch =
         exec("git", "rev-list", "$tag..HEAD", "--count")

      return "$tag.$patch"
   }
}