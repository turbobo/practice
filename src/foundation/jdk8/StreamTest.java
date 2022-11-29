package foundation.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: wangbo82
 * @Date: 2022年11月29日 16:16
 *
 * Java8中提供了Stream对集合操作作出了极大的简化，学习了Stream之后，我们以后不用使用for循环就能对集合作出很好的操作
 */
public class StreamTest {

    public static void main(String[] args) {
        Stream stream = Stream.of("a", "b", "c");

        String [] strArray = new String[] {"a", "b", "c"};
        Stream stream2 = Stream.of(strArray);
        Stream stream3 = Arrays.stream(strArray);


        List<String> list = Arrays.asList(strArray);
        stream = list.stream();


//        1、遍历操作(map)：
//        使用map操作可以遍历集合中的每个对象，并对其进行操作，map之后，用.collect(Collectors.toList())会得到操作后的集合。

//        1.1、遍历转换为大写：
        List<String> output = list.stream().
                map(String::toUpperCase).
                collect(Collectors.toList());

//        1.2、平方数：
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());


//        2、过滤操作(filter)：
//        使用filter可以对象Stream中进行过滤，通过测试的元素将会留下来生成一个新的Stream。

//        2.1、得到其中不为空的String
        List<String> filterLists = new ArrayList<>();
        filterLists.add("");
        filterLists.add("a");
        filterLists.add("b");
        List afterFilterLists = filterLists.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

//        3、循环操作(forEach):
//        如果只是想对流中的每个对象进行一些自定义的操作，可以使用forEach：
//        List<String> forEachLists = new ArrayList<>();
//        forEachLists.add("a");
//        forEachLists.add("b");
//        forEachLists.add("c");
//        forEachLists.stream().forEach(s-> System.out.println(s));


//        4、返回特定的结果集合（limit/skip）：
//        limit 返回 Stream 的前面 n 个元素；skip 则是扔掉前 n 个元素:
        List<String> forEachLists = new ArrayList<>();
        forEachLists.add("a");
        forEachLists.add("b");
        forEachLists.add("c");
        forEachLists.add("d");
        forEachLists.add("e");
        forEachLists.add("f");
        List<String> limitLists = forEachLists.stream().skip(2).limit(3).collect(Collectors.toList());


//        5、排序（sort/min/max/distinct）：
//        sort可以对集合中的所有元素进行排序。max，min可以寻找出流中最大或者最小的元素，而distinct可以寻找出不重复的元素：

//        5.1、对一个集合进行排序：
        List<Integer> sortLists = new ArrayList<>();
        sortLists.add(1);
        sortLists.add(4);
        sortLists.add(6);
        sortLists.add(3);
        sortLists.add(2);
        List<Integer> afterSortLists = sortLists.stream().sorted((In1,In2)->
                In1-In2).collect(Collectors.toList());

//        5.2、得到其中长度最大的元素：
        List<String> maxLists = new ArrayList<>();
        maxLists.add("a");
        maxLists.add("b");
        maxLists.add("c");
        maxLists.add("d");
        maxLists.add("e");
        maxLists.add("f");
        maxLists.add("hahaha");
        int maxLength = maxLists.stream().mapToInt(s -> s.length()).max().getAsInt();

//        5.3、对一个集合进行查重：
        List<String> distinctList = new ArrayList<>();
        distinctList.add("a");
        distinctList.add("a");
        distinctList.add("c");
        distinctList.add("d");
        List<String> afterDistinctList = distinctList.stream().distinct().collect(Collectors.toList());
//        其中的distinct()方法能找出stream中元素equal()，即相同的元素，并将相同的去除，上述返回即为a,c,d。



//        6、匹配(Match方法)：


//        6.1、判断集合中没有有为‘c’的元素：
        //allMatch  所有元素都要满足 为true
        //anyMatch  只要有一个元素满足 为true
        //noneMatch 所有元素都不满足 为true
        List<String> matchList = new ArrayList<>();
        matchList.add("a");
        matchList.add("a");
        matchList.add("c");
        matchList.add("d");
        boolean isExits = matchList.stream().anyMatch(s -> s.equals("c"));





        System.out.println(stream);

    }
}
