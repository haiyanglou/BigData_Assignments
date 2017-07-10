val businessfile = sc.textFile("business.csv")

val business = businessfile.map(a=>a.split('^')).filter(a=>a(1).contains("TX")).map(a=>(a(0),a(0)))

val reviewfile = sc.textFile("review.csv")

val review = reviewfile.map(a=>a.split('^')).map(a=>(a(2),a(2)))

val afterjoin = review.join(business)
val result = afterjoin.map(x=>(x._1, 1))

val count = result.reduceByKey(_+_)

count.collect().foreach(println)