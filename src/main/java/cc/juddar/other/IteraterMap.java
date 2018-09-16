package cc.juddar.other;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @Description 迭代map的方法
 *
 * @Author dasongju
 * @Date 2018/9/16 下午12:27
 */
public class IteraterMap {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");
        map.put("D", "4");

        IteraterMap.test01(map);
        System.err.println("\n\n");
        IteraterMap.test02(map);
        System.err.println("\n\n");
        IteraterMap.test03(map);
        System.err.println("\n\n");
        IteraterMap.test04(map);
        System.err.println("\n\n");
        IteraterMap.test05(map);
    }

    public static void test01(Map<String, String> map) {
        for (String key : map.keySet()) {
            System.err.println("key is-->"+ key + "  value is-->" +map.get(key));
        }
    }

    public static void test02(Map<String, String> map) {
        for (String value : map.values()) {
            System.err.print(value+ "--");
        }
    }

    public static void test03(Map<String, String> map) {
        Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Entry entry = iterator.next();
            System.err.println("key is-->"+ entry.getKey() + "  value is-->" +entry.getValue());
        }
    }

    public static void test04(Map<String, String> map) {
        for (Entry entry: map.entrySet()) {
            System.err.println("key is-->"+ entry.getKey() + "  value is-->" +entry.getValue());

        }
    }

    public static void test05(Map<String, String> map) {
        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }

}
