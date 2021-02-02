package cc.juddar;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author dasongju
 * @Date 2018/9/15 上午9:48
 */
public class TestLamda {

    public static void main(String[] args) {
        /*String str = "[\n"
            + "    {\n"
            + "      \"key\": \"job_name\",\n"
            + "      \"value\": \"保安\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"key\": \"gps_country\",\n"
            + "      \"value\": \"中国\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"key\": \"gps_province\",\n"
            + "      \"value\": \"广东省\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"key\": \"gps_city\",\n"
            + "      \"value\": \"广州市\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"key\": \"gps_district\",\n"
            + "      \"value\": \"海珠区\"\n"
            + "    }\n"
            + "  ]";
        Type[] type = new Type[]{};

        //第二个参数放的是List里对象的类型
        List<Params> maps = JSONArray.parseArray(str, Params.class);
        Map<String, String> collect = maps.stream()
            .collect(Collectors.toMap(Params::getKey, Params::getValue));
        System.err.println(collect.get("juddar"));*/

        String str = "";
        String[] split = str.split(",");
        System.err.println(Integer.parseInt(""));
        System.err.println(split.toString());
    }
}
