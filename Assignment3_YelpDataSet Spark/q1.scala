val businessfile = sc.textFile("business.csv")

val business = businessfile.map(a=>a.split('^')).map(a=>(a(0),(a(0),a(1),a(2))))

val reviewfile = sc.textFile("review.csv")
val review = reviewfile.map(a=>a.split('^')).map(a=>(a(2),a(3).toDouble))
val reviewMedium = review.mapValues((_, 1))
val average1 = reviewMedium.reduceByKey((x,y)=>(x._1 + y._1, x._2 + y._2))
val average2 = average1.mapValues{case (sum, count) => (1.0 * sum) / count }

val afterjoin = average2.join(business)
val newmap = afterjoin.map(x=>(x._2._2, x._2._1))
val top10 = newmap.takeOrdered(10)(Ordering[Double].reverse.on(x=>x._2)).foreach(println)