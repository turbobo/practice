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
        map.put("����һ", 40);
        map.put("���ڶ�", 43);
        map.put("������", 35);
        map.put("������", 55);
        map.put("������", 45);
        map.put("������", 35);
        map.put("������", 30);
        map.put("fds",null);
        map.put("rew",null);
        map.put(null,44);
        for(Map.Entry m:map.entrySet()){
            System.out.println("HashMap-----m.getKey() + \" \" + m.getValue() = " + m.getKey() + " " + m.getValue());
        }

        LinkedHashMap<String, Integer> linkedHashMap22 = new LinkedHashMap<String, Integer>();
        linkedHashMap22.put("����һ", 40);
        linkedHashMap22.put("���ڶ�", 43);
        linkedHashMap22.put("������", 35);
        linkedHashMap22.put("������", 55);
        linkedHashMap22.put("������", 45);
        linkedHashMap22.put("������", 35);
        linkedHashMap22.put("������", 30);
        for(Map.Entry m:linkedHashMap22.entrySet()){
            System.out.println("LinkedHashMap-----m.getKey() + \" \" + m.getValue() = " + m.getKey() + " " + m.getValue());
        }

        //����accessOrder����Ϊfalse����ʾ���Ƿ���˳����ǲ���˳��洢�ģ���Ҳ��Ĭ��ֵ
        // ��������������ָ��accessOrderֵ
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(16, 0.75f, false);
        linkedHashMap.put(1,"aaa");
        linkedHashMap.put(2,"aaa");
        linkedHashMap.put(3,"aaa");
        linkedHashMap.put(4,"aaa");
        System.out.println("linkedHashMap = " + linkedHashMap);
        for(Map.Entry m:linkedHashMap.entrySet()){
            System.out.println("get����֮ǰ����˳��" + m.getKey() + " " + m.getValue());
        }
        System.out.println("linkedHashMap.get(1) = " + linkedHashMap.get(1));
        // 1�����
        for(Map.Entry m:linkedHashMap.entrySet()){
            System.out.println("get����֮�����˳��" + m.getKey() + " " + m.getValue());
        }
    }
}
