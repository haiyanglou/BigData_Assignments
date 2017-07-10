package assign2.yelp_stat;

import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;



public class Q1{
	
	public static class Q1Map extends Mapper<LongWritable, Text, Text, IntWritable>{
		
		@Override
		public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
			String delims = "^";
			String[] businessData = StringUtils.split(value.toString(),delims);
			
			if (businessData.length ==3) {
				if(businessData[1].contains("Palo Alto"))
					context.write(new Text(businessData[1]), new IntWritable(1));
			}		
		}
	
		@Override
		protected void setup(Context context)
				throws IOException, InterruptedException {
		}
	}

	public static class Reduce extends Reducer<Text,IntWritable,Text,IntWritable> {
		
		public void reduce(Text key, Iterable<IntWritable> values,Context context ) throws IOException, InterruptedException {
		
			int count=0;
			Iterator<IntWritable> iterator = values.iterator(); 
			while (iterator.hasNext()) {
				iterator.next();
				count++;
			}
			
			context.write(key,new IntWritable(count));
			
		}
	}

		
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();		
		String input = "/user/lxq160030/yelp/business.csv";
		if (otherArgs.length < 1) {
			System.err.println("please check the output dir");
			System.exit(2);
		}
			  
		Job job = Job.getInstance(conf, "Q1");
		job.setJarByClass(Q1.class);
	   
		job.setMapperClass(Q1Map.class);
		job.setReducerClass(Reduce.class);
		
				
		job.setOutputKeyClass(Text.class);
				
	
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputValueClass(IntWritable.class);
		
		
	
		FileInputFormat.addInputPath(job, new Path(input));
		
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[0]));
		
	
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}

	
	