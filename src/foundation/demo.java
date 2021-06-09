package foundation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/5/24 11:45
 *
 * ������֮��ĵ�ֵ�жϣ������������Ͳ�����==���Ƚϣ���װ�������Ͳ����� equals ���жϡ�
 * BigDecimal
 */
public class demo {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(0.9);
        BigDecimal b = new BigDecimal(0.1);
        BigDecimal c = new BigDecimal(0.1);
        BigDecimal d = new BigDecimal(1.1);
        BigDecimal a_b = a.subtract(b);  //a - b = 0.8
        System.out.println(a.equals(b));
        System.out.println(c.equals(b));
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a_b = " + a_b);
        System.out.println("a.compareTo(b) = " + a.compareTo(b));
        System.out.println("a.compareTo(d) = " + a.compareTo(d));
        System.out.println("b.compareTo(c) = " + b.compareTo(c));


        //BigDecimal ������λС��
        BigDecimal m = new BigDecimal("1.255433");
        BigDecimal n = m.setScale(3,BigDecimal.ROUND_HALF_DOWN);
        System.out.println("n ���� 3λС�� = " + n);


        //����ת����
        int[] arr = {23,54,734};
        System.out.println("arr = " + Arrays.toString(arr));
        List<int[]> ints = Arrays.asList(arr);
        List<int[]> ints2 = new ArrayList<>(Arrays.asList(arr));
        List list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        System.out.println("ints = " + ints.toString());
        System.out.println("ints2 = " + ints2);
        System.out.println("list = " + list);
        String[] cc = {"a", "b", "c","d"};

        Object[] objects = ints.toArray();
        System.out.println("objects = " + objects.toString());

        List<String> list1 = Arrays.asList(cc);
        System.out.println("list1 = " + list1);


        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(1);
        arrayList.add(2);

        System.out.println("Collections.binarySearch(arrayList,7) = " + Collections.binarySearch(arrayList,-1));

        // *************���� binarySearch()****************
        char[] e = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        // ������ٽ��ж��ֲ��ң������Ҳ���
        Arrays.sort(e);
        System.out.println("Arrays.sort(e)" + Arrays.toString(e));
        System.out.println("Arrays.binarySearch(e, 'c')��");
        int s = Arrays.binarySearch(e, 'B');
        System.out.println("�ַ�c�������λ�ã�" + s);

        // *************���fill(������ʼ��)****************
        int[] g = { 1, 2, 3, 3, 3, 3, 6, 6, 6 };

        //��������
        int j[] = Arrays.copyOfRange(g, 0, 2);
        System.out.println("Arrays.toString(j) = " + Arrays.toString(j));

        // ����������Ԫ�����·���ֵ
         Arrays.fill(g, 3);
         System.out.println("Arrays.fill(g, 3)��");
//         ��������333333333
         for (int i : g) { System.out.print(i); }

         //��Χ���
        Arrays.fill(g, 0,g.length,-1);
        System.out.println("Arrays.toString(g) = " + Arrays.toString(g));


        ArrayFromToList ss = new ArrayFromToList();
        System.out.println("ss.anInt = " + ss.anInt);

        demo2 dd = new demo2();
        System.out.println(dd.anInt);
    }
}
