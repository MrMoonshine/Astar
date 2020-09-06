package astar
import java.awt.Point

class Location extends Node(new Point){
  def uptPosition(): Unit ={
    position = Geolocation(dms)
  }

  var dms:String = ""
}
