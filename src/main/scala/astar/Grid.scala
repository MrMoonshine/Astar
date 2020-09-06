package astar

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

  override def toString: String = {
    "Grid!!!"
  }

  if(height < 1 || width < 1){
    throw new Exception("Insufficient data provided")
  }


}
