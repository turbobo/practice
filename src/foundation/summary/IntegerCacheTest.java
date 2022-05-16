package foundation.summary;

/**
 * @author: wangbo82
 * @Date: 2022Äê05ÔÂ16ÈÕ 15:09
 */
public class IntegerCacheTest {

    public static void main(String[] args) {
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        Integer i3 = new Integer(128);

        Integer i4 = 127;
        Integer i5 = 127;
        Integer i6 = 128;
        System.out.println(System.identityHashCode(i1));
        System.out.println(System.identityHashCode(i2));
        System.out.println(System.identityHashCode(i3));
        System.out.println(System.identityHashCode(i4));
        System.out.println(System.identityHashCode(i5));
        System.out.println(System.identityHashCode(i6));
    }
}
