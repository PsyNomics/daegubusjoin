import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import wikibooks.hadoop.common.AirlinePerformanceParser;

public class MapperWithReduceSideJoin extends Mapper<LongWritable, Text, TaggedKey, Text> {

    TaggedKey outputKey = new TaggedKey();

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        BusStationDTO dto = new BusStationDTO(value);
        outputKey.setstationCode(dto.getStationID());
        outputKey.setTag(1);
        context.write(outputKey, value);
    }
}
