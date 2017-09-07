import org.apache.spark.graphx.GraphLoader
import org.apache.spark.graphx.{Graph, VertexRDD}
import org.apache.spark.graphx.util.GraphGenerators
import org.apache.spark._
import org.apache.spark.graphx._
import org.apache.spark.rdd.RDD


//Load the data into RDD
val textFile = sc.textFile("/FileStore/tables/rg0tle2q1500675003268/CA_HepTh-9cc05.txt").map(l=>l.split("\t"))


//Define a parser to identify and extract relevant fields
var vertices = textFile.map(l => (l(0).toLong,l(0))).distinct.collect
var edges = textFile.map(l => Edge(l(0).toLong,l(1).toLong,1)).collect


//Define edge and vertex structure and create property graphs
val vRdd = sc.parallelize(vertices)
var eRdd = sc.parallelize(edges)
val graph = Graph(vRdd,eRdd)


//Question a&b
def max(a: (VertexId, Int), b: (VertexId, Int)): (VertexId, Int) = {
  if (a._2 > b._2) a else b
}
val maxOutDegree: (VertexId, Int) = graph.outDegrees.reduce(max)
println(maxOutDegree)
val maxInDegree: (VertexId, Int)  = graph.inDegrees.reduce(max)
println(maxInDegree)


//Question c
val ranks = graph.pageRank(0.01).vertices
val topPages = ranks.takeOrdered(5)(Ordering[Double].reverse.on { x => x._2  })
topPages.foreach(println)


//Question d
val cc = graph.connectedComponents()
cc.vertices.collect()


//Question e
val triCounts = graph.triangleCount().vertices
triCounts.takeOrdered(5)(Ordering[Long].reverse.on { x => x._2  }).foreach(println)

