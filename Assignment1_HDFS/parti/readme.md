This readme file is used to illustrate how to execute the programs of assignment1 parti.
Firstly, import the JavaHDFS project in eclipse, and then right click label JavaHDFS, select Run As Maven build. 
This will generate a jar file called JavaHDFS-0.0.1-SNAPSHOT.jar in target directory.
Copy this JavaHDFS-0.0.1-SNAPSHOT.jar file from target directory into My Home directory in Remote Systems and open the Ssh Shells. 

In order to download all six book files, please type commands as following:
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.Test http://www.utdallas.edu/~axn112530/cs6350/lab2/input/20417.txt.bz2 /home/013/l/lx/lxq160030” 
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.Test http://www.utdallas.edu/~axn112530/cs6350/lab2/input/5000-8.txt.bz2 /home/013/l/lx/lxq160030”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.Test http://www.utdallas.edu/~axn112530/cs6350/lab2/input/132.txt.bz2 /home/013/l/lx/lxq160030”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.Test http://www.utdallas.edu/~axn112530/cs6350/lab2/input/1661-8.txt.bz2 /home/013/l/lx/lxq160030”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.Test http://www.utdallas.edu/~axn112530/cs6350/lab2/input/972.txt.bz2 /home/013/l/lx/lxq160030”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.Test http://www.utdallas.edu/~axn112530/cs6350/lab2/input/19699.txt.bz2 /home/013/l/lx/lxq160030”

In order to upload all six book files to HDFS directory called assignment1, please type commands as following:
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileCopyWithProgress 20417.txt.bz2 hdfs://cshadoop1/user/lxq160030/assignment1/20417.txt.bz2”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileCopyWithProgress 5000-8.txt.bz2 hdfs://cshadoop1/user/lxq160030/assignment1/5000-8.txt.bz2”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileCopyWithProgress 132.txt.bz2 hdfs://cshadoop1/user/lxq160030/assignment1/132.txt.bz2”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileCopyWithProgress 1661-8.txt.bz2 hdfs://cshadoop1/user/lxq160030/assignment1/1661-8.txt.bz2”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileCopyWithProgress 972.txt.bz2 hdfs://cshadoop1/user/lxq160030/assignment1/972.txt.bz2”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileCopyWithProgress 19699.txt.bz2 hdfs://cshadoop1/user/lxq160030/assignment1/19699.txt.bz2”

In order to decompress all six book files, please type commands as following:
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileDecompressor hdfs://cshadoop1/user/lxq160030/assignment1/19699.txt.bz2”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileDecompressor hdfs://cshadoop1/user/lxq160030/assignment1/132.txt.bz2”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileDecompressor hdfs://cshadoop1/user/lxq160030/assignment1/1661-8.txt.bz2”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileDecompressor hdfs://cshadoop1/user/lxq160030/assignment1/20417.txt.bz2”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileDecompressor hdfs://cshadoop1/user/lxq160030/assignment1/5000-8.txt.bz2”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileDecompressor hdfs://cshadoop1/user/lxq160030/assignment1/972.txt.bz2”

In order to delete all six zip files after finishing decompressing, please type commands as following:
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileDelete hdfs://cshadoop1/user/lxq160030/assignment1/972.txt.bz2”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileDelete hdfs://cshadoop1/user/lxq160030/assignment1/5000-8.txt.bz2”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileDelete hdfs://cshadoop1/user/lxq160030/assignment1/20417.txt.bz2”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileDelete hdfs://cshadoop1/user/lxq160030/assignment1/19699.txt.bz2”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileDelete hdfs://cshadoop1/user/lxq160030/assignment1/1661-8.txt.bz2”
“hadoop jar JavaHDFS-0.0.1-SNAPSHOT.jar JavaHDFS.JavaHDFS.FileDelete hdfs://cshadoop1/user/lxq160030/assignment1/132.txt.bz2”

Then type “hfs bfs -ls /user/lxq160030/assignment1, and we can see that all six .txt files are in the HDFS directory.






