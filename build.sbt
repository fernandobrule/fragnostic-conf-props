import com.typesafe.sbt.pgp.PgpKeys
import scala.xml._
import java.net.URL
import Dependencies._

val unusedOptions = Def.setting(
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, 11)) =>
      Seq("-Ywarn-unused-import")
    case _ =>
      Seq("-Ywarn-unused:imports")
  }
)

lazy val scalatraSettings = Seq(
  organization := "com.fragnostic",
  fork in Test := true,
  baseDirectory in Test := file("."),
  crossScalaVersions := Seq("2.12.11", "2.11.12", "2.13.1"),
  scalaVersion := crossScalaVersions.value.head,
  scalacOptions ++= unusedOptions.value,
  scalacOptions ++= Seq(
    "-target:jvm-1.8",
    "-unchecked",
    "-deprecation",
    "-Xlint",
    /*"-Yinline-warnings",*/
    "-Xcheckinit",
    "-encoding", "utf8",
    "-feature",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-language:reflectiveCalls",
    "-language:existentials"
  ),
  manifestSetting,
  dependencyOverrides := Seq(
    "org.scala-lang" % "scala-library"  % scalaVersion.value,
    "org.scala-lang" % "scala-reflect"  % scalaVersion.value,
    "org.scala-lang" % "scala-compiler" % scalaVersion.value
  )
) ++ Seq(Compile, Test).flatMap(c =>
  scalacOptions in (c, console) --= unusedOptions.value
)

lazy val fragnosticConfProject = Project(
  id = "fragnostic-conf-props",
  base = file(".")).settings(
    scalatraSettings ++ Seq(
    name := "fragnostic conf props",
    artifacts := Classpaths.artifactDefs(Seq(packageDoc in Compile, makePom in Compile)).value,
    packagedArtifacts := Classpaths.packaged(Seq(packageDoc in Compile, makePom in Compile)).value,
    description := "fragnostic conf props",
    shellPrompt := { state =>
      s"sbt:${Project.extract(state).currentProject.id}" + Def.withColor("> ", Option(scala.Console.CYAN))
    }
  ) ++ Defaults.packageTaskSettings(
    packageDoc in Compile, (unidoc in Compile).map(_.flatMap(Path.allSubpaths))
  )).aggregate(
    fragnosticConf
  ).enablePlugins(ScalaUnidocPlugin)


lazy val fragnosticConf = Project(
  id = "fragnostic-conf-props",
  base = file("fragnostic-conf-props")).settings(
    scalatraSettings ++ Seq(
    libraryDependencies ++= Seq(
      logbackClassic,
      slf4jApi,
      scalatest,
      fragnosticConfEnv
    ) ++ specs2.map(_ % "test"),
    description := "fragnostic-conf-props"
  )
) dependsOn(
)

lazy val manifestSetting = packageOptions += {
  Package.ManifestAttributes(
    "Created-By" -> "Simple Build Tool",
    "Built-By" -> System.getProperty("user.name"),
    "Build-Jdk" -> System.getProperty("java.version"),
    "Specification-Title" -> name.value,
    "Specification-Version" -> version.value,
    "Specification-Vendor" -> organization.value,
    "Implementation-Title" -> name.value,
    "Implementation-Version" -> version.value,
    "Implementation-Vendor-Id" -> organization.value,
    "Implementation-Vendor" -> organization.value
  )
}

lazy val doNotPublish = Seq(publish := {}, publishLocal := {}, PgpKeys.publishSigned := {}, PgpKeys.publishLocalSigned := {})

