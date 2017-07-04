package demo.hadoop.OddEven;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class StringIntValue implements Writable  {
	
	Text ind;
	public String getInd() {
		return ind.toString();
	}

	public void setInd(Text ind) {
		this.ind = new Text(ind);
	}

	IntWritable count;
	public int getCount() {
		return count.get();
	}

	public void setCount(int count) {
		this.count = new IntWritable(count);
	}

	public StringIntValue()
	{
		super();
		this.ind = new Text(" ");
		this.count= new IntWritable(0);
	}

	public StringIntValue(String ind, int count) {
		// TODO Auto-generated constructor stub
		super();
		this.ind = new Text(ind);
		this.count= new IntWritable(count);
	}

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		ind.readFields(in);
		count.readFields(in);
	}

	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		ind.write(out);
		count.write(out);
	}

	
	
	
}
