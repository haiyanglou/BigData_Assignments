val reviewfile = sc.textFile("review.csv")

val review = reviewfile.map(a=>a.split('^')).map(a=>(a(1),a(1)))
val userfile = sc.textFile("user.csv")
val user = userfile.map(a=>a.split('^')).map(a=>(a(0),a(1)))

val afterjoin = review.join(user)

val result = afterjoin.map(x=>(x._2, 1))
val topTen = result.reduceByKey(_+_).takeOrdered(10)(Ordering[Int].reverse.on(x=>x._2)).foreach(println)
