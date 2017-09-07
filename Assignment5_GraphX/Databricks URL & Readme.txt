The Databricks URL are shown as following:
https://databricks-prod-cloudfront.cloud.databricks.com/public/4027ec902e239c93eaaa8714f173bcfc/1167720815458194/2527134825376891/7004078490200334/latest.html

The source code of this assignment is in file GraphX Code.scala
The output of queries are shown as following:

a&b.
(1441,65)
(1441,65)
max: (a: (org.apache.spark.graphx.VertexId, Int), b: (org.apache.spark.graphx.VertexId, Int))(org.apache.spark.graphx.VertexId, Int)
maxOutDegree: (org.apache.spark.graphx.VertexId, Int) = (1441,65)
maxInDegree: (org.apache.spark.graphx.VertexId, Int) = (1441,65)

c.
(1441,7.542003112017368)
(44262,6.654917036419066)
(19615,6.624893650521014)
(23420,6.536209062887099)
(30744,6.479397587155613)
ranks: org.apache.spark.graphx.VertexRDD[Double] = VertexRDDImpl[4671] at RDD at VertexRDD.scala:55
topPages: Array[(org.apache.spark.graphx.VertexId, Double)] = Array((1441,7.542003112017368), (44262,6.654917036419066), (19615,6.624893650521014), (23420,6.536209062887099), (30744,6.479397587155613))

d.
Array((880,1), (41008,39197), (17576,1), (45184,1), (31328,1),…) the remaining answers can be seen through Databricks URL Cmd 9 Output

e.
(39085,505)
(16278,469)
(6517,468)
(49074,466)
(6254,466)
triCounts: org.apache.spark.graphx.VertexRDD[Int] = VertexRDDImpl[6352] at RDD at VertexRDD.scala:55