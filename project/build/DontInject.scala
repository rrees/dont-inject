import sbt._

class DontInject(info: ProjectInfo) extends DefaultProject(info) {
	val specs = "org.scalatest" % "scalatest" % "1.3"
	val mockito = "org.mockito" % "mockito-all" % "1.8.1"
}
