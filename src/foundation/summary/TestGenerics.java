package foundation.summary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangbo82
 * @Date: 2022��06��20�� 18:54
 */
public class TestGenerics {
    public static void main(String[] args) {

        List a = new ArrayList<>();
        //���ӷ��ͣ���Ӳ�ͬ�������ݲ���������
        a.add("����");
        a.add(123);
        System.out.println(a.toString());


        List a2 = new ArrayList<>();
        a.add("hello");
        String a21 = (String) a2.get(0);

        List<String> a3 = new ArrayList<>();
        a3.add("hello");
        String a31 = a3.get(0);
    }
}
