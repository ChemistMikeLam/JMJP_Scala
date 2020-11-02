package com.github.ChemistMikeLam.jmjp 
package ast 

sealed trait NumTileSuit 
object NumTileSuit { 
  case object Circle extends NumTileSuit 
  case object Bamboo extends NumTileSuit 
  case object Character extends NumTileSuit 
} 

sealed trait Tile 
object Tile{ 

  sealed trait Type 
  object Type { 
    sealed trait Normal extends Type 
    sealed trait Action extends Type 
  } 

  sealed trait Use 
  object Use { 
    sealed trait Draw extends Use 
    sealed trait Discard extends Use 
  } 

} 

sealed trait RealTile extends Tile with Tile.Type.Normal with Tile.Use.Draw with Tile.Use.Discard 
object RealTile { 
  case class Num(suit: NumTileSuit, num: Int) extends RealTile 
  sealed trait Honor extends RealTile 
  object Honor { 
    case class Wind(wind: ast.Wind) extends Honor 
    sealed trait Dragon extends Honor 
    object Dragon { 
      case object White extends Dragon 
      case object Green extends Dragon 
      case object Red extends Dragon 
    } 
  } 
  case object Unknown extends RealTile 
} 

sealed trait RelDir 
object RelDir { 
  case object Kamicha extends RelDir 
  case object Toimen extends RelDir 
  case object Shimocha extends RelDir 
} 

sealed trait Furo 
object Furo { 
  case class Chi(in: Tile.Type.Normal, hand: List[Tile.Type.Normal]) extends Furo 
  case class Pon(in: Tile.Type.Normal, hand: List[Tile.Type.Normal], from: RelDir) extends Furo 
  sealed trait Kan extends Furo 
  object Kan { 
    case class Daiminkan(in: Tile.Type.Normal, hand: List[Tile.Type.Normal], from: RelDir) extends Furo 
    case class Kakan(kanIn: Tile.Type.Normal, ponIn: Tile.Type.Normal, hand: List[Tile.Type.Normal], from: RelDir) extends Furo 
    case class Ankan(tiles: List[Tile.Type.Normal]) extends Furo 
  } 
} 

case class Hand(inHand: List[Tile.Type.Normal], tsumo: Option[Tile.Type.Normal], furo: List[Furo]) 

sealed trait DrawAct extends Tile with Tile.Type.Action with Tile.Use.Draw 
object DrawAct { 
  case class Chi(hand: List[Tile.Type.Normal]) extends DrawAct 
  case class Pon(hand: List[Tile.Type.Normal]) extends DrawAct 
  case class Daiminkan(hand: List[Tile.Type.Normal]) extends DrawAct 
  case class Rinshan(in: Tile.Type.Normal) extends DrawAct 
  case object Ron extends DrawAct 
  case object Oya extends DrawAct 
} 

sealed trait DiscardAct extends Tile with Tile.Type.Action with Tile.Use.Discard 
object DiscardAct { 
  case object Tsumogiri extends DiscardAct 
  case object Karagiri extends DiscardAct 
  case class Kakan(hand: Tile.Type.Normal) extends DiscardAct 
  case class Ankan(hand: List[Tile.Type.Normal]) extends DiscardAct 
  case object Tsumo extends DiscardAct 
  case class Riichi(out: Tile.Type.Normal) extends DiscardAct 
} 

case class FrameAct(seat: Wind, draw: Tile.Use.Draw, discard: Tile.Use.Discard) 

