ThisBuild / scalaVersion := "2.13.3" 

lazy val scalaVersionString = settingKey[String]("Scala Version String") 

scalaVersionString := { 
  CrossVersion.partialVersion(scalaVersion.value) match { 
    case Some((big, small)) => big + "." + small 
    case _ => "Other_Version" 
  } 
} 

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2" 

Compile / doc / scalacOptions ++= Seq( 
  "-groups" 
) 

Compile / doc / target := baseDirectory.value / "docs" / ("scala-" + scalaVersionString.value)

autoAPIMappings := true 

apiURL := 
  Some( 
    url( 
      "https://ChemistMikeLam.github.io/JMJP_Scala/scala-" + 
      scalaVersionString.value + 
      "/" 
    ) 
  ) 

