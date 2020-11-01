package com.github.ChemistMikeLam.jmjp 
package ast 

import scala.collection.immutable.ArraySeq 

/** 
 *  Match 
 */ 
case class Match( 
  tour: Option[TourInfo], 
  matchTP: MatchTimePlace, 
  recer: List[RecerInfo], 
  players: ArraySeq[PlayerInfo], 
  ptRule: Option[PointRule], 
  frames: List[Frame], 
  ptMatchEnd: Option[ArraySeq[Point]], 
  ptTourNew: Option[ArraySeq[Point]] 
) { 
} 

