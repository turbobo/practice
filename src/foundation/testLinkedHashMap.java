package foundation;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Jusven
 * @Date 2021/6/5 20:19
 */
public class testLinkedHashMap {
    public static void main(String[] args) {
        //这里accessOrder设置为false，表示不是访问顺序而是插入顺序存储的，这也是默认值
        // 第三个参数用于指定accessOrder值
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(16, 0.75f, true);
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
