val scala2Version = "2.13.15"

lazy val root = project
  .in(file("."))
  .settings(
    name := "interview-exercise",
    version := "0.1.0",
    scalaVersion := scala2Version,
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-ember-client" % "0.23.27",
      "org.http4s" %% "http4s-ember-server" % "0.23.27",
      "org.http4s" %% "http4s-dsl" % "0.23.27",
      "org.http4s" %% "http4s-circe" % "0.23.27",
      "io.circe" %% "circe-generic" % "0.14.7",
      "ch.qos.logback" % "logback-classic" % "1.4.14",
      "org.typelevel" %% "munit-cats-effect" % "2.0.0" % Test
    )
  )
