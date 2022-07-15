package foundation.summary;

import java.util.*;

/**
 * @author: wangbo82
 * @Date: 2022��07��15�� 19:28
 */
public class testCollections {
    public static void main(String[] args) {
        //
        List<String> list = new ArrayList<>();
        list.add("ɽ1");
        list.add("ɽ2");
        list.add("ɽ����ʦ���Ƶ�");
        list.add("Ŷ��Ϊ�Ϸ�����ݻ���");
        list.add("dhfsa");
        list.add("etw");
        list.add("dh232fsa");
        list.add("324523");
        list.add("����iɽ���");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(list.toArray()));
    }
}
