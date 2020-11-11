package io.github.ChemistMikeLam.jmjp 

package object ast { 

  case class StrLit(native: String, roman: String) { 
    override lazy val toString: String = (native, roman) match { 
      case ("", "") => "" 
      case (nt, "") => nt 
      case ("", rm) => rm 
      case (nt, rm) => nt + " (" + rm + ")" 
    } 
  } 

  case class Name(last: StrLit, first: StrLit) { 
    override lazy val toString: String = last.toString + ", " + first.toString 
  } 

  sealed trait Wind 
  object Wind { 
    case object East extends Wind 
    case object South extends Wind 
    case object West extends Wind 
    case object North extends Wind 
  } 

  case class FrameId(wind: Wind, num: Int, honba: Int) 

  case class Point(private val pt: Int) { 
    lazy val ptString: String = (pt / 10).toString + "." + (pt % 10).toString 
    override lazy val toString: String = ptString 
  } 

  case class PointTour(personal: Point, team: Point) 

  case class Hand(inHand: List[Tile], tsumo: Option[Tile], furo: List[Furo]) 

  sealed trait TourName 
  object TourName { 
    case class StrLit(lit: ast.StrLit) extends TourName 
    case object MLeague extends TourName 
  } 

  sealed trait TourStage 
  object TourStage {
    case class StrLit(lit: ast.StrLit) extends TourStage 
    case object FirstRound extends TourStage 
    case object SecondRound extends TourStage 
    case object QuarterFinal extends TourStage 
    case object SemiFinal extends TourStage 
    case object Final extends TourStage 
    case object MLeagueRegular extends TourStage 
    case object MLeagueSemiFinal extends TourStage 
    case object MLeagueFinal extends TourStage 
  } 

  sealed trait MatchPlace 
  object MatchPlace { 
    case class StrLit(lit: ast.StrLit) extends MatchPlace 
    case object MLeagueStandard extends MatchPlace 
  } 

  sealed trait PlayerTeam 
  object PlayerTeam { 
    case class StrLit(lit: ast.StrLit) extends PlayerTeam 
    case object MLeagueDrivens extends PlayerTeam 
    case object MLeagueFurinkazan extends PlayerTeam 
    case object MLeagueSakuraKnights extends PlayerTeam 
    case object MLeagueFightClub extends PlayerTeam 
    case object MLeagueAbemas extends PlayerTeam 
    case object MLeaguePhoenix extends PlayerTeam 
    case object MLeagueRaiden extends PlayerTeam 
    case object MLeaguePirates extends PlayerTeam 
  } 

  sealed trait PlayerAffil 
  object PlayerAffil { 
    case class StrLit(lit: ast.StrLit) extends PlayerAffil 
    case object None extends PlayerAffil 
    case object Saikouisen extends PlayerAffil 
    case object ProKyoukai extends PlayerAffil 
    case object ProRenmei extends PlayerAffil 
    case object RMU extends PlayerAffil 
    case object RengouMu extends PlayerAffil 
    case object HyakuIchi extends PlayerAffil 
    case object KishiKai extends PlayerAffil 
    case object ZenNihon extends PlayerAffil 
  } 

  case class Version(major: Int, minor: Int) 

  case class Date(day: Option[Int], month: Option[Int], year: Option[Int]) 

  sealed trait DayOfWeek 
  object DayOfWeek { 
    case object Sun extends DayOfWeek 
    case object Mon extends DayOfWeek 
    case object Tue extends DayOfWeek 
    case object Wed extends DayOfWeek 
    case object Thu extends DayOfWeek 
    case object Fri extends DayOfWeek 
    case object Sat extends DayOfWeek 
  } 

  case class Time(hour: Int, minute: Int) 

} 
