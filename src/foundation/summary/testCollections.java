package foundation.summary;

import java.util.*;

/**
 * @author: wangbo82
 * @Date: 2022年07月15日 19:28
 */
public class testCollections {
    public static void main(String[] args) {
        //
        List<String> list = new ArrayList<>();
        list.add("山1");
        list.add("山2");
        list.add("山大佛大师傅似的");
        list.add("哦我为合法的身份还是");
        list.add("dhfsa");
        list.add("etw");
        list.add("dh232fsa");
        list.add("324523");
        list.add("解耦i山大佛");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(list.toArray()));
    }
}
