site.settings

ghpages.settings

git.remoteRepo := "git@github.com:popok/Binding.scala-workshop.git"

val js = project

scalaVersion in ThisBuild := "2.11.7"

import com.typesafe.sbt.SbtSite.SiteKeys
import org.scalajs.core.tools.io.FileVirtualJSFile
SiteKeys.siteMappings ++= {
  val linked = (scalaJSLinkedFile in js in Compile).value.asInstanceOf[FileVirtualJSFile]
  Seq(
    linked.file -> linked.file.getName,
    linked.sourceMapFile -> linked.sourceMapFile.getName
  )
}
