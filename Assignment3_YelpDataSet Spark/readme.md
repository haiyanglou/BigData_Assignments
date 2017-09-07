—readme file-
CS6350 Assignment3

1.Under terminal command, ssh into netid@cs6360.utdallas.edu cluster

2.Upload the 5 .scala files (q1.scala, q2.scala, q3.scala, q4.scala, q5.scala) into netid@cs6360.utdallas.edu cluster

3.Upload the 3 .csv files (review.csv, business.csv, user.csv) to netid@cs6360.utdallas.edu cluster, then put them into hdfs directory (with filecopywith progress function in assignment1 or use ‘-put’ function of hdfs) 


4.Get into the Spark-shell mode with command ‘spark-shell —-master yarn’ 

5.For all the 5 .scala files, typing command under “scala>” mode like 
“:load /pathtofile/q1.scala”. For example “:load /home/013/l/lx/lxq160030/q1.scala”

6.When running the q2.scala assignment, the process will stop and request user to type the user information in the console, after typing corrective username, type ‘Enter’ and the process will continue to process the requested information
