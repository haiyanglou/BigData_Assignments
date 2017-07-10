val reviewfile = sc.textFile("review.csv")
val review = reviewfile.map(a=>a.split('^')).map(a=>(a(1),a(3).toDouble))

val reviewMedium = review.mapValues((_, 1))
val average1 = reviewMedium.reduceByKey((x,y)=>(x._1 + y._1, x._2 + y._2))
val average2 = average1.mapValues{case (sum, count) => (1.0 * sum) / count }

val userfile = sc.textFile("user.csv")

val content = Console.readLine()

val user = userfile.map(a=>a.split('^')).filter(a=>a(1).contains(content)).map(a=>(a(0),a(1)))

val afterjoin = user.join(average2)
val newMap = afterjoin.map(x=>((x._2._1, x._1),x._2._2)).sortBy(_._2, false)

newMap.collect().foreach(println)
