package demo.hadoop.OddEven;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class OddEvenDriver extends Configured implements Tool {
	public static void main(String[] args) throws Exception
	{
		int res = ToolRunner.run(new OddEvenDriver(), args);
		System.exit(res);
	}

	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Job job = Job.getInstance(getConf(),"OddEven");
		job.setJarByClass(this.getClass());
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setMapperClass(OddEvenMapper.class);
		job.setReducerClass(OddEvenReducer.class);
		
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(StringIntValue.class);
		
		return job.waitForCompletion(true) ? 0:1;
		//return 0;
	}

}
