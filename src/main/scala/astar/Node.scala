package astar

import java.awt.Point

class Node(position_i:Point){
  var position:Point = position_i
  var name:String = ""
  var neighbors:Array[Option[Node]] = Array()
  var neighborDistance:Array[Double] = Array()
  var gScore:Double = -1
  var fScore:Double = -1
  var cameFrom:Option[Node] = None

  def addNeighbor(neighbor_i:Node,realDistance:Double): Unit ={
    //println(s"[Node]:$name gets a new Neighbor: ${neighbor_i.name}")
    neighbors :+= Some(neighbor_i)
    neighborDistance :+= realDistance * 1
  }

  def getNeighbors(): List[Node] ={
    var nlis:List[Node] = List()
    for(n <- neighbors){
      nlis :+= n.get
    }
    nlis
  }

  override def toString(): String = {
    lazy val xpos = position.x
    lazy val ypos = position.y
    var neighborstring = ""
    for(n <- neighbors){
      neighborstring += "," + n.get.name
    }

    s"[Node] $name ; gScore: $gScore ; fScore: $fScore ; position: $xpos , $ypos; Neighbors $neighborstring"
  }
}
