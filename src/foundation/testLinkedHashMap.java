package foundation;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Jusven
 * @Date 2021/6/5 20:19
 */
public class testLinkedHashMap {
    public static void main(String[] args) {
        //����accessOrder����Ϊfalse����ʾ���Ƿ���˳����ǲ���˳��洢�ģ���Ҳ��Ĭ��ֵ
        // ��������������ָ��accessOrderֵ
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(16, 0.75f, true);
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
