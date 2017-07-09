
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import com.google.gson.Gson;

public class Recipe {

	public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {

		private final static IntWritable one = new IntWritable(1);
		private Text word = new Text();
		Gson gson = new Gson();

		@Override
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			/*
			 * StringTokenizer itr = new StringTokenizer(value.toString());
			 * while (itr.hasMoreTokens()) { word.set(itr.nextToken());
			 * context.write(word, one); }
			 */

			Roo roo = gson.fromJson(value.toString(), Roo.class);
			if (roo.cookTime != null) {
				word.set(roo.cookTime);
			} else {
				word.set("none");
			}
			context.write(word, one);
		}
	}

	public static class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
		private IntWritable result = new IntWritable();

		@Override
		public void reduce(Text key, Iterable<IntWritable> values, Context context)
				throws IOException, InterruptedException {
			int sum = 0;
			for (IntWritable val : values) {
				sum += val.get();
			}
			result.set(sum);
			context.write(key, result);
		}
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
		/*
		 * for ( String string : otherArgs) { System.out.println(string); }
		 */
		if (otherArgs.length != 2) {
			System.err.println("Usage: recipe <in> <out>");
			System.exit(2);
		}
		@SuppressWarnings("deprecation")
		Job job = new Job(conf, "Recipe");

		job.setJarByClass(Recipe.class);
		job.setMapperClass(TokenizerMapper.class);
		job.setCombinerClass(IntSumReducer.class);
		job.setReducerClass(IntSumReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		// FileInputFormat.addInputPath(job, new
		// Path("hdfs://127.0.0.1:9000/in"));
		// FileOutputFormat.setOutputPath(job, new
		// Path("hdfs://127.0.0.1:9000/out"));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
		// job.submit();
	}
}

class Id {

	public String oid;
}

class Ts {

	public long date;
}

class Roo {

	public Id _id;

	public String name;

	public String ingredients;

	public String url;

	public String image;

	public Ts ts;

	public String cookTime;

	public String source;

	public String recipeYield;
	public String datePublished;

	public String prepTime;

	public String description;
}