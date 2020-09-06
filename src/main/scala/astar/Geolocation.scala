package astar

import java.awt.Point

import scala.util.matching.Regex

//the constructor will get a DMS string like:
//41°24'12.2"N 2°10'26.5"E
//and will calculate a usable position for the A* algorithm
case class Geolocation(coordinates:String) extends Point {
  def DMS2DD(deg:Double,min:Double,sec:Double): Double ={
    deg + (min/60) + (sec/3600)
  }

  //fetch all numbers (with dots)
  val keyPattern:Regex = "([0-9-. ]+)".r
  var coords:Array[Double] = Array()
  //this factor is used to get differences of DD values with the correct distances
  lazy val heuristicFactor:Double = 1000 * 99.72 //it was calculated manually :3
  lazy val latitudeDD = DMS2DD(coords(0),coords(1),coords(2))
  lazy val longitudeDD = DMS2DD(coords(3),coords(4),coords(5))

  for(patMatch <- keyPattern.findAllMatchIn(coordinates)){
    //println(s"a ${patMatch.group(1)}")
    coords ++= Array(patMatch.group(1).toDouble)
  }

  if(coords.length < 6){
    throw new Exception("Invalid DMS String: " + coordinates)
  }

  x = (latitudeDD * heuristicFactor).asInstanceOf[Int]
  y = (longitudeDD * heuristicFactor).asInstanceOf[Int]
}
