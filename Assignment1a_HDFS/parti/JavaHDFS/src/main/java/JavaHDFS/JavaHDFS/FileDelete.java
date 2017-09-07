package JavaHDFS.JavaHDFS;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class FileDelete {
	public static void main(String[] args) throws Exception 
	 { 
	  if(args.length != 1){ 
	  System.out.println("Usage filedelete <target>"); 
	  System.exit(1); 
	  } 
	  Configuration conf = new Configuration(); 
	  FileSystem hdfs = FileSystem.get(URI.create(args[0]),conf); 
	  hdfs.delete(new Path(args[0]),false); 
	 } 
}
