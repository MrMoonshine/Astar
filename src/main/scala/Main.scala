import astar.{Astar, Grid, Location, Node}
import provide.locations._

import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    println("Glatzau -> Jagerberg")
    val myarr:Array[Location] = Array(Glatzau,Wolfsberg,StStefan,Wetzelsdorf,Ungerdorf,Gaberling,Glojach,Grasdorf,Zehensdorf,Metterssdorf,StPeter,Unterzirknitz,Jagerberg)
    var astarlavista = Astar(myarr.asInstanceOf[Array[Node]],Glatzau,Jagerberg)
    println(astarlavista.toString())
    println("Fertig")

    val randomizer = new Random(100)

    var bbarr: Array[Array[Boolean]] = Array()
    for (n <- 0 until 16) {
      var barr: Array[Boolean] = Array()
      for (m <- 0 until 20) {
        barr :+= randomizer.nextBoolean()
      }
      bbarr :+= barr
    }

    bbarr(0)(0) = true
    bbarr(15)(19) = true

    val myg = new Grid(bbarr)
    val griddatstruc = myg.build()
    println(myg.toString())

    for (n <- griddatstruc) {
      println(n.toString())
    }

    val astarix = Astar(griddatstruc, griddatstruc(0), griddatstruc(9))
    println(astarix.toString())
  }
}
