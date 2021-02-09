package cc.juddar.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RoundRobin {
    private static Integer pos = 0;

    public static String getServer() {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        //key 是IP value是权重
        Map<String, Integer> serverMap = new ConcurrentHashMap<>(IpMap.serverWeightMap);
        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        ArrayList<String> keyList = new ArrayList<>(keySet);
        String server = null;
        synchronized (RoundRobin.class) {
            if (pos >= keySet.size())
                pos = 0;
            server = keyList.get(pos);
            pos++;
        }
        return server;
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);

        service.execute(() -> {
            for (int i = 0; i < 13; i++) {
                System.err.println(RoundRobin.getServer());
            }
        });
    }

}

class IpMap {
    // 待路由的Ip列表，Key代表Ip，Value代表该Ip的权重
    public static ConcurrentHashMap<String, Integer> serverWeightMap = new ConcurrentHashMap<String, Integer>();

    static {
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.101", 1); // 权重为4
        serverWeightMap.put("192.168.1.102", 4);
        serverWeightMap.put("192.168.1.103", 1);
        serverWeightMap.put("192.168.1.104", 1); // 权重为3//
        serverWeightMap.put("192.168.1.105", 3);
        serverWeightMap.put("192.168.1.106", 1); // 权重为2
        serverWeightMap.put("192.168.1.107", 2);
        serverWeightMap.put("192.168.1.108", 1);
        serverWeightMap.put("192.168.1.109", 1);
        serverWeightMap.put("192.168.1.110", 1);
    }
}




