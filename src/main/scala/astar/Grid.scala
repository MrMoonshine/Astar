package astar

import java.awt.Point

//A grid is a A* data structure
class Grid(grid_i:Array[Array[Boolean]],diagonal:Boolean = true) {
  val height = grid_i(0).length
  val width = grid_i.length
  val neighborOffsets:Array[Array[Int]] = fetchNeighborOffsets()

  private def fetchNeighborOffsets(): Array[Array[Int]] ={
    var noff:Array[Array[Int]] = Array()
    noff :+= Array(-1,0)
    noff :+= Array(1,0)
    noff :+= Array(0,1)
    noff :+= Array(0,-1)

    if(diagonal){
      noff :+= Array(-1,-1)
      noff :+= Array(1,-1)
      noff :+= Array(-1,1)
      noff :+= Array(1,1)
    }

    noff
  }
  private def getValidGridNeighbors(i_i:Int,j_i:Int):Array[Array[Int]] = {
    var posarr:Array[Array[Int]] = Array()
    for(n <- neighborOffsets){
      val i = i_i + n(0)
      val j = j_i + n(1)
      if(i < width && i >= 0 && j < width && j >= 0){
        posarr :+= Array(i,j)
      }
    }
    posarr
  }
  private def distance(a_i:Point,b_i:Point): Double ={
    val deltaX:Double = a_i.x - b_i.x
    val deltaY:Double = a_i.y - b_i.y
    //println(s"deltaX: $deltaX ; deltaY $deltaY")
    Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2))/1000
  }

  def build(): Array[Node] = {
    var arr2d:Array[Array[Option[Node]]] = Array()
    var oarr:Array[Node] = Array()
    for(i <- 0 until width; j <- 0 until height){
      arr2d(i)(j) = Some(new Node(new Point(i * 10,j * 10)){
        name = s"GridNode_${i}_${j}"
      })
    }

    for(i <- 0 until width; j <- 0 until height){
      for(n <- getValidGridNeighbors(i,j)){
        if(grid_i(n(0))(n(1))){
          arr2d(i)(j).get.addNeighbor()
        }else{
          arr2d(n(0))(n(1)) = None
        }
      }
    }

    for(i <- 0 until width; j <- 0 until height){
      oarr :+= arr2d(i)(j)
    }
    oarr
  }

  override def toString: String = {
    "Grid!!!"
  }

  if(height < 1 || width < 1){
    throw new Exception("Insufficient data provided")
  }



}
