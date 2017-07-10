val businessfile = sc.textFile("business.csv")
val business = businessfile.map(a=>a.split('^')).filter(a=>a(1).contains("Stanford")).map(a=>(a(0),""))

val reviewfile = sc.textFile("review.csv")
val review = reviewfile.map(a=>a.split('^')).map(a=>(a(2),(a(1),a(3))))

val afterjoin = business.join(review)
val result = afterjoin.map(x=>(x._2))

result.collect().foreach(println)