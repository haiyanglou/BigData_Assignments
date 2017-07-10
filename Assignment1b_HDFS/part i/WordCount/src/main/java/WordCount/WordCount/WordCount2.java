package WordCount.WordCount;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
import java.util.regex.Pattern;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount2 {

    public static class NumMapper extends Mapper<Object, Text, Text, LongWritable> {

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            String[] words = Pattern.compile("\\s*\\b\\s*").split(value.toString());
            long posCount = 0;
            long negCount = 0;
            for (String word : words) {
                if (AttWords.NEGATIVE.contains(word.toLowerCase())) {
                    negCount++;
                    //context.write(new Text("positive"), new LongWritable(posCount));
                } else if (AttWords.POSITIVE.contains(word.toLowerCase())) {
                    posCount++;
                    //context.write(new Text("negative"), new LongWritable(negCount));
                }
            }
            context.write(new Text("positive"), new LongWritable(posCount));
            context.write(new Text("negative"), new LongWritable(negCount));
        }
    }

    public static class NumReducer extends Reducer<Text, LongWritable, Text, LongWritable> {

        @Override
        public void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
            long sum = 0;
            Text outputkey = new Text();
            for (LongWritable val : values) {
                sum += val.get();
            }
            if (key.toString().equals("positive")) outputkey.set("Total count of positive words");
            else outputkey.set("Total count of negative words");
            context.write(outputkey, new LongWritable(sum));
        }
    }

    public static class NumCombiner extends Reducer<Text, LongWritable, Text, LongWritable> {
        @Override
        public void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
            long sum = 0;
            for (LongWritable val : values) {
                sum += val.get();
            }
            context.write(key, new LongWritable(sum));
        }
    }
    
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("mapred.job.tracker", "hdfs://cshadoop1:61120");
        conf.set("yarn.resourcemanager.address", "cshadoop1.utdallas.edu:8032");
        conf.set("mapreduce.framework.name", "yarn");
        Job job = Job.getInstance(conf, "Positive Lexicon Count");
        job.setJarByClass(WordCount2.class);
        job.setMapperClass(NumMapper.class);
        job.setCombinerClass(NumCombiner.class);
        job.setReducerClass(NumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}

