package com.github.ChemistMikeLam.jmjp 
package ast 

/** 
 *  TourInfo 
 */ 
case class TourInfo( 
  tourName: Option[TourName], 
  tourYear: Option[Int], 
  tourStage: Option[TourStage], 
  matchNumInStage: Option[Int], 
  matchNumInDay: Option[Int] 
) 

/** 
 *  MatchTimePlace 
 */ 
case class MatchTimePlace( 
  date: Option[Date], 
  dayOfWeek: Option[DayOfWeek], 
  time: Option[Time], 
  place: Option[MatchPlace] 
) 

/** 
 *  RecerInfo 
 */ 
case class RecerInfo( 
  name: Name, 
  framesReced: List[FrameId] 
) 

/** 
 *  PlayerInfo 
 */ 
case class PlayerInfo( 
  name: Name, 
  team: PlayerTeam, 
  affil: PlayerAffil, 
  ptTourPrev: PointTour 
) 

/** 
 *  PointRule 
 */ 
case class PointRule( 
  start: Point, 
  ret: Point, 
  pos: (Point, Point), 
  honba: Point, 
  tenpai : Point 
) 

