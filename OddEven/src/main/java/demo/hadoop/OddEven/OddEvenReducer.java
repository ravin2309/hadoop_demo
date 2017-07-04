package demo.hadoop.OddEven;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class OddEvenReducer extends Reducer<IntWritable,StringIntValue,Text,Text>{
	
	String formated_line;
	String formated_rest_text;
	public void reduce(IntWritable line , Iterable<StringIntValue> value,Context con) throws IOException, InterruptedException
	{
		int even_count =0;
		int odd_count =0;
		 
		for(StringIntValue i : value)
		{
			if(i.getInd().contains("e"))
			{
				even_count+=i.getCount();
			}
			else
			{
				odd_count+=i.getCount();
			}
		}
		formated_line = "line"+line.toString()+" ";
		formated_rest_text= "totalEven:"+even_count+" "+"totalOdd:"+odd_count+" ";
		con.write(new Text(formated_line), new Text(formated_rest_text));
		
	}
	

}
