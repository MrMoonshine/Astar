package provide

import astar.Location

object locations {
  object StStefan extends Location{
    name = "St Stefan im Rosental"
    dms =  """46°54'05.3"N 15°42'47.3"E"""
    uptPosition
  }

  object Wetzelsdorf extends Location{
    name = "Wetzelsdorf"
    dms =  """46°52'13.4"N 15°43'31.5"E"""
    uptPosition
  }

  object Ungerdorf extends Location{
    name = "Ungerdorf"
    dms =  """46°51'15.2"N 15°43'24.9"E"""
    uptPosition
  }

  object Wolfsberg extends Location{
    name = "Wolfsberg im Schwarzautal"
    dms =  """46°50'38.9"N 15°39'28.7"E"""
    uptPosition
  }

  object Jagerberg extends Location{
    name = "Jagerberg"
    dms =  """46°51'14.5"N 15°44'15.8"E"""
    uptPosition
  }

  object Glojach extends Location{
    name = "Glojach"
    dms =  """46°52'22.1"N 15°40'59.7"E"""
    uptPosition
  }

  object Gaberling extends Location{
    name = "Gaberling"
    dms =  """46°50'29.2"N 15°41'33.2"E"""
    uptPosition
  }

  object Grasdorf extends Location{
    name = "Grasdorf"
    dms =  """46°50'35.1"N 15°43'34.5"E"""
    uptPosition
  }

  object Zehensdorf extends Location{
    name = "Zehensdorf"
    dms =  """46°49'25.0"N 15°43'29.5"E"""
    uptPosition
  }

  object Metterssdorf extends Location{
    name = "Mettersdorf"
    dms =  """46°48'21.5"N 15°42'42.4"E"""
    uptPosition
  }

  object StPeter extends Location{
    name = "St Peter am Ottersbach"
    dms =  """46°47'56.2"N 15°45'34.1"E"""
    uptPosition
  }

  object Unterzirknitz extends Location{
    name = "Unterzirknitz"
    dms =  """46°50'15.3"N 15°45'08.4"E"""
    uptPosition
  }

  object Tagensdorf extends Location{
    name = "Tagensdorf"
    dms =  """46°53'51.0"N 15°40'49.1"E"""
    uptPosition
  }
  object Glatzau extends Location{
    name = "Glatzau"
    dms =  """46°54'45.9"N 15°40'19.7"E"""
    uptPosition
  }

  def loadAllNeighbors(): Unit ={
    //The Coordinates in each object will be used for the heuristics
    //But we also need the actual distance (in this case it's the road)
    StStefan.addNeighbor(Wetzelsdorf,3.9)
    StStefan.addNeighbor(Glatzau,3.7)
    Wetzelsdorf.addNeighbor(StStefan,3.9)
    Wetzelsdorf.addNeighbor(Glojach,4)
    Wetzelsdorf.addNeighbor(Ungerdorf,1.8)
    Wetzelsdorf.addNeighbor(Jagerberg,3.6)
    Ungerdorf.addNeighbor(Wetzelsdorf,1.8)
    Ungerdorf.addNeighbor(Gaberling,3.2)
    Ungerdorf.addNeighbor(Jagerberg,1.5)
    Ungerdorf.addNeighbor(Grasdorf,1.6)
    Grasdorf.addNeighbor(Ungerdorf,1.6)
    Grasdorf.addNeighbor(Gaberling,3.7)
    Grasdorf.addNeighbor(Zehensdorf,2.2)
    Zehensdorf.addNeighbor(Gaberling,5.3)
    Zehensdorf.addNeighbor(Grasdorf,5.3)
    Zehensdorf.addNeighbor(Metterssdorf,2.6)
    Metterssdorf.addNeighbor(Zehensdorf,2.6)
    Metterssdorf.addNeighbor(StPeter,4.6)
    StPeter.addNeighbor(Metterssdorf,4.6)
    StPeter.addNeighbor(Unterzirknitz,5.8)
    Unterzirknitz.addNeighbor(Jagerberg,5.8)
    Unterzirknitz.addNeighbor(Jagerberg,2.7)
    Jagerberg.addNeighbor(Unterzirknitz,2.7)
    Jagerberg.addNeighbor(Wetzelsdorf,3.4)
    Jagerberg.addNeighbor(Ungerdorf,1.5)
    Gaberling.addNeighbor(Ungerdorf,3.2)
    Gaberling.addNeighbor(Grasdorf,3.7)
    Gaberling.addNeighbor(Zehensdorf,5.3)
    Gaberling.addNeighbor(Glojach,2.1)
    Gaberling.addNeighbor(Wolfsberg,3.7)
    Glojach.addNeighbor(Gaberling,2.1)
    Glojach.addNeighbor(Wetzelsdorf,4)
    Glojach.addNeighbor(Tagensdorf,3.5)
    Tagensdorf.addNeighbor(Glojach,3.5)
    Tagensdorf.addNeighbor(Glatzau,2.5)
    Glatzau.addNeighbor(StStefan,3.7)
    Glatzau.addNeighbor(Tagensdorf,2.5)
    Glatzau.addNeighbor(Wolfsberg,7.9)
    Wolfsberg.addNeighbor(Glatzau,7.9)
    Wolfsberg.addNeighbor(Gaberling,3.7)
  }

}
