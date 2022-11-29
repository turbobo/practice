package foundation.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: wangbo82
 * @Date: 2022��11��29�� 16:16
 *
 * Java8���ṩ��Stream�Լ��ϲ��������˼���ļ򻯣�ѧϰ��Stream֮�������Ժ���ʹ��forѭ�����ܶԼ��������ܺõĲ���
 */
public class StreamTest {

    public static void main(String[] args) {
        Stream stream = Stream.of("a", "b", "c");

        String [] strArray = new String[] {"a", "b", "c"};
        Stream stream2 = Stream.of(strArray);
        Stream stream3 = Arrays.stream(strArray);


        List<String> list = Arrays.asList(strArray);
        stream = list.stream();


//        1����������(map)��
//        ʹ��map�������Ա��������е�ÿ�����󣬲�������в�����map֮����.collect(Collectors.toList())��õ�������ļ��ϡ�

//        1.1������ת��Ϊ��д��
        List<String> output = list.stream().
                map(String::toUpperCase).
                collect(Collectors.toList());

//        1.2��ƽ������
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());


//        2�����˲���(filter)��
//        ʹ��filter���Զ���Stream�н��й��ˣ�ͨ�����Ե�Ԫ�ؽ�������������һ���µ�Stream��

//        2.1���õ����в�Ϊ�յ�String
        List<String> filterLists = new ArrayList<>();
        filterLists.add("");
        filterLists.add("a");
        filterLists.add("b");
        List afterFilterLists = filterLists.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

//        3��ѭ������(forEach):
//        ���ֻ��������е�ÿ���������һЩ�Զ���Ĳ���������ʹ��forEach��
//        List<String> forEachLists = new ArrayList<>();
//        forEachLists.add("a");
//        forEachLists.add("b");
//        forEachLists.add("c");
//        forEachLists.stream().forEach(s-> System.out.println(s));


//        4�������ض��Ľ�����ϣ�limit/skip����
//        limit ���� Stream ��ǰ�� n ��Ԫ�أ�skip �����ӵ�ǰ n ��Ԫ��:
        List<String> forEachLists = new ArrayList<>();
        forEachLists.add("a");
        forEachLists.add("b");
        forEachLists.add("c");
        forEachLists.add("d");
        forEachLists.add("e");
        forEachLists.add("f");
        List<String> limitLists = forEachLists.stream().skip(2).limit(3).collect(Collectors.toList());


//        5������sort/min/max/distinct����
//        sort���ԶԼ����е�����Ԫ�ؽ�������max��min����Ѱ�ҳ�������������С��Ԫ�أ���distinct����Ѱ�ҳ����ظ���Ԫ�أ�

//        5.1����һ�����Ͻ�������
        List<Integer> sortLists = new ArrayList<>();
        sortLists.add(1);
        sortLists.add(4);
        sortLists.add(6);
        sortLists.add(3);
        sortLists.add(2);
        List<Integer> afterSortLists = sortLists.stream().sorted((In1,In2)->
                In1-In2).collect(Collectors.toList());

//        5.2���õ����г�������Ԫ�أ�
        List<String> maxLists = new ArrayList<>();
        maxLists.add("a");
        maxLists.add("b");
        maxLists.add("c");
        maxLists.add("d");
        maxLists.add("e");
        maxLists.add("f");
        maxLists.add("hahaha");
        int maxLength = maxLists.stream().mapToInt(s -> s.length()).max().getAsInt();

//        5.3����һ�����Ͻ��в��أ�
        List<String> distinctList = new ArrayList<>();
        distinctList.add("a");
        distinctList.add("a");
        distinctList.add("c");
        distinctList.add("d");
        List<String> afterDistinctList = distinctList.stream().distinct().collect(Collectors.toList());
//        ���е�distinct()�������ҳ�stream��Ԫ��equal()������ͬ��Ԫ�أ�������ͬ��ȥ�����������ؼ�Ϊa,c,d��



//        6��ƥ��(Match����)��


//        6.1���жϼ�����û����Ϊ��c����Ԫ�أ�
        //allMatch  ����Ԫ�ض�Ҫ���� Ϊtrue
        //anyMatch  ֻҪ��һ��Ԫ������ Ϊtrue
        //noneMatch ����Ԫ�ض������� Ϊtrue
        List<String> matchList = new ArrayList<>();
        matchList.add("a");
        matchList.add("a");
        matchList.add("c");
        matchList.add("d");
        boolean isExits = matchList.stream().anyMatch(s -> s.equals("c"));





        System.out.println(stream);

    }
}
