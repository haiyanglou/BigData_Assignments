Firstly, upload the three csv files (business, review, user) to hdfs://cshadoop1/user/lxq160030/yelp and I have already uploaded these three files into my utd cluster.

Then, import the Java project into eclipse and build up assign2.jar and upload it to cs6360.utdallas.edu cluster.

After that, type in the following command to execute Q1-Q5 and see the result of Q1-Q5:

hadoop jar assign2.jar assign2.yelp_stat.Q1 /user/lxq160030/assignment2/Q1
hdfs dfs -cat /user/lxq160030/assignment2/Q1/part-r-00000

hadoop jar assign2.jar assign2.yelp_stat.Q2 /user/lxq160030/assignment2/Q2
hdfs dfs -cat /user/lxq160030/assignment2/Q2/part-r-00000

hadoop jar assign2.jar assign2.yelp_stat.Q3 /user/lxq160030/assignment2/Q3
hdfs dfs -cat /user/lxq160030/assignment2/Q3/part-r-00000

hadoop jar assign2.jar assign2.yelp_stat.Q4 /user/lxq160030/assignment2/Q4
hdfs dfs -cat /user/lxq160030/assignment2/Q4/part-r-00000

hadoop jar assign2.jar assign2.yelp_stat.Q5 /user/lxq160030/assignment2/Q5
hdfs dfs -cat /user/lxq160030/assignment2/Q5/part-r-00000







