package demo.hadoop.OddEven;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class OddEvenMapper extends Mapper<LongWritable,Text,IntWritable,StringIntValue> {
	
	int i =0,line=0;
	int count_even=0;
	int count_odd = 0;
	public void map(LongWritable offset,Text linetext,Context con) throws IOException, InterruptedException
	{
		i = (int) offset.get();
		if(i>0)
		{
			line++;
		}
		
		for(String temp:linetext.toString().split(","))
		{
			if(Integer.parseInt(temp)%2==0)
			{
				count_even++;
			}
			else
			{
				count_odd++;
			}
		}
		con.write(new IntWritable(line), new StringIntValue("e",count_even));
		con.write(new IntWritable(line), new StringIntValue("o",count_odd));
		
	}
}
