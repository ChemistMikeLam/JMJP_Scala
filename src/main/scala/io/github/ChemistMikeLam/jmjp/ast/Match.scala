package io.github.ChemistMikeLam.jmjp 
package ast 

/** 
 *  Match 
 */ 
case class Match( 
  tour: Option[TourInfo], 
  matchTP: MatchTimePlace, 
  recer: List[RecerInfo], 
  players: Map[Wind, PlayerInfo], 
  ptRule: Option[PointRule], 
  frames: List[Frame], 
  ptMatchEnd: Option[Map[Wind, Point]], 
  ptTourNew: Option[Map[Wind, Point]] 
) { 
} 

