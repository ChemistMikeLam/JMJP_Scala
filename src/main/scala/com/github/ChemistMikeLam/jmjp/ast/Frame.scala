package com.github.ChemistMikeLam.jmjp 
package ast 

case class Frame(
  startHand: Map[Wind, Hand], 
  acts: List[FrameAct], 
  endHand: Map[Wind, Hand] 
) { 
} 

