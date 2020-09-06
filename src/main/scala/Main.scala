import astar.{Astar, Grid, Location, Node}
import provide.locations._

object Main {
  def main(args: Array[String]): Unit = {
    println("Glatzau -> Jagerberg")
    loadAllNeighbors()
    val myarr:Array[Location] = Array(Glatzau,Wolfsberg,StStefan,Wetzelsdorf,Ungerdorf,Gaberling,Glojach,Grasdorf,Zehensdorf,Metterssdorf,StPeter,Unterzirknitz,Jagerberg)
    var astarlavista = Astar(myarr.asInstanceOf[Array[Node]],Glatzau,Jagerberg)
    println(astarlavista.toString())
    println("Fertig")


    var bbarr: Array[Array[Boolean]] = Array()
    bbarr :+= Array(true, true, false, false, false, false, true, true)
    bbarr :+= Array(true, true, true, true, true, false, true, false)
    bbarr :+= Array(false, true, false, false, true, false, false, true)
    bbarr :+= Array(false, true, false, true, true, true, false, false)
    bbarr :+= Array(true, false, false, false, false, false, true, true)
    bbarr :+= Array(true, true, false, false, false, false, true, true)
    bbarr :+= Array(false, true, false, false, true, true, true, true)
    bbarr :+= Array(true, false, true, true, true, false, true, true)

    val myg = new Grid(bbarr)
    val griddatstruc = myg.build()
    println(myg.toString())

    val astarix = Astar(griddatstruc, griddatstruc(0), griddatstruc.last)
    println(astarix.toString())
  }
}
