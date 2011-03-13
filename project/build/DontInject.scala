import sbt._

class DontInject(info: ProjectInfo) extends DefaultProject(info) {
  val specs = "org.scalatest" % "scalatest" % "1.3"
}
