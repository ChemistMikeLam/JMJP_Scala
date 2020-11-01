ThisBuild / scalaVersion := "2.13.3"

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2" 

scalacOptions in (Compile, doc) ++= Seq( 
  "-groups" 
) 
