package foundation.summary;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Author Jusven
 * @Date 2023/4/18 19:18
 */
public class compateUtil {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("ggg", "daf");
        map.put("aa", "daf");
        for(Map.Entry<String, String> m : map.entrySet()) {
            System.out.println(m.getKey() + " --- " + m.getValue());
        }
        List<Map.Entry<String, String>> list = new ArrayList(map.entrySet());
        //使用Collections.sort()排序，compareTo比较大小
//        Collections.sort(list, (o1, o2) -> (o1.getKey().compareTo(o2.getKey())));
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o2.getKey().compareTo(o1.getKey());
            }
        });

        for(Map.Entry<String, String> m : list) {
            System.out.println(m.getKey() + " --- " + m.getValue());
        }
    }
}


