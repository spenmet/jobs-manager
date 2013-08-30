/*
konigsberg bridge puzzle

         (Island 1)
  _||_||_      __||__
 / 	     \____/      \
|  (I2)   ____  (I3)  |
 \_	 _  _/	  \__  __/
   || ||         ||

        (Island 4)
*/





case class Island(id:Int)

case class Bridge(id:Int, lIsland: Island, rIsland: Island)

case class Graph(Islands: List[Island], Bridges: List[Bridge])

object Graph {
	
	def konigsbergBridges = {
		val island1 = Island(1)
		val island2 = Island(2)
		val island3 = Island(3)
		val island4 = Island(4)
		val bridge1 = Bridge(1, island2, island1)
		val bridge2 = Bridge(2, island2, island1)
		val bridge3 = Bridge(3, island2, island3)
		val bridge4 = Bridge(4, island4, island2)
		val bridge5 = Bridge(5, island4, island2)
		val bridge6 = Bridge(6, island4, island3)
		val bridge7 = Bridge(7, island3, island1)

		
		val islands = List(island1, island2, island3, island4)

		val bridges = List(bridge1, bridge2, bridge3, bridge4, bridge5, bridge6, bridge7)

		Graph(islands, bridges)
	}

	def konigsbergBridgesMap = {
		Map(1 -> (2, 1), 2 -> (2, 1), 3 -> (2, 3), 4 -> (4, 2), 5 -> (4, 2), 6 -> (4, 3), 7 -> (3, 1))
	}
}

