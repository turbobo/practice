package foundation;

import com.demo.jianzhiOffer.Main;
import foundation.ArrayFromToList;

/**
 * @Author Jusven
 * @Date 2021/5/26 15:44
 */
public class demo2 extends ArrayFromToList {
    public static void main(String[] args) {
        ArrayFromToList ss = new ArrayFromToList();
        System.out.println("ss.anInt = " + ss.anInt);

        //≤‚ ‘∂‡Ã¨
        Parent p = new Parent();
        p.print();

        Parent p1 = new Child1();
        p1.print();

        Parent p2 = new Child2();
        p2.print();
    }

}
