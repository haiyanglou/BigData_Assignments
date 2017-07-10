This readme file is used to illustrate how to execute the programs of assignment1 partii.
Firstly, import the JavaHDFS project in eclipse, and then right click label JavaHDFS, select Run As Maven build. 
This will generate a jar file called JavaHDFS-0.0.1-SNAPSHOT.jar in target directory.
Copy this JavaHDFS-0.0.1-SNAPSHOT.jar file from target directory into My Home directory in Remote Systems and open the Ssh Shells. 

In order to download the corpus Linear text Wikipedia: 1.8 mw, please type commands as following:
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.Test http://corpus.byu.edu/wikitext-samples/text.zip /home/013/l/lx/lxq160030”

In order to decompress the corpus Linear text Wikipedia: 1.8 mw, please type commands as following:
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.Main /home/013/l/lx/lxq160030/text.zip /home/013/l/lx/lxq160030”

In order to upload the corpus Linear text Wikipedia: 1.8 mw to HDFS directory called assignment1, please type commands as following:
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileCopyWithProgress text.txt hdfs://cshadoop1/user/lxq160030/assignment1/text.txt”

Then type “hfs bfs -ls /user/lxq160030/assignment1, and we can see that the corpus Linear text Wikipedia: 1.8 mw is in the HDFS directory.／／／





