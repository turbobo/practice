package foundation.summary;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Jusven
 * @Date 2023/3/10 10:16
 */
class Key {
    private Integer id;


    public Key(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Key)) {
            return false;
        } else {
            // 根据id确定是否为同一个对象
            return this.getId() == ((Key) o).getId();
        }
    }
}

public class WithoutHashCode {
    public static void main(String[] args) {
        Key key1 = new Key(1);
        Key key2 = new Key(1);

        Map hm = new HashMap();
        hm.put(key1, "key1 input");
//        hm.put(key2, "key2 input");

        //key2的id和 key1的id相同, hashmap认为是用一个
        // 首先key1 key2的id相同, 计算出来的hash值相同, hashcode方法结果相同;
        // 然后equals方法通过比较id的值, 返回结果也是相同
        System.out.println("hm.get(key2) = " + hm.get(key2));

    }

}
