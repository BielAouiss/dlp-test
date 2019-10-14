// @GENERATOR:play-routes-compiler
// @SOURCE:/home/bilel/Desktop/TestTechnique/dlp-test/conf/routes
// @DATE:Mon Oct 14 17:56:55 CEST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
