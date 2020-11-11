package io.github.ChemistMikeLam.jmjp 
package ast 

/** 
 *  Represents whole paifu files. 
 *
 *  @constructor 
 *  @param ver version of the paifu file 
 *  @param matches a List of the matches included in the paifu file 
 */ 
case class Paifu(ver: Version, matches: List[Match]) { 

  /** 
   *  Split the paifu file into a List of Paifu objects, each containing one 
   *  match in this Paifu. 
   *
   *  The order of new Paifu objects in the list follows the order of Matches 
   *  in this Paifu object. 
   *
   *  @return the List of split Paifu objects 
   */ 
  def split: List[Paifu] = ??? 

  def merge(other: Paifu): Option[Paifu] = ??? 

  /** 
   *  Appends a match to the paifu file. 
   */ 
  def appendMatch(newMatch: Match): Paifu = ??? 

} 

