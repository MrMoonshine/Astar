package astar
import scala.util.control.Breaks._

case class Astar(data_i:Array[Node],start_i:Node,goal_i:Node){
  private var data = data_i
  private var start = start_i
  private var goal = goal_i
  private var openSet:List[Option[Node]] = List()
  private val startId:Int = setStarter()
  var path:List[Option[Node]] = List[Option[Node]]()
  var fSum:Double = 0
  var gSum:Double = 0

  //makes data compareable
  private def cleanupScores(): Unit ={
    for(n <- data){
      n.gScore = -1
      n.fScore = -1
    }

    start.gScore = -1
    start.fScore = -1
  }

  //set all gScores to infinite
  private def gfScoreInfinity() = {
    for(n <- data){
      n.gScore = Double.PositiveInfinity
      n.fScore = Double.PositiveInfinity
    }
  }

  //This function Puts the start-Node in the Open set with a g and f score of 0
  //if there is no valid Start node it will throw an exception
  //returns the index in the data_i array
  private def setStarter(): Int ={
    cleanupScores()
    for(n <- data.indices){
      if(data(n).eq(start)){
        //println("My Start Node is: " + data(n).toString)
        openSet = List(Some(data(n)))

        this.openSet(0).get.gScore = 0
        this.openSet(0).get.fScore = 0
        //the return keyword is very important here
        return n
      }
    }
    throw new Exception("Invalid Start Node");
  }

  //calculate distance between node and goal
  //IMPORTANT: the actual distance MUST be larger than the heuristic
  private def heuristic(a_i:Node,b_i:Node = goal): Double ={
    val deltaX:Double = a_i.position.x - b_i.position.x
    val deltaY:Double = a_i.position.y - b_i.position.y
    //println(s"deltaX: $deltaX ; deltaY $deltaY")
    Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2))/1000
  }

  private def reconstructPath(current_i:Node): List[Option[Node]] ={
    println("Reconstruct");
    var current = current_i
    var path_s = List[Option[Node]](Some(current))
    gSum = current.gScore

    while(true){
      if(current.position.eq(start.position)){
        return path_s.reverse
      }

      if(current.cameFrom.eq(None)){
        throw new Exception("Insufficient Node data")
      }
      println(s"${current.name} | gScore: ${current.gScore} | fScore: ${current.fScore} | cameFrom: ${current.cameFrom.get.name}")
      current = current.cameFrom.get
      path_s :+= Some(current)
    }
    throw new Exception("Path not traceable")
  }

  override def toString(): String = {
    var outstr = """"""
    outstr +=
      """A* Order:
        | """
    for(n <- path){
      outstr +=
        s"""-> ${n.get.name}
           |""".stripMargin
    }
    outstr.stripMargin
  }

  //write the g and f scores to infinite
  gfScoreInfinity()

  //gScore[start] := 0
  //fScore[start] := h(start)
  data(startId).gScore = 0
  data(startId).fScore = heuristic(data(startId))
breakable{
  while(openSet.length > 0){
    //Sort by Fscore
    openSet = openSet.sortWith(_.get.fScore < _.get.fScore)

    val current:Node = openSet(0).get

    if(current.position.equals(goal.position)){
      path = reconstructPath(current)
      openSet = List[Option[Node]]()
      break
    }
    openSet = openSet diff List(openSet(0))

    for(n <- current.neighbors.indices){
      var tentative_gScore:Double = current.gScore + current.neighborDistance(n)
      //println(s"tentative_gScore: $tentative_gScore | neighbor gScore: ${current.neighbors(n).get.gScore}")
      if(tentative_gScore < current.neighbors(n).get.gScore){
        // This path to neighbor is better than any previous one. Record it!
        current.neighbors(n).get.cameFrom = Some(current)
        current.neighbors(n).get.gScore = tentative_gScore
        current.neighbors(n).get.fScore = tentative_gScore + heuristic(current.neighbors(n).get)
        println(s"${current.neighbors(n).get.name} ${current.neighbors(n).get.gScore} can be reached over ${current.name} ${current.gScore}")
        //if it doesn't exist in the open set add it
        if(!openSet.exists(y => {y.get.position.equals(current.neighbors(n).get.position)})){
          openSet :+= current.neighbors(n)
        }
      }
    }
  }
}
}
