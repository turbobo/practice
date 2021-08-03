package foundation;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author Jusven
 * @Date 2021/6/5 20:19
 */
public class testLinkedHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("星期一", 40);
        map.put("星期二", 43);
        map.put("星期三", 35);
        map.put("星期四", 55);
        map.put("星期五", 45);
        map.put("星期六", 35);
        map.put("星期日", 30);
        map.put("fds",null);
        map.put("rew",null);
        map.put(null,44);
        for(Map.Entry m:map.entrySet()){
            System.out.println("HashMap-----m.getKey() + \" \" + m.getValue() = " + m.getKey() + " " + m.getValue());
        }

        LinkedHashMap<String, Integer> linkedHashMap22 = new LinkedHashMap<String, Integer>();
        linkedHashMap22.put("星期一", 40);
        linkedHashMap22.put("星期二", 43);
        linkedHashMap22.put("星期三", 35);
        linkedHashMap22.put("星期四", 55);
        linkedHashMap22.put("星期五", 45);
        linkedHashMap22.put("星期六", 35);
        linkedHashMap22.put("星期日", 30);
        for(Map.Entry m:linkedHashMap22.entrySet()){
            System.out.println("LinkedHashMap-----m.getKey() + \" \" + m.getValue() = " + m.getKey() + " " + m.getValue());
        }

        //这里accessOrder设置为false，表示不是访问顺序而是插入顺序存储的，这也是默认值
        // 第三个参数用于指定accessOrder值
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(16, 0.75f, false);
        linkedHashMap.put(1,"aaa");
        linkedHashMap.put(2,"aaa");
        linkedHashMap.put(3,"aaa");
        linkedHashMap.put(4,"aaa");
        System.out.println("linkedHashMap = " + linkedHashMap);
        for(Map.Entry m:linkedHashMap.entrySet()){
            System.out.println("get操作之前访问顺序" + m.getKey() + " " + m.getValue());
        }
        System.out.println("linkedHashMap.get(1) = " + linkedHashMap.get(1));
        // 1到最后
        for(Map.Entry m:linkedHashMap.entrySet()){
            System.out.println("get操作之后访问顺序" + m.getKey() + " " + m.getValue());
        }
    }
}
