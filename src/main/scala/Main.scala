import astar.{Astar, Location, Node}
import provide.locations._

object Main {
  def main(args: Array[String]): Unit = {
    println("hello World");

    val n1:Location = Glatzau
    val n2:Location = StPeter

    println(n1.toString())
    println(n2.toString())

    //n2.fScore = 99;

    println(n1.toString())

    loadAllNeighbors()
    println("Nachbarn von " + Wetzelsdorf.name + ":" + Wetzelsdorf.getNeighbors.length)
    for(x <- Wetzelsdorf.getNeighbors){
      println(x.name)
    }
    println(Wetzelsdorf.toString())


    val disdiag:Double = 14300 //meters
    val deltaX:Double = n1.position.x - n2.position.x
    val deltaY:Double = n1.position.y - n2.position.y
    println(s"Distance $disdiag ; deltaX: $deltaX ; deltaY $deltaY")
    val c:Double = Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2))
    println(c)

    val myarr:Array[Location] = Array(Glatzau,Wolfsberg,StStefan,Wetzelsdorf,Ungerdorf,Gaberling,Glojach,Grasdorf,Zehensdorf,Metterssdorf,StPeter,Unterzirknitz,Jagerberg)
    var astarlavista = Astar(myarr.asInstanceOf[Array[Node]],Glatzau,Jagerberg)
    println(astarlavista.toString())
  }
}
